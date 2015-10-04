package jp.co.technica.imple.make_method.modifier.my;

public class MyClass {

	public void test(){

		/* クラス名出力 */
		System.out.println("クラス名：" + getClass().getName());

		/* メソッド実行 */
		MyClass.publicMethod();

		MyClass.protectedMethod();

		MyClass.method();

		MyClass.privateMethod();

		System.out.println("");
	}

	public static void publicMethod(){
		System.out.println(" public Access OK !!");
		System.out.println(" ※全てのクラスからアクセス可能");
	}

	protected static void protectedMethod(){
		System.out.println(" protected Access OK !!");
		System.out.println(" ※同パッケージクラス、もしくは、MyClass継承クラスからアクセス可能");
	}

	static void method(){
		System.out.println(" non Access OK !!");
		System.out.println(" ※同パッケージクラスからアクセス可能");
	}

	private static void privateMethod(){
		System.out.println(" private Access OK !!");
		System.out.println(" ※同クラスからアクセス可能");
	}
}
