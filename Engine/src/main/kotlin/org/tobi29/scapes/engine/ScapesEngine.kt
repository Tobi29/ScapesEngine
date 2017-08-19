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

package org.tobi29.scapes.engine

import kotlinx.coroutines.experimental.CoroutineDispatcher
import kotlinx.coroutines.experimental.Runnable
import org.tobi29.scapes.engine.graphics.GraphicsSystem
import org.tobi29.scapes.engine.gui.*
import org.tobi29.scapes.engine.gui.debug.GuiWidgetDebugValues
import org.tobi29.scapes.engine.gui.debug.GuiWidgetPerformance
import org.tobi29.scapes.engine.gui.debug.GuiWidgetProfiler
import org.tobi29.scapes.engine.resource.ResourceLoader
import org.tobi29.scapes.engine.sound.SoundSystem
import org.tobi29.scapes.engine.utils.*
import org.tobi29.scapes.engine.utils.io.ByteBuffer
import org.tobi29.scapes.engine.utils.io.ByteBufferProvider
import org.tobi29.scapes.engine.utils.io.FileSystemContainer
import org.tobi29.scapes.engine.utils.logging.KLogging
import org.tobi29.scapes.engine.utils.tag.MutableTagMap
import org.tobi29.scapes.engine.utils.task.TaskExecutor
import org.tobi29.scapes.engine.utils.task.UpdateLoop
import kotlin.coroutines.experimental.CoroutineContext

header class ScapesEngine(
        backend: (ScapesEngine) -> Container,
        defaultGuiStyle: (ScapesEngine) -> GuiStyle,
        taskExecutor: TaskExecutor,
        configMap: MutableTagMap
) : CoroutineDispatcher, ComponentHolder<Any>, ByteBufferProvider {
    override val componentStorage: ComponentStorage<Any>
    val taskExecutor: TaskExecutor
    val loop: UpdateLoop
    val files: FileSystemContainer
    val events: EventDispatcher
    val resources: ResourceLoader
    val container: Container
    val graphics: GraphicsSystem
    val sounds: SoundSystem
    val guiStyle: GuiStyle
    val guiStack: GuiStack
    var guiController: GuiController
    val notifications: GuiNotifications
    val tooltip: GuiTooltip
    val debugValues: GuiWidgetDebugValues
    val profiler: GuiWidgetProfiler
    val performance: GuiWidgetPerformance
    val state: GameState

    override fun dispatch(context: CoroutineContext,
                          block: Runnable)

    fun switchState(state: GameState)
    fun start()
    fun halt()
    fun dispose()
    fun debugMap(): Map<String, String>
    fun isMouseGrabbed(): Boolean

    override fun allocate(capacity: Int): ByteBuffer
    override fun reallocate(buffer: ByteBuffer): ByteBuffer

    header companion object : KLogging {
        val CONFIG_MAP_COMPONENT: ComponentTypeRegistered<ScapesEngine, MutableTagMap, Any>
    }
}

interface ComponentLifecycle : ComponentRegistered {
    fun start() {}
    fun halt() {}
}

interface ComponentStep {
    fun step(delta: Double) {}
}
