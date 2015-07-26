package jp.co.technica.imple.make_interface.select.process.upload;

import jp.co.technica.imple.make_interface.select.process.AbsTrasfer;

public class Upload extends AbsTrasfer {

    @Override
    public void execute() {
        onProgress(State.Waiting, 0);

        try {
            for (int progress = 0; progress < 100; progress++) {
                Thread.sleep(100);
                onProgress(State.InProgress, progress);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        onProgress(State.Completed, 100);
    }
}
