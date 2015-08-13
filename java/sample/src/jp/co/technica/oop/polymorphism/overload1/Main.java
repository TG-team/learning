package jp.co.technica.oop.polymorphism.overload1;

public class Main {
	public static void main(String[] args){
		Bartender bar = new Bartender();


		System.out.println("客：本日のオススメを");
		bar.give();

		System.out.println("客：ドリンクは「" + Bartender.DrinkMenu.MoscowMule + "」を、つまみは何でもいいわ。");
		bar.give(Bartender.DrinkMenu.MoscowMule);

		System.out.println("客：スナックの「" + Bartender.SnackMenu.DryFruits + "」を、ドリンクは適当に。");
		bar.give(Bartender.SnackMenu.DryFruits);

		System.out.println("客：「" + Bartender.DrinkMenu.Mojito + "」と「" + Bartender.SnackMenu.Cheese + "」。");
		bar.give(Bartender.DrinkMenu.Mojito,Bartender.SnackMenu.Cheese );

	}
}
