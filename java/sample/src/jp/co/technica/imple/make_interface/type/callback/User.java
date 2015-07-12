package jp.co.technica.imple.make_interface.type.callback;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class User {

    private ExecutorService service = Executors.newSingleThreadExecutor();

    public void onClickButton(Button button) {
        if (button != null) {
            service.submit(button);
        }
    }
}
