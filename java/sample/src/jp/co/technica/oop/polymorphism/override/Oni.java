package jp.co.technica.oop.polymorphism.override;


/**
 * 鬼<br>
 * HumanBehaviorインターフェースと同じメソッドを持っているが、<br>
 * HumanBehaviorをインプリメントしていないので、HumanBehaviorとして振舞うことができない。
 * */
public class Oni{

	public void outPrintThisName(){
		System.out.println("おにです。");
	}

	public void runThaWork(){
		System.out.println("仲間を連れてきます。");
		int demonCount = 2000;
		System.out.println("鬼はたくさん仲間を連れてきた!!  鬼の連れてきた数 : " + demonCount);
		InternationalSituation.getInstance().addDemonCount(demonCount);
	}
}
