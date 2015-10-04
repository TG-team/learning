package jp.co.technica.imple.make_method.modifier.other;

import jp.co.technica.imple.make_method.modifier.my.MyClass;

public class OtherPacSubClass extends MyClass {

    public void otherPacSubTest() {
		/* クラス名出力 */
		System.out.println("クラス名：" + getClass().getName());

		/* メソッド実行 */
		MyClass.publicMethod();

		MyClass.protectedMethod();

		//MyClass.method();					同じパッケージ内でのみアクセス可能のためコンパイルエラー
		System.out.println(" non Access NG");
		System.out.println(" ※他パッケージクラスの為アクセス不可");

		//MyClass.privateMethod();			同じクラス内でのみアクセス可能のためコンパイルエラー
		System.out.println(" private Access NG");
		System.out.println(" ※他クラスの為アクセス不可");

		System.out.println("");
    }

}
