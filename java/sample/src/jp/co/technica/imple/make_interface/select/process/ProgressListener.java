package jp.co.technica.imple.make_interface.select.process;

public interface ProgressListener {

    void onProgress(Transfer.State state, int progress);

}
