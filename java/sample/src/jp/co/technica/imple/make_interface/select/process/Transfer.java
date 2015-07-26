package jp.co.technica.imple.make_interface.select.process;

public interface Transfer {

    public enum State {
        Waiting, InProgress, Completed, Canceled, Failed;
    }

    void execute();

    boolean isDone();

    State getState();

    void addProgressCallback(ProgressListener listener);

    void removeProgressCallback();

}
