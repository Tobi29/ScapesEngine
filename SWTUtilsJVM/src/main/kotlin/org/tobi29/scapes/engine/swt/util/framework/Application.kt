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
package org.tobi29.scapes.engine.swt.util.framework

import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.CoroutineDispatcher
import kotlinx.coroutines.experimental.Runnable
import org.eclipse.swt.SWT
import org.eclipse.swt.program.Program
import org.eclipse.swt.widgets.Display
import org.eclipse.swt.widgets.Shell
import org.tobi29.scapes.engine.swt.util.platform.*
import org.tobi29.scapes.engine.swt.util.widgets.Dialogs
import org.tobi29.scapes.engine.utils.Crashable
import org.tobi29.scapes.engine.utils.Version
import org.tobi29.scapes.engine.utils.io.*
import org.tobi29.scapes.engine.utils.io.filesystem.FilePath
import org.tobi29.scapes.engine.utils.io.filesystem.createTempFile
import org.tobi29.scapes.engine.utils.io.filesystem.write
import org.tobi29.scapes.engine.utils.logging.KLogging
import org.tobi29.scapes.engine.utils.sleepAtLeast
import kotlin.coroutines.experimental.CoroutineContext
import kotlin.system.exitProcess

abstract class Application(
        name: String,
        id: String,
        version: Version,
        val taskExecutor: CoroutineContext = CommonPool
) : CoroutineDispatcher(), Runnable, Crashable {
    val display: Display

    init {
        Display.setAppName(name)
        Display.setAppVersion(version.toString())
        display = Display.getDefault()
    }

    fun message(style: Int,
                title: String,
                message: String): Int {
        val shell = activeShell ?: return 0
        return Dialogs.openMessage(shell, style, title, message)
    }

    val activeShell: Shell?
        get() {
            val shell = display.activeShell
            if (shell == null) {
                val shells = display.shells
                if (shells.isEmpty()) {
                    return null
                }
                return shells[0]
            }
            return shell
        }

    fun access(runnable: () -> Unit) {
        display.syncExec(runnable)
    }

    fun accessAsync(runnable: () -> Unit) {
        display.asyncExec(runnable)
    }

    override fun run() {
        try {
            initApplication()
            while (!done()) {
                if (!display.readAndDispatch()) {
                    display.sleep()
                }
            }
            display.dispose()
            disposeApplication()
        } catch (e: Throwable) {
            crash(e)
        }
    }

    fun done(): Boolean {
        return display.isDisposed || display.shells.isEmpty()
    }

    fun initApplication() {
        init()
    }

    fun disposeApplication() {
        dispose()
    }

    override fun crash(e: Throwable): Nothing {
        logger.error(e) { "Application crashed:" }
        val path = writeCrash(e) ?: exitProcess(1)
        if (!Program.launch(path.toString())) {
            display.asyncExec {
                Program.launch(path.toString())
                exitProcess(1)
            }
            sleepAtLeast(1000)
        }
        exitProcess(1)
    }

    override fun dispatch(context: CoroutineContext,
                          block: Runnable) {
        display.asyncExec(block)
    }

    private fun writeCrash(e: Throwable): FilePath? {
        try {
            val path = createTempFile("CrashReport", ".txt")
            write(path) {
                it.writeCrashReport(e, "SWT Application",
                        crashReportSectionStacktrace(e),
                        crashReportSectionActiveThreads(),
                        crashReportSectionSystemProperties())
            }
            return path
        } catch (e1: IOException) {
        }
        return null
    }

    protected abstract fun init()

    protected abstract fun dispose()

    companion object : KLogging() {
        val platform: Platform

        init {
            when (SWT.getPlatform()) {
                "gtk" -> platform = PlatformLinux()
                "cocoa" -> platform = PlatformMacOSX()
                "win32" -> platform = PlatformWindows()
                else -> {
                    logger.warn { "Unknown SWT platform: ${SWT.getPlatform()}" }
                    platform = PlatformUnknown()
                }
            }
        }
    }
}
