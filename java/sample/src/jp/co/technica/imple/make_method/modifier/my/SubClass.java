package jp.co.technica.imple.make_method.modifier.my;

public class SubClass  extends MyClass  {

    public static void sub_test() {
        System.out.println("SubClass");

        MyClass.public_method();
        MyClass.protected_method();
        MyClass.method();
        //MyClass.private_method();		他クラスの為アクセス不可
        System.out.println(" private Access NG");

        System.out.println("");
    }
}
