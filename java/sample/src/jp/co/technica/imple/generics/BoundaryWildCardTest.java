package jp.co.technica.imple.generics;

import java.util.ArrayList;
import java.util.List;

import jp.co.technica.imple.generics.classes.Animal;
import jp.co.technica.imple.generics.classes.Bostonterrier;
import jp.co.technica.imple.generics.classes.Cat;
import jp.co.technica.imple.generics.classes.Chimera;
import jp.co.technica.imple.generics.classes.Dog;
import jp.co.technica.imple.generics.classes.Human;
import jp.co.technica.imple.generics.classes.Noraemon;

/**
 * ワイルドカード型と境界ワイルドカード型のテストクラス
 * <br/>
 * 境界ワイルドカード型は
 * 「上限型つきワイルドカード型」
 * 「下限型つきワイルドカード型」
 * とがあるのでそれぞれ説明
 * <br />
 * 以下簡易表
 * <table border="1" width="500" cellspacing="0" cellpadding="5" bordercolor="#333333">
 * <tr>
 * <th>ワイルドカード</th>
 * <th bgcolor="#99CC00">無</th>
 * <th bgcolor="#99CC00">境界未指定</th>
 * <th bgcolor="#99CC00">上限型つき</th>
 * <th bgcolor="#99CC00">下限型つき</th>
 * </tr>
 * <tr>
 * <td bgcolor="#99CC00">境界の子クラスのListの代入<br />(親クラスのListに子クラスのListの代入)</td>
 * <td>×</td><td>○</td><td>○</td><td>×</td>
 * </tr>
 * <tr>
 * <td bgcolor="#99CC00">境界の親クラスのListの代入<br />(子クラスのListに親クラスのListの代入)</td>
 * <td>×</td><td>○</td><td>×</td><td>○</td>
 * </tr>
 * <tr>
 * <td bgcolor="#99CC00">境界の親インスタンスの追加(add)</td>
 * <td>×</td><td>×</td><td>×</td><td bgcolor="yellow">×</td>
 * </tr>
 * <tr>
 * <td bgcolor="#99CC00">境界インスタンスの追加(add)</td>
 * <td>○</td><td>×</td><td>×</td><td>○</td>
 * </tr>
 * <tr>
 * <td bgcolor="#99CC00">境界の子インスタンスの追加(add)</td>
 * <td>○</td><td>×</td><td>×</td><td>○</td>
 * </tr>
 * <tr>
 * <td bgcolor="#99CC00">出力(get)メソッドの戻り値型</td>
 * <td>定義型</td><td>Object</td><td>境界の型</td><td>Object</td>
 * </tr>
 * </table>
 *
 * @author fujimotoryouichi
 *
 */
public class BoundaryWildCardTest {

	private static List<Animal> animals;
	private static List<Cat> cats;

	static {
		animals = createAnimals(1);
		cats = createCats(1);
	}

	/**
	 * ワイルドカードの説明
	 */
	public static void test1() {
		//これはコンパイルエラーになります。
		//親クラスのListなので出来そうですが、ある事情によりjava言語仕様で制限されています。
		//animals = cats;

		//ある事情とは、下記のようにAnimalの具象クラスを追加した場合
		//インスタンスがCatのListだったら明らかに問題が起きてしまうからです。
		animals.add(new Human());

		//ワイルドカード型を使用してみます
		List<?> unknown;

		//ワイルドカード型の場合はどんなListでも代入することが出来ます。
		unknown = animals;
		unknown = cats;
		unknown = new ArrayList<String>();

		//ただし、ワイルドカード型は引数に型を指定する事が出来ないので、
		//以下のように追加しようとしてもコンパイルエラーとなります。
		//unknown.add(new Human()); //コンパイルエラー
		//unknown.add(new Noraemon()); //コンパイルエラー

		//さらに、ワイルドカード型は戻り値も型を指定する事が出来ないので、
		//以下のように出力しようとしてもコンパイルエラーとなります。
		//Animal animal = unknown.get(0); //コンパイルエラー
		//Cat cat = unknown.get(0); //コンパイルエラー

		//これでは使い道が無いので境界ワイルドカード型というものが存在します。
	}

	/**
	 * 上限型つきワイルドカードの説明
	 */
	public static void test2() {
		//=======================================
		//理論編
		//=======================================
		List<? extends Animal> maybeAnimals;

		//ワイルドカード型と同様にこれらはうまくいきます。
		maybeAnimals = animals;
		maybeAnimals = cats;
		//ただし、Animalを継承していない型は受け付けません。
		//maybeAnimals = new ArrayList<String>(); //コンパイルエラー

		//上限型つきワイルドカード型も引数に型を指定する事が出来ないので、
		//以下のように追加しようとしてもコンパイルエラーとなります。
		//インスタンスはCatのListなので出来そうですが、java言語仕様で制限されています。
		//maybeAnimals.add(new Noraemon()); //コンパイルエラー

		//コンパイル時点ではインスタンスの内容が定かではないので、
		//例えば前述の「maybeAnimals = cats;」部分がなければ
		//AnimalのListとなり、以下の処理も理論上出来る事になってしまうからです。
		//maybeAnimals.add(new Human()); //コンパイルエラー

		//上限型つきワイルドカード型は戻り値の型が変数宣言時に指定した型（継承階層の上限）になります。
		Animal animal = maybeAnimals.get(0);
		//Cat cat = maybeAnimals.get(0); //コンパイルエラー

		//=======================================
		//実践編
		//=======================================

		//リストの内容を出力するとします。
		//以下の場合は、animalsはAnimalのリストなので引数の型と一致するのでエラーにはなりません
		printAnimals_Bad(animals);
		//以下の場合は、catsはCatのリストなので引数の型と一致しないのでエラーとなります。
		//しかし、barkメソッドはサブクラスでも使用出来るはずなので汎用性に欠けてしまっています。
		//printAnimals_Bad(cats); //コンパイルエラー

		//ここで境界ワイルドカードを使用する事によってエラーなく両方のリストで実行出来ます。
		printAnimals(animals);
		printAnimals(cats);
	}

	/**
	 * Animalのリストを受け取って、格納されているインスタンスのbarkメソッドを実行する。
	 * @param animals
	 */
	@Deprecated
	public static void printAnimals_Bad(Iterable<Animal> animals) {
		System.out.println("・printAnimals_Bad");
		for(Animal a : animals) {
			System.out.println(a.bark());
		}
	}

	/**
	 * Animalまたはそのサブクラスのリストを受け取って、格納されているインスタンスのbarkメソッドを実行する。
	 * <br />
	 * 性質上、上限型つきワイルドカード型を使用出来る場合は、その変数をサプライヤーとして扱う場合となる。
	 * サプライヤー（供給者）とは、戻り値等で何かを呼び出しもとに返す処理を行うもののこと。
	 * <br />
	 * 引数がIterableとなっているのは、addメソッドのようなサプライヤーが行えない機能を
	 * 明示的に使用出来ないようにするため。
	 * @param animals
	 */
	public static void printAnimals(Iterable<? extends Animal> animals) {
		System.out.println("・printAnimals");
		for(Animal a : animals) {
			System.out.println(a.bark());
		}
	}

	/**
	 * 下限型つきワイルドカードの説明
	 */
	public static void test3() {
		//=======================================
		//理論編
		//=======================================
		List<? super Cat> maybeCats;

		//ワイルドカード型と同様にこれらはうまくいきます。
		maybeCats = animals;
		maybeCats = cats;

		//下限型つきワイルドカード型は引数の型が変数宣言時に指定した型（継承階層の下限）になります。
		//つまり、Cat又はそのサブクラスを使用出来ます。
		maybeCats.add(new Noraemon());
		maybeCats.add(new Chimera());
		//宣言が「? super Cat」（Cat又はそのスーパーインターフェイス）となっているので、
		//Catより上の継承階層が使用出来るように感じてしまいますが、逆になります。
		//maybeCats.add(new Human()); //コンパイルエラー

		//下限型つきワイルドカード型は戻り値の型を指定する事が出来ないので、
		//以下のように出力しようとしてもコンパイルエラーとなります。
		//for (Animal animal : maybeCats) {
		//	System.out.println(animal.bark());
		//}
		//for (Cat animal : maybeCats) {
		//	System.out.println(animal.bsark());
		//}

		//=======================================
		//実践編
		//=======================================

		//例えばCatの具象クラスをリストに追加したいとします。
		//以下の場合は、animalsはAnimalのリストなので引数の型と一致するのでエラーにはなりません
		addCats_Bad(animals, 2);
		//以下の場合は、catsはCatのリストなので引数の型と一致しないのでエラーとなります。
		//しかし、Catの具象クラスを追加することは出来るはずなので汎用性に欠けてしまっています。
		//addCats_Bad(cats, 2); //コンパイルエラー

		//ここで境界ワイルドカードを使用する事によってエラーなく両方に追加する事が出来るようになります。
		addCats(animals, 2);
		addCats(cats, 2);

		printAnimals(animals);
		printAnimals(cats);


		//Dogの具象クラスとそのサブクラスのインスタンスを追加する場合、
		//追加されるListはDogか継承階層の上(親)のクラスのリストなら何でも指定でき、
		//追加するインスタンスはDogの具象クラスか継承階層の下(子)のクラスのインスタンスなら何でも指定出来るので、
		//汎用性が高くなります
		List<Animal> animals2 = new ArrayList<Animal>();
		List<Dog> dogs = new ArrayList<Dog>();
		addDogs(animals2,5);
		addDogs(dogs,5);

		printAnimals(animals2);
		printAnimals(dogs);
	}

	/**
	 * Animalのリストを受け取って、指定数のCatの具象クラスを追加する。
	 * @param maybeCats
	 * @param count
	 */
	@Deprecated
	public static void addCats_Bad(List<Animal> maybeCats, int count) {
		System.out.println("・addCats_Bad");
		while(count-- != 0) {
			maybeCats.add(new Noraemon());
		}
	}

	/**
	 * Cat又はそのスーパーインターフェイスのリストを受け取って、指定数のCatの具象クラスを追加する。
	 * <br />
	 * 下限型ワイルドカード型が使用出来る場合は、その変数をコンシューマーとして扱う場合となる。
	 * コンシューマーとは、何かを受け取って処理を行うもののこと。
	 * @param maybeCats
	 * @param count
	 */
	public static void addCats(List<? super Cat> maybeCats, int count) {
		System.out.println("・addCats");
		while(count-- != 0) {
			maybeCats.add(new Noraemon());
		}
	}

	/**
	 * Dogの具象クラス又はそのサブクラスのインスタンスをListに追加する。
	 * Dogのサブクラスの何かが設定される。
	 * @param maybeDogs
	 * @param count
	 */
	public static void addDogs(List<? super Dog> maybeDogs, int count) {
		System.out.println("・addDogs");
		while(count-- != 0) {
			maybeDogs.add(Math.random() > 0.5d ? new Chimera() : new Bostonterrier());
		}
	}

	/** エントリポイント */
	public static void main(String[] args) {
		System.out.println("_/_/_/_/_/_/_/_/_/_/");
		System.out.println("上限型つきワイルドカード型");
		System.out.println("_/_/_/_/_/_/_/_/_/_/");
		test2();

		//初期化
		animals = createAnimals(1);
		cats = createCats(1);

		System.out.println("_/_/_/_/_/_/_/_/_/_/");
		System.out.println("下限型つきワイルドカード型");
		System.out.println("_/_/_/_/_/_/_/_/_/_/");
		test3();
	}

	public static List<Animal> createAnimals(int count) {
		List<Animal> result = new ArrayList<Animal>(count);
		while(count-- != 0) {
			result.add(new Human());
		}
		return result;
	}

	public static List<Cat> createCats(int count) {
		List<Cat> result = new ArrayList<Cat>(count);
		while(count-- != 0) {
			result.add(new Noraemon());
		}
		return result;
	}

}
