package jp.co.technica.imple.make_method.returnval;

public class ScoreArray {

	int count;
	private String[] array = new String[5];

	public void setArray(String name){
		/* 配列に設定 */
		array[count] = name;
		count++;
	}

	public String[] getArray(){
		/* 未設定の場合、空の配列を返す */
		if(0 >= count){
//			return null;					//Nullにしてしまうと呼び出し側でNullチェックが必要
			return new String[0];			//Nullではなく空の配列
		}
		return array;
	}

	public void cleanArray(){
		count = 0;
	}
}
