package jp.co.technica.oop.polymorphism.override;

/**
 * ばあさん
 * */
public class Baba implements HumanBehavior{

	@Override
	public void outPrintThisName() {
		System.out.println("ばあさんです。");
	}

	@Override
	public void runTheWork() {
		System.out.println("川へ洗濯に行きます。");
		int point = 100;
		System.out.println("衛生度が上昇!!  ポイント : " + point);

		InternationalSituation.getInstance().addSanitary(point);

	}
}
