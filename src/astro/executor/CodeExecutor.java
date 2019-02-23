package astro.executor;

import javafx.scene.control.TextArea;

import java.io.File;
import java.util.Objects;

public class CodeExecutor {

    public static void execute(File source, TextArea outputArea){
        if (Objects.nonNull(source)) {
            Thread executeThread = new Thread(() -> {
                new Executor().executeJava(source, new OnExecuteListener() {
                    @Override
                    public void onCompileFailure() {
                        String message = "Compile is Failure\n";
                        outputArea.setText(message);
                    }

                    @Override
                    public void onExecutorFailure() {
                        String message = "Build is Failure\n";
                        outputArea.setText(message);
                    }

                    @Override
                    public void onExecutorSuccess(String output) {
                        String message = "Build is Success\n".concat(output);
                        outputArea.setText(message);
                    }
                });
            });
            executeThread.setPriority(Thread.MAX_PRIORITY);
            executeThread.start();
        }
    }
}
