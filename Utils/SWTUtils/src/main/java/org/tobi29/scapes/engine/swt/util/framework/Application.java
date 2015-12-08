package org.tobi29.scapes.engine.swt.util.framework;

import java8.util.Optional;
import org.eclipse.swt.program.Program;
import org.eclipse.swt.widgets.Display;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.tobi29.scapes.engine.swt.util.platform.Platform;
import org.tobi29.scapes.engine.swt.util.platform.PlatformLinux;
import org.tobi29.scapes.engine.utils.Crashable;
import org.tobi29.scapes.engine.utils.SleepUtil;
import org.tobi29.scapes.engine.utils.io.filesystem.CrashReportFile;
import org.tobi29.scapes.engine.utils.io.filesystem.FilePath;
import org.tobi29.scapes.engine.utils.io.filesystem.FileUtil;
import org.tobi29.scapes.engine.utils.task.TaskExecutor;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Application implements Runnable, Crashable {
    protected static final Platform PLATFORM;
    private static final Logger LOGGER =
            LoggerFactory.getLogger(Application.class);

    static {
        // TODO: Pick based on SWT implementation
        PLATFORM = new PlatformLinux();
    }

    protected final Display display;
    protected final TaskExecutor taskExecutor;

    protected Application(String name, String id, String version) {
        Display.setAppName(name);
        Display.setAppVersion(version);
        display = Display.getDefault();
        taskExecutor = new TaskExecutor(this, id);
    }

    public static Platform platform() {
        return PLATFORM;
    }

    public Display display() {
        return display;
    }

    public TaskExecutor taskExecutor() {
        return taskExecutor;
    }

    @Override
    public void run() {
        try {
            init();
            while (display.getShells().length > 0) {
                if (!display.readAndDispatch()) {
                    display.sleep();
                }
            }
            dispose();
            taskExecutor.shutdown();
        } catch (Throwable e) {
            crash(e);
        }
        display.dispose();
    }

    @SuppressWarnings("CallToSystemExit")
    @Override
    public void crash(Throwable e) {
        Optional<FilePath> report = writeCrash(e);
        if (!report.isPresent()) {
            System.exit(1);
            return;
        }
        FilePath path = report.get();
        if (!Program.launch(path.toString())) {
            display.asyncExec(() -> {
                Program.launch(path.toString());
                System.exit(1);
            });
            SleepUtil.sleepAtLeast(1000);
            System.exit(1);
        }
    }

    private Optional<FilePath> writeCrash(Throwable e) {
        try {
            FilePath path = FileUtil.createTempFile("CrashReport", ".txt");
            Map<String, String> debugValues = new ConcurrentHashMap<>();
            CrashReportFile
                    .writeCrashReport(e, path, "ScapesEngine", debugValues);
            return Optional.of(path);
        } catch (IOException e1) {
        }
        return Optional.empty();
    }

    protected abstract void init();

    protected abstract void dispose();
}
