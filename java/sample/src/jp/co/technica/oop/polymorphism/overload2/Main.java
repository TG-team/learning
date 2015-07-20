package jp.co.technica.oop.polymorphism.overload2;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import jp.co.technica.oop.polymorphism.override.Baba;
import jp.co.technica.oop.polymorphism.override.HumanBehavior;
import jp.co.technica.oop.polymorphism.override.Jiji;
import jp.co.technica.oop.polymorphism.override.Momotaro;

public class Main {

	List<HumanBehavior> list = new ArrayList<>();

	public static void main(String[] args){

		Main me = new Main();

		me.list.add(new Momotaro());
		me.list.add(new Jiji());
		me.list.add(new Baba());

		for(HumanBehavior h : me.list){
			me.outName(h);
		}

		Set<Integer> set = new TreeSet<>();
		List<Integer> list = new ArrayList<>();

		//-3から3まで値を追加していく
		for(int i = -3; i < 3; i++){
			set.add(i);
			list.add(i);
		}
		//追加した値のうち、0から3までの値を削除する。
		for(int i=0;i<3;i++){
			set.remove(i);
			list.remove(i);
		}
		//「-3、-2、-1」と表示されるはず…。
		System.out.println("\n\n" + set + " : " + list);

		//set.removeは引数Objectなため、int型である「i」はInteger型にオートボクシングされる。
		//Integer型に変換されたインスタンスと同様のインスタンスが削除される。

		//list.removeは引数がObject型とint型のオーバーロードであり、
		//Object型が引数の場合は、同一インスタンスが存在したらそれを削除する動きであり、
		//int型の場合、intで指定されたArrayListの要素を取り除く動きである。

		//list.removeをObject型を渡したときの動きをイメージしていると痛い目にあう。

	}


	//オーバーロードの振り分けはコンパイル時に決まる。そのため、24行目で引数として渡している型
	//HumanBehavior型としてオーバーロードの振り分けが決まり、これは実行中では必ず変化しない。
	//同じシグネチャ数を持ち、曖昧な型変換になってしまうオーバーロードを定義してはならない。

	private void outName(Jiji j){
		j.outPrintThisName();
	}
	private void outName(Baba b){
		b.outPrintThisName();
	}
	private void outName(Momotaro m){
		m.outPrintThisName();
	}
	private void outName(HumanBehavior h){
		System.out.println("インターフェースですのでおかしいです。: " + h.getClass().getSimpleName());
	}
}
