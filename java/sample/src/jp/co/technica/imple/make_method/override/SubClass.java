package jp.co.technica.imple.make_method.override;

public class SubClass  extends SuperClass{

	@Override
	public void disp(){
		System.out.println(" SubClassのメソッド(オーバーライド)");
	}

/*
public static void dispFinal(){										//SuperClassでfinal宣言している為、
        System.out.println(" SubClassのメソッド(オーバーライド)");	//コンパイルエラーとなる
	}
*/

}
