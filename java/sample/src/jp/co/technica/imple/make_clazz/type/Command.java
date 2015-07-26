package jp.co.technica.imple.make_clazz.type;

import java.io.IOException;

public enum Command {

    DIR {
        @Override
        public void execute() {
            try {
                Utils.output(runtime.exec("cmd /C dir"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    },
    IP_ADDRESS {
        @Override
        public void execute() {
            try {
                Utils.output(runtime.exec("ipconfig"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };

    Runtime runtime = Runtime.getRuntime();

    public abstract void execute();

}
