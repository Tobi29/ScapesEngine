/*
 * Copyright 2012-2017 Tobi29
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.tobi29.scapes.engine.backends.lwjgl3.glfw

import org.lwjgl.glfw.*
import org.lwjgl.opengl.GL
import org.lwjgl.opengl.GL11
import org.lwjgl.opengles.GLES
import org.lwjgl.system.MemoryStack
import org.lwjgl.system.Platform
import org.tobi29.scapes.engine.*
import org.tobi29.scapes.engine.backends.lwjgl3.ContainerLWJGL3
import org.tobi29.scapes.engine.backends.lwjgl3.push
import org.tobi29.scapes.engine.graphics.GraphicsCheckException
import org.tobi29.scapes.engine.graphics.GraphicsException
import org.tobi29.scapes.engine.gui.GuiController
import org.tobi29.scapes.engine.input.*
import org.tobi29.scapes.engine.utils.ConcurrentHashMap
import org.tobi29.scapes.engine.utils.EventDispatcher
import org.tobi29.scapes.engine.utils.io.filesystem.FilePath
import org.tobi29.scapes.engine.utils.logging.KLogging
import org.tobi29.scapes.engine.utils.math.clamp
import org.tobi29.scapes.engine.utils.profiler.profilerSection
import org.tobi29.scapes.engine.utils.sleepNanos
import org.tobi29.scapes.engine.utils.steadyClock
import org.tobi29.scapes.engine.utils.tag.toMap
import org.tobi29.scapes.engine.utils.task.Timer
import org.tobi29.scapes.engine.utils.task.processCurrent
import kotlin.math.max
import kotlin.math.roundToInt

class ContainerGLFW(
        private val title: String,
        private val emulateTouch: Boolean = false,
        private val density: Double = if (emulateTouch) 1.0 / 3.0 else 1.0,
        useGLES: Boolean = false
) : ContainerLWJGL3(useGLES) {
    override var containerWidth = 0
        private set
    override var containerHeight = 0
        private set
    private val controllerDefault = GLFWControllerDefault()
    private val virtualJoysticks = ConcurrentHashMap<Int, ControllerJoystick>()
    private val errorFun = GLFWErrorCallback.createPrint()
    internal var window = 0L
        private set
    private var refreshRate = 60
    private var contentWidth = 0
    private var contentHeight = 0
    private var mouseX = 0.0
    private var mouseY = 0.0
    private var running = true
    private var valid = false
    private var visible = false
    private var focus = true
    private var mouseGrabbed = false
    private var mouseDeltaSkip = true
    private var plebSyncEnable = true

    init {
        GLFW.glfwSetErrorCallback(errorFun)
        if (!GLFW.glfwInit()) {
            throw GraphicsException("Unable to initialize GLFW")
        }
        logger.info { "GLFW version: ${GLFW.glfwGetVersionString()}" }
    }

    override val formFactor = Container.FormFactor.DESKTOP

    override fun updateContainer() {
        valid = false
    }

    override fun update(delta: Double) {
    }

    override fun run(engine: ScapesEngine) {
        val controllers = GLFWControllers(engine.events, virtualJoysticks)
        val windowSizeFun = GLFWWindowSizeCallback.create { _, width, height ->
            containerWidth = (width * density).roundToInt()
            containerHeight = (height * density).roundToInt()
        }
        val windowCloseFun = GLFWWindowCloseCallback.create { stop() }
        val windowFocusFun = GLFWWindowFocusCallback.create { _, focused -> focus = focused }
        val frameBufferSizeFun = GLFWFramebufferSizeCallback.create { _, width, height ->
            contentWidth = width
            contentHeight = height
        }
        val keyFun = GLFWKeyCallback.create { _, key, _, action, _ ->
            val virtualKey = GLFWKeyMap.key(key)
            if (virtualKey != null) {
                if (virtualKey == ControllerKey.KEY_BACKSPACE && action != GLFW.GLFW_RELEASE) {
                    controllerDefault.addTypeEvent(127.toChar())
                }
                when (action) {
                    GLFW.GLFW_PRESS -> controllerDefault.addPressEvent(
                            virtualKey, ControllerBasic.PressState.PRESS)
                    GLFW.GLFW_REPEAT -> controllerDefault.addPressEvent(
                            virtualKey, ControllerBasic.PressState.REPEAT)
                    GLFW.GLFW_RELEASE -> controllerDefault.addPressEvent(
                            virtualKey, ControllerBasic.PressState.RELEASE)
                }
            }
            if (key == GLFW.GLFW_KEY_GRAVE_ACCENT && action == GLFW.GLFW_PRESS) {
                plebSyncEnable = !plebSyncEnable
            }
        }
        val charFun = GLFWCharCallback.create { _, codepoint ->
            controllerDefault.addTypeEvent(codepoint.toChar())
        }
        val mouseButtonFun = GLFWMouseButtonCallback.create { _, button, action, _ ->
            val virtualKey = ControllerKey.button(button)
            if (virtualKey != null) {
                when (action) {
                    GLFW.GLFW_PRESS -> controllerDefault.addPressEvent(
                            virtualKey, ControllerBasic.PressState.PRESS)
                    GLFW.GLFW_RELEASE -> controllerDefault.addPressEvent(
                            virtualKey, ControllerBasic.PressState.RELEASE)
                }
            }
        }
        val cursorPosFun = GLFWCursorPosCallback.create { window, xpos, ypos ->
            val dx = xpos - mouseX
            val dy = ypos - mouseY
            if (dx != 0.0 || dy != 0.0) {
                if (mouseGrabbed) {
                    GLFW.glfwSetCursorPos(window, 0.0, 0.0)
                    mouseX = 0.0
                    mouseY = 0.0
                } else {
                    controllerDefault.set(xpos * density, ypos * density)
                    mouseX = xpos
                    mouseY = ypos
                }
                if (mouseDeltaSkip) {
                    mouseDeltaSkip = false
                } else {
                    controllerDefault.addDelta(dx, dy, engine)
                }
            }
        }
        val scrollFun = GLFWScrollCallback.create { _, xoffset, yoffset ->
            if (xoffset != 0.0 || yoffset != 0.0) {
                controllerDefault.addScroll(xoffset, yoffset)
            }
        }
        val monitorFun = GLFWMonitorCallback.create { _, _ ->
            refreshRate = Companion.refreshRate(window) ?: 60
        }
        GLFW.glfwSetMonitorCallback(monitorFun)
        val latencyDebug = engine.debugValues["Input-Latency"]
        val plebSyncDebug = engine.debugValues["PlebSync™-Sleep"]
        var plebSync = 0L
        var controllerEmulateTouch: ControllerTouch? = null
        if (emulateTouch) {
            controllerEmulateTouch = object : ControllerTouch {
                private var tracker: ControllerTouch.Tracker? = null

                override fun fingers(): Sequence<ControllerTouch.Tracker> {
                    return tracker?.let { sequenceOf(it) } ?: emptySequence()
                }

                override fun poll(events: EventDispatcher) {
                    controllerDefault.poll(events)
                    val tracker = tracker
                    if (tracker != null) {
                        if (controllerDefault.isDown(ControllerKey.BUTTON_0)) {
                            tracker.pos.set(controllerDefault.x(),
                                    controllerDefault.y())
                        } else {
                            this.tracker = null
                        }
                    } else if (controllerDefault.isPressed(
                            ControllerKey.BUTTON_0)) {
                        val newTracker = ControllerTouch.Tracker()
                        newTracker.pos.set(controllerDefault.x(),
                                controllerDefault.y())
                        this.tracker = newTracker
                    }
                }
            }
            engine.events.fire(ControllerAddEvent(controllerEmulateTouch))
        } else {
            engine.events.fire(ControllerAddEvent(controllerDefault))
        }
        val timer = Timer()
        timer.init()
        var tickDiff = 0L
        while (running) {
            val start = steadyClock.timeSteadyNanos()
            val engineConfig = engine[ScapesEngineConfig.COMPONENT]
            val vSync = engineConfig.vSync
            tasks.processCurrent()
            if (!valid) {
                engine.graphics.reset()
                controllerDefault.clearStates()
                visible = false
                if (window != 0L) {
                    GLFW.glfwDestroyWindow(window)
                }
                window = initWindow(engine, title, engineConfig.fullscreen,
                        engineConfig.vSync, useGLES, windowSizeFun,
                        windowCloseFun, windowFocusFun, frameBufferSizeFun,
                        keyFun, charFun, mouseButtonFun, cursorPosFun,
                        scrollFun)
                refreshRate = refreshRate(window) ?: 60
                val stack = MemoryStack.stackGet()
                stack.push {
                    val widthBuffer = stack.mallocInt(1)
                    val heightBuffer = stack.mallocInt(1)
                    GLFW.glfwGetWindowSize(window, widthBuffer, heightBuffer)
                    containerWidth = (widthBuffer.get(0) * density).roundToInt()
                    containerHeight = (heightBuffer.get(
                            0) * density).roundToInt()
                    GLFW.glfwGetFramebufferSize(window, widthBuffer,
                            heightBuffer)
                    contentWidth = widthBuffer.get(0)
                    contentHeight = heightBuffer.get(0)
                }
                valid = true
                if (mouseGrabbed) {
                    mouseX = containerWidth / density * 0.5
                    mouseY = containerHeight / density * 0.5
                    controllerDefault.set(mouseX, mouseY)
                }
            }
            if (plebSync > 0) {
                sleepNanos(plebSync)
            }
            val time = steadyClock.timeSteadyNanos()
            GLFW.glfwPollEvents()
            controllers.poll()
            val swap = profilerSection("Render") {
                engine.graphics.render(gl,
                        Timer.toDelta(tickDiff).coerceIn(0.0001, 0.1),
                        contentWidth, contentHeight)
            }
            val mouseGrabbed = !emulateTouch && engine.isMouseGrabbed()
            if (mouseGrabbed != this.mouseGrabbed) {
                this.mouseGrabbed = mouseGrabbed
                mouseX = containerWidth / density * 0.5
                mouseY = containerHeight / density * 0.5
                if (mouseGrabbed) {
                    GLFW.glfwSetInputMode(window, GLFW.GLFW_CURSOR,
                            GLFW.GLFW_CURSOR_DISABLED)
                    mouseDeltaSkip = true
                } else {
                    mouseX = containerWidth / density * 0.5
                    mouseY = containerHeight / density * 0.5
                    GLFW.glfwSetInputMode(window, GLFW.GLFW_CURSOR,
                            GLFW.GLFW_CURSOR_NORMAL)
                    GLFW.glfwSetCursorPos(window, mouseX, mouseY)
                }
                controllerDefault.set(mouseX, mouseY)
            }
            if (vSync) {
                tickDiff = timer.tick()
            } else {
                tickDiff = timer.cap(Timer.toDiff(engineConfig.fps),
                        ::sleepNanos)
            }
            if (swap) {
                GLFW.glfwSwapBuffers(window)
                if (!visible) {
                    GLFW.glfwShowWindow(window)
                    visible = true
                }
            }
            if (vSync && plebSyncEnable) {
                val maxDiff = 1000000000L / refreshRate
                val latency = steadyClock.timeSteadyNanos() - time
                val delta = steadyClock.timeSteadyNanos() - start
                val targetDelta = max(maxDiff - latency - PLEB_SYNC_GAP, 0L)
                val diff = delta - targetDelta
                plebSync = clamp(plebSync + diff, 0L, targetDelta)
                latencyDebug.setValue(latency / 1000000L)
                plebSyncDebug.setValue(plebSync)
            } else {
                plebSync = 0L
            }
        }
        controllerEmulateTouch?.let {
            engine.events.fire(ControllerRemoveEvent(it))
        }
        if (!emulateTouch) {
            engine.events.fire(ControllerRemoveEvent(controllerDefault))
        }
        logger.info { "Disposing graphics system" }
        engine.graphics.dispose(gl)
        GLFW.glfwDestroyWindow(window)
        GLFW.glfwTerminate()
        windowSizeFun.close()
        windowCloseFun.close()
        windowFocusFun.close()
        frameBufferSizeFun.close()
        keyFun.close()
        charFun.close()
        mouseButtonFun.close()
        cursorPosFun.close()
        scrollFun.close()
    }

    override fun stop() {
        running = false
    }

    override fun clipboardCopy(value: String) {
        GLFW.glfwSetClipboardString(window, value)
    }

    override fun clipboardPaste(): String {
        return GLFW.glfwGetClipboardString(window)
    }

    override fun message(messageType: Container.MessageType,
                         title: String,
                         message: String) {
        exec {
            PlatformDialogs.message(this, messageType, title, message)
        }
    }

    override fun dialog(title: String,
                        text: GuiController.TextFieldData,
                        multiline: Boolean) {
        exec {
            PlatformDialogs.dialog(this, title, text, multiline)
        }
    }

    override fun isRenderCall() = Thread.currentThread() == mainThread

    companion object : KLogging() {
        private val PLEB_SYNC_GAP = when (Platform.get()) {
        // Causes severe lag on Windows, but obviously Windows is THE
        // best "gaming" OS
        // Platform.WINDOWS -> 40000L
            else -> 20000L
        }

        fun openFile(path: FilePath) {
            PlatformDialogs.openFile(path)
        }

        private fun initWindow(engine: ScapesEngine,
                               title: String,
                               fullscreen: Boolean,
                               vSync: Boolean,
                               useGLES: Boolean,
                               windowSizeFun: GLFWWindowSizeCallback,
                               windowCloseFun: GLFWWindowCloseCallback,
                               windowFocusFun: GLFWWindowFocusCallback,
                               frameBufferSizeFun: GLFWFramebufferSizeCallback,
                               keyFun: GLFWKeyCallback,
                               charFun: GLFWCharCallback,
                               mouseButtonFun: GLFWMouseButtonCallback,
                               cursorPosFun: GLFWCursorPosCallback,
                               scrollFun: GLFWScrollCallback): Long {
            val stack = MemoryStack.stackGet()
            stack.push {
                logger.info { "Creating GLFW window..." }
                val monitor = GLFW.glfwGetPrimaryMonitor()
                val videoMode = GLFW.glfwGetVideoMode(monitor)
                val monitorWidth = videoMode.width()
                val monitorHeight = videoMode.height()
                val window = if (useGLES) {
                    GLFW.glfwDefaultWindowHints()
                    initContextGLES()
                    val window = initWindow(title, fullscreen, monitor,
                            monitorWidth, monitorHeight)
                    GLFW.glfwMakeContextCurrent(window)
                    GLES.createCapabilities()
                    checkContextGLES()?.let { throw GraphicsCheckException(it) }
                    window
                } else {
                    GLFW.glfwDefaultWindowHints()
                    initContextGL()
                    var window = initWindow(title, fullscreen, monitor,
                            monitorWidth, monitorHeight)
                    GLFW.glfwMakeContextCurrent(window)
                    GL.createCapabilities()
                    val tagMap = engine[ScapesEngine.CONFIG_MAP_COMPONENT]["Compatibility"]?.toMap()
                    workaroundLegacyProfile(tagMap)?.let {
                        logger.warn { "Detected problem with using a core profile on this driver: $it" }
                        logger.warn { "Recreating window with legacy context..." }
                        GLFW.glfwDestroyWindow(window)
                        GLFW.glfwDefaultWindowHints()
                        initContextGL(true)
                        window = initWindow(title, fullscreen, monitor,
                                monitorWidth, monitorHeight)
                        GLFW.glfwMakeContextCurrent(window)
                        GL.createCapabilities()
                    }
                    checkContextGL()?.let { throw GraphicsCheckException(it) }
                    window
                }
                GLFW.glfwSetWindowSizeCallback(window, windowSizeFun)
                GLFW.glfwSetWindowCloseCallback(window, windowCloseFun)
                GLFW.glfwSetWindowFocusCallback(window, windowFocusFun)
                GLFW.glfwSetFramebufferSizeCallback(window, frameBufferSizeFun)
                GLFW.glfwSetKeyCallback(window, keyFun)
                GLFW.glfwSetCharCallback(window, charFun)
                GLFW.glfwSetMouseButtonCallback(window, mouseButtonFun)
                GLFW.glfwSetCursorPosCallback(window, cursorPosFun)
                GLFW.glfwSetScrollCallback(window, scrollFun)
                GLFW.glfwSwapInterval(if (vSync) 1 else 0)
                return window
            }
        }

        private fun initContextGL(contextLegacy: Boolean = false) {
            if (!contextLegacy) {
                GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3)
                GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 3)
                GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_PROFILE,
                        GLFW.GLFW_OPENGL_CORE_PROFILE)
                GLFW.glfwWindowHint(GLFW.GLFW_OPENGL_FORWARD_COMPAT,
                        GL11.GL_TRUE)
            }
        }

        private fun initContextGLES() {
            GLFW.glfwWindowHint(GLFW.GLFW_CLIENT_API, GLFW.GLFW_OPENGL_ES_API)
            GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MAJOR, 3)
            GLFW.glfwWindowHint(GLFW.GLFW_CONTEXT_VERSION_MINOR, 0)
        }

        private fun initWindow(title: String,
                               fullscreen: Boolean,
                               monitor: Long,
                               monitorWidth: Int,
                               monitorHeight: Int): Long {
            GLFW.glfwWindowHint(GLFW.GLFW_VISIBLE, GL11.GL_FALSE)
            // >:V Seriously, stop with this crap!
            GLFW.glfwWindowHint(GLFW.GLFW_AUTO_ICONIFY, GL11.GL_FALSE)
            return if (fullscreen) {
                val window = GLFW.glfwCreateWindow(monitorWidth, monitorHeight,
                        title, monitor, 0L)
                if (window == 0L) {
                    throw GraphicsCheckException(
                            "Failed to create fullscreen window")
                }
                window
            } else {
                val width: Int
                val height: Int
                if (monitorWidth > 1280 && monitorHeight > 720) {
                    width = 1280
                    height = 720
                } else {
                    width = 960
                    height = 540
                }
                val window = GLFW.glfwCreateWindow(width, height, title, 0L, 0L)
                if (window == 0L) {
                    throw GraphicsCheckException("Failed to create window")
                }
                window
            }
        }

        private fun refreshRate(window: Long): Int? {
            val monitor = GLFW.glfwGetWindowMonitor(window)
            if (monitor != 0L) {
                return GLFW.glfwGetVideoMode(monitor).refreshRate()
            }
            val monitors = GLFW.glfwGetMonitors()
            if (!monitors.hasRemaining()) {
                return null
            }
            // We use the maximum refresh rate to avoid slowing rendering in
            // case of different rates
            // GLFW sadly does not seem to support fetching the current monitor
            // of non-fullscreen windows
            val firstMonitor = monitors.get()
            var refreshRate = GLFW.glfwGetVideoMode(firstMonitor).refreshRate()
            while (monitors.hasRemaining()) {
                val otherMonitor = monitors.get()
                val otherRefreshRate = GLFW.glfwGetVideoMode(
                        otherMonitor).refreshRate()
                refreshRate = max(refreshRate, otherRefreshRate)
            }
            return refreshRate
        }
    }
}
