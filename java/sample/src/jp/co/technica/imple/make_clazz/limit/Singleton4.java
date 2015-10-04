package jp.co.technica.imple.make_clazz.limit;

public class Singleton4 {

    private static class InstanceManager {
        private static final Singleton4 INSTANCE = new Singleton4();
    }

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        return InstanceManager.INSTANCE;
    }

}
