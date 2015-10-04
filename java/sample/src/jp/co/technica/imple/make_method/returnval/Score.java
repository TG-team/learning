package jp.co.technica.imple.make_method.returnval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Score {
	public String[] getArrayName(int val){

		/* インスタンス作成 */
		String[] array = new String[5];

		/* 配列に名前設定 */
		array[0]	= "一郎";
		array[1]	= "二郎";
		array[2]	= "三郎";
		array[3]	= "四朗";
		array[4]	= "五郎";

		/* 以上の場合、空の配列を返す */
		if(5 <= val){
//			return null;					//Nullにしてしまうと呼び出し側でNullチェックが必要
			return new String[val+1];		//Nullではなく空の配列
		}
		return array;
	}

	public List<String> getListName(int val){

		/* インスタンス作成 */
		ArrayList<String> list = new ArrayList<String>();

		/* リストに名前追加 */
		list.add("一郎");
		list.add("二郎");
		list.add("三郎");
		list.add("四朗");
		list.add("五朗");

		if(5 <= val){
//			return null;					//Nullにしてしまうと呼び出し側でNullチェックが必要
			return Collections.emptyList();	//Nullではなく空のリスト
		}
		return list;
	}



}
