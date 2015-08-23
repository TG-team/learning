package jp.co.technica.imple.make_method.modifier.my;

public class SubClass  extends MyClass  {

    public void subTest() {
		/* クラス名出力 */
		System.out.println("クラス名：" + getClass().getName());

		/* メソッド実行 */
		MyClass.publicMethod();

		MyClass.protectedMethod();

		MyClass.method();

		//MyClass.privateMethod();		同じクラス内でのみアクセス可能のためコンパイルエラー
		System.out.println(" private Access NG");
		System.out.println(" ※他クラスの為アクセス不可");

		System.out.println("");
    }
}
