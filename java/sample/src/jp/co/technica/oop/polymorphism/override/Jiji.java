package jp.co.technica.oop.polymorphism.override;

/**
 * じいさん
 * */
public class Jiji implements HumanBehavior{

	@Override
	public void outPrintThisName() {
		System.out.println("じいさんです。");
	}

	@Override
	public void runThaWork() {
		System.out.println("山に柴刈りに行きます。");
		int item = 100;
		System.out.println("資材を獲得!!  数 : " + item);
		InternationalSituation.getInstance().addMaterial(item);
	}
}
