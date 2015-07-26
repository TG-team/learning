package jp.co.technica.imple.make_interface.select.process;

import java.io.Closeable;
import java.io.IOException;

public abstract class AbsTrasfer implements Transfer {

    private ProgressListener listener;
    protected Transfer.State state = Transfer.State.Waiting;

    @Override
    public boolean isDone() {
        return (state == Transfer.State.Failed
                || state == Transfer.State.Completed || state == Transfer.State.Canceled);
    }

    @Override
    public State getState() {
        return state;
    }

    @Override
    public void addProgressCallback(ProgressListener listener) {
        this.listener = listener;
    }

    @Override
    public void removeProgressCallback() {
        this.listener = null;
    }

    protected void onProgress(Transfer.State state, int progress) {
        if (listener != null) {
            listener.onProgress(state, progress);
        }
    }

    protected static void silentClose(Closeable closeable) {
        if (closeable == null) {
            return;
        }

        try {
            closeable.close();
        } catch (IOException e) {
        }
    }
}
