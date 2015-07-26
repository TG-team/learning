package jp.co.technica.imple.make_clazz.limit;

public class Main {

    public static void main(String[] args) {

        // Singleton1 singleton1_0 = new Singleton1();
        Singleton1 singleton1_1 = Singleton1.getInstance();
        Singleton1 singleton1_2 = Singleton1.getInstance();
        if (singleton1_1 == singleton1_2) {
            System.out.println("singleton1_1とsingleton1_2は同じインスタンスです。");
        } else {
            System.out.println("singleton1_1とsingleton1_2は違うインスタンスです。");
        }

        // Singleton2 singleton2_0 = new Singleton2();
        Singleton2 singleton2_1 = Singleton2.getInstance();
        Singleton2 singleton2_2 = Singleton2.getInstance();
        if (singleton2_1 == singleton2_2) {
            System.out.println("singleton2_1とsingleton2_2は同じインスタンスです。");
        } else {
            System.out.println("singleton2_1とsingleton2_2は違うインスタンスです。");
        }

        // Singleton3 singleton3_0 = new Singleton3();
        Singleton3 singleton3_1 = Singleton3.getInstance();
        Singleton3 singleton3_2 = Singleton3.getInstance();
        if (singleton3_1 == singleton3_2) {
            System.out.println("singleton3_1とsingleton3_2は同じインスタンスです。");
        } else {
            System.out.println("singleton3_1とsingleton3_2は違うインスタンスです。");
        }

        // Singleton4 singleton4_0 = new Singleton4();
        Singleton4 singleton4_1 = Singleton4.getInstance();
        Singleton4 singleton4_2 = Singleton4.getInstance();
        if (singleton4_1 == singleton4_2) {
            System.out.println("singleton4_1とsingleton4_2は同じインスタンスです。");
        } else {
            System.out.println("singleton4_1とsingleton4_2は違うインスタンスです。");
        }

    }

}
