package jp.co.technica.oop.polymorphism.overload1;


public class Bartender {
	enum DrinkMenu{
		MoscowMule("モスコミュール"),
		Mojito("モヒート"),
		Matador("マタドール");

		private final String name;

		private DrinkMenu(String name){
			this.name = name;
		}

		public String getName(){
			return name;
		}
	}

	enum SnackMenu{
		Crisps("チップス"),
		DryFruits("ドライフルーツ"),
		Cheese("チーズ");

		private final String name;

		private SnackMenu(String name){
			this.name = name;
		}

		public String getName(){
			return name;
		}
	}

	Bartender() {
		System.out.println("バーテンダー：何になさりますか？\n\n");
	}



	//引数が違えば、同じメソッド名でいくつも定義できるのだが、
	//同じメソッド名で有る以上、得られる結果は同じであるべきである。
	//引数の少ないメソッドでは、引数の多いメソッドとくらべて足りない引数の値をメソッド内で補完し、
	//引数の多いほうを呼びなおす、という手法をよく見る。
	//こうすることで、同名メソッドが複数あろうが「メソッド名の役割を一貫している」と言えるだろう。

	public void give(){

		System.out.println("バーテンダー：本日のオススメは...   ");
		give(getRandomDrink(),getRandomSnack());
	}

	public void give(DrinkMenu drink){
		System.out.println("バーテンダー：スナックはお任せですね。では...   ");
		give(drink,getRandomSnack());
	}

	public void give(SnackMenu snack){
		System.out.println("バーテンダー：ドリンクはお任せですね。では...   ");
		give(getRandomDrink(),snack);
	}

	public void give(DrinkMenu drink,SnackMenu snack){
		System.out.println("バーテンダー：どうぞ、「" + drink.getName() + "」と「" + snack.getName() + "」です。\n\n");
	}

	private DrinkMenu getRandomDrink(){


		int random = (int)(Math.random() * DrinkMenu.values().length); //オススメはランダムで決めます。

		return DrinkMenu.values()[random];
	}

	private SnackMenu getRandomSnack(){

		int random = (int)(Math.random() * SnackMenu.values().length); //オススメはランダムで決めます。

		return SnackMenu.values()[random];
	}
}
