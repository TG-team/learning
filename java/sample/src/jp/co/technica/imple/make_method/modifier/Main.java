package jp.co.technica.imple.make_method.modifier;

import jp.co.technica.imple.make_method.modifier.my.MyClass;
import jp.co.technica.imple.make_method.modifier.my.OtherClass;
import jp.co.technica.imple.make_method.modifier.my.SubClass;
import jp.co.technica.imple.make_method.modifier.other.OtherPacClass;
import jp.co.technica.imple.make_method.modifier.other.OtherPacSubClass;

public class Main {
	public static void main(String[] args) {

		/* インスタンス作成 */
		MyClass myclass						= new MyClass();
		SubClass subclass					= new SubClass();
		OtherClass otherclass				= new OtherClass();
		OtherPacClass otherpacclass			= new OtherPacClass();
		OtherPacSubClass otherpacsubclass	= new OtherPacSubClass();

		/* メソッド実行 */
		myclass.test();
		subclass.subTest();
		otherclass.otherTest();
		otherpacclass.otherPacTest();
		otherpacsubclass.otherPacSubTest();

    }
}
