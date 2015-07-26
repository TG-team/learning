package jp.co.technica.imple.make_clazz.limit;

public class Singleton3 {

    private static Singleton3 INSTANCE;

    private Singleton3() {
    }

    public static synchronized Singleton3 getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton3();
        }
        return INSTANCE;
    }

}
