package jp.co.technica.imple.make_method.modifier.my;

public class MyClass {

	public static void test(){
        System.out.println("MyClass");

        MyClass.public_method();
        MyClass.protected_method();
        MyClass.method();
        MyClass.private_method();

        System.out.println("");
	}

	public static void public_method(){
        System.out.println(" public Access OK !!");
	}

	protected static void protected_method(){
        System.out.println(" protected Access OK !!");
	}

	 static void method(){
        System.out.println(" non Access OK !!");
	}

	private static void private_method(){
        System.out.println(" private Access OK !!");
	}
}
