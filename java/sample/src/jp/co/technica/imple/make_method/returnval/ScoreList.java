package jp.co.technica.imple.make_method.returnval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScoreList {

	private ArrayList<String> list = new ArrayList<String>();

	public void setList(String name){
		/* リストに設定 */
		list.add(name);
	}

	public List<String> getList(){
		/* 未設定の場合、空のリストを返す */
		if(0 >= list.size()){
//			return null;					//Nullにしてしまうと呼び出し側でNullチェックが必要
			return Collections.emptyList();	//Nullではなく空のリスト
		}
		return list;
	}
	public void cleanList(){
		/* リストを削除 */
		list.clear();
	}



}
