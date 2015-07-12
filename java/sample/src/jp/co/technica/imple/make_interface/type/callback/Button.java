package jp.co.technica.imple.make_interface.type.callback;

import java.util.concurrent.Callable;

public class Button implements Callable<Void> {

    private OnClickCallback callback;

    public interface OnClickCallback {
        void onClick();
    }

    public void setOnClickCallback(OnClickCallback callback) {
        this.callback = callback;
    }

    @Override
    public Void call() throws Exception {
        if (callback != null) {
            callback.onClick();
        } else{
            System.out.println("Please set callback");
        }
        return null;
    }

}
