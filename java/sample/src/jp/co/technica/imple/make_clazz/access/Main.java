package jp.co.technica.imple.make_clazz.access;

import jp.co.technica.imple.make_clazz.access.packages.A;

public class Main {

    public static void main(String[] args) {

        A a = new A();
        B b = new B();
        // B_Sub b_sub = new B_Sub();
        C c = new C();
        D d = new D();
    }

    private static class C {
        private int a;
    }

    protected static class D {
        private int d;
    }

}
