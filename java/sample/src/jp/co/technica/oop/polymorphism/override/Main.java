package jp.co.technica.oop.polymorphism.override;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args){
		Main me = new Main();

		//addされるクラスインスタンスは全てHumanBehaviorをインプリメントしているので、
		//アップキャストが可能である。(アップキャストの場合、キャストを明示的に行う必要がない)
		me.list.add((HumanBehavior)new Jiji());
		me.list.add(new Baba());
		me.list.add(new Momotaro());
//		me.list.add(new Oni());
//			型 List<HumanBehavior> のメソッド add(HumanBehavior) は引数 (Oni) に適用できません
		//シナリオ開始
		me.scenario();
	}



	//登場人物を入れるリスト
	private List<HumanBehavior> list = new ArrayList<>();
	/**
	 * シナリオ<br>
	 * 登場人物すべてに仕事をさせ、適当なタイミングで国際情勢を出力させます。
	 * */
	private void scenario(){
		InternationalSituation is = InternationalSituation.getInstance();
		is.outPrintStatus(); //国際情勢を確認
		kaigyo();

		//登場人物に名前を出力させ、それぞれの仕事をさせてみる。
		for(HumanBehavior hb : list){
			hb.outPrintThisName();
			hb.runThaWork();
			kaigyo();

			is.outPrintStatus(); //国際情勢を確認
			kaigyo();
		}

		//Momotaroだけに限定し、独自の振る舞いを行わせる。
		for(HumanBehavior hb : list){
			if(hb instanceof Momotaro){ //listから取り出された「hb」の中身（実態）は
										//12～14行で生成されたクラス型のインスタンスである。
				Momotaro momo = (Momotaro)hb;	//ダウンキャストの場合はキャストを明示的に行う必要がある。
				momo.outPrintThisName();
				momo.chaseOut();
				kaigyo();
				is.outPrintStatus(); //国際情勢を確認
			}
		}
	}

	private void kaigyo(){
		System.out.println();//ただの改行
	}
}
