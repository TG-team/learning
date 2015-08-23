package jp.co.technica.imple.make_method.override;

public class SuperClass {

	public void test(){

		/* クラス名出力 */
		 System.out.println(getClass().getSimpleName());

		/* メソッド実行 */
		this.disp();
		this.dispFinal();

		System.out.println("");
	}

	/* finalなしメソッド */
	public void disp(){
		System.out.println(" SuperClassのメソッド");
	}

	/* finalありメソッド */
	public final void dispFinal(){
		System.out.println(" SuperClassのメソッド");
	}

}
