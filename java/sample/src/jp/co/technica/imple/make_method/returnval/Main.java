package jp.co.technica.imple.make_method.returnval;

import java.util.List;

public class Main {

	static int i;

	public static void main(String[] args) {

		/* 配列 */
    	Main.testArray();
		System.out.println();

		/* リスト */
    	Main.testList();
		System.out.println();

		/* オブジェクトパターン */
		Main.testObj();
		System.out.println();
    }

	public static void testArray() {
    	/* インスタンス作成 */
    	ScoreArray score = new ScoreArray();
    	String[] array;

    	/* 配列設定 */
    	score.setArray("一郎");
    	score.setArray("二郎");
    	score.setArray("三郎");

    	/* 配列取得 */
    	array = score.getArray();

    	/* 配列表示 */
		System.out.println("配列を表示");
    	for(i = 0 ; i < array.length ; i++){
    		System.out.println("[" + i + "]:" + array[i]);
    	}
		System.out.println();

    	/* 配列消去*/
    	score.cleanArray();

    	/* 配列取得 */
    	array = score.getArray();

    	/* 配列表示 */
		System.out.println("配列を表示");
    	for(i = 0 ; i < array.length ; i++){
    		System.out.println("[" + i + "]:" + array[i]);
    	}
		System.out.println();
	}

	public static void testList() {
    	/* インスタンス作成 */
    	ScoreList score = new ScoreList();
    	List<String> list;

    	/* リスト設定 */
    	score.setList("四朗");
    	score.setList("五朗");

    	/* リスト取得 */
    	list = score.getList();

		/* リスト表示 */
		System.out.println("リストを表示");
    	for(i = 0 ; i < list.size() ; i++){
    		System.out.println("[" + i + "]:" + list.get(i));
    	}
		System.out.println();

		/* リスト削除 */
    	score.cleanList();

    	/* リスト取得 */
    	list = score.getList();

		/* リスト表示 */
		System.out.println("リストを表示");
    	for(i = 0 ; i < list.size() ; i++){
    		System.out.println("[" + i + "]:" + list.get(i));
    	}
		System.out.println();

	}

	public static void testObj() {

    	/* インスタンス作成 */
		ScoreObj score = new ScoreObj();

		ObjPtn ichiro = score.getObj("一郎");

		/* 得点設定 */
		ichiro.setScore(99);

		/* 得点表示 */
		System.out.println("得点を表示");
		ichiro.dispData();
		System.out.println();


		ObjPtn jiro = score.getObj("");

		/* 得点設定 */
		jiro.setScore(99);

		/* 得点表示 */
		System.out.println("得点を表示");
		jiro.dispData();

	}
}

