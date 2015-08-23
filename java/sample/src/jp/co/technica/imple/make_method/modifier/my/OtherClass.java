package jp.co.technica.imple.make_method.modifier.my;

public class OtherClass {

    public static void other_test() {
        System.out.println("OtherClass");

        MyClass.public_method();
        MyClass.protected_method();
        MyClass.method();
        //MyClass.private_method();		他クラスの為アクセス不可
        System.out.println(" private Access NG");

        System.out.println("");
    }
}
