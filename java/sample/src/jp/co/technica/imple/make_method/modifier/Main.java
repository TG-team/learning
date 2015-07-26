package jp.co.technica.imple.make_method.modifier;

import jp.co.technica.imple.make_method.modifier.my.MyClass;
import jp.co.technica.imple.make_method.modifier.my.OtherClass;
import jp.co.technica.imple.make_method.modifier.my.SubClass;
import jp.co.technica.imple.make_method.modifier.other.OhterPacSubClass;
import jp.co.technica.imple.make_method.modifier.other.OtherPacClass;

public class Main {
	public static void main(String[] args) {

        MyClass.test();
        SubClass.sub_test();
        OtherClass.other_test();

        OtherPacClass.other_package_test();
        OhterPacSubClass.other_package_sub_test();
    }
}
