package jp.co.technica.imple.make_method.returnval;

import java.util.List;

public class Main {

	static int count;
	public static void main(String[] args) {

		/* 配列 */
    	Main.dispArray(2);
    	Main.dispArray(5);	//空の配列を返却する

		System.out.println("");

		/* リスト */
    	Main.dispList(1);
    	Main.dispList(6);	//Collections.empty～系を返却する

		System.out.println("");

		/* オブジェクトパターン */
		Main.dispObj("四郎");
    }

	public static void dispArray(int no) {
    	/* インスタンス作成 */
    	Score score = new Score();
    	String[] array;

    	/* 配列取得 */
    	array = score.getArrayName(no);

    	/* 名前表示 */
		System.out.println(no+1 + "位：" + array[no]);

	}

	public static void dispList(int no) {
    	/* インスタンス作成 */
    	Score score = new Score();
    	List<String> list;

    	/* リスト取得 */
    	list = score.getListName(no);

    	/* 名前表示 */
		System.out.println("順位：" + list);

	}

	public static void dispObj(String name) {
		/* オブジェクト作成 */
		ObjPtn[] ptn ={
				new SubObjPtn(),
				//null				//Nullにしてしまうと呼び出し側でNullチェックが必要
				new SubObjPtnNull() //NullではなくNullObjectパターン
		};

		/* オブジェクト分実行 */
		for(ObjPtn tmpptn : ptn){
			tmpptn.setDisp(name);
			tmpptn.disp();
		}

	}

}
