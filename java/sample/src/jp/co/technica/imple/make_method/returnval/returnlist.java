package jp.co.technica.imple.make_method.returnval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class returnlist {
	public static List<String> getlist(int val){

		ArrayList<String> list = new ArrayList<String>();

		list.add("A");
		list.add("B");
		list.add("C");
		list.add("D");

		if(list.size() < val){
//			return null;
			return Collections.emptyList();//Nullではなく空のリスト
		}
		return list;
	}
}
