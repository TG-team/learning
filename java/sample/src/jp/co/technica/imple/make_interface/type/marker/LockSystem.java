package jp.co.technica.imple.make_interface.type.marker;

public class LockSystem {

    private static final LockSystem INSTANCE = new LockSystem();
    private State state = State.Lock;

    public enum State {
        Lock, Unlock,
    }

    private LockSystem() {
    }

    public static LockSystem getInstance() {
        return INSTANCE;
    }

    public synchronized <T extends Unlockable> boolean unlock(T card) {
        if (State.Lock.equals(state)) {
            state = State.Unlock;
            System.out.println("Unlock Success. : " + card);
            return true;
        } else {
            System.out.println("Already unlocked. : " + card);
            return false;
        }
    }

    public synchronized <T extends Lockable> boolean lock(T card) {
        if (State.Unlock.equals(state)) {
            state = State.Lock;
            System.out.println("Lock Success. : " + card);
            return true;
        } else {
            System.out.println("Already locked. : " + card);
            return false;
        }
    }

    public synchronized State getState() {
        return state;
    }
}
