package jp.co.technica.oop.polymorphism.override;

/**
 * ももたろう
 * */
public class Momotaro implements HumanBehavior {

	@Override
	public void outPrintThisName() {
		System.out.println("ももたろうです。");
	}

	@Override
	public void runThaWork() {
		System.out.println("ちょっと鬼を分からせてきます。");
		demonExtermination();
	}

	/**
	 * 追い討ちを行います。
	 * */
	public void chaseOut(){
		System.out.println("まだ分かってないようですね。");
		demonExtermination();
	}

	/**
	 * 鬼を成敗します。
	 * */
	private void demonExtermination(){
		InternationalSituation is = InternationalSituation.getInstance();
		is.subtractDemonCount(25);
		System.out.println("鬼 25体 撃破!!");
	}

}
