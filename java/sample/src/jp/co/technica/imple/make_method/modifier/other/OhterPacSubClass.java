package jp.co.technica.imple.make_method.modifier.other;

import jp.co.technica.imple.make_method.modifier.my.MyClass;

public class OhterPacSubClass extends MyClass {

    public static void other_package_sub_test() {
        System.out.println("OtherPackageSubClass");

        MyClass.public_method();
        MyClass.protected_method();
        //MyClass.method();					他パッケージの為アクセス不可
        System.out.println(" non Access NG");
        //MyClass.private_method();			他クラスの為アクセス不可
        System.out.println(" private Access NG");

        System.out.println("");
    }

}
