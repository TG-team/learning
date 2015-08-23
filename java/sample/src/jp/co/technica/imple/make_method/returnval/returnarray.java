package jp.co.technica.imple.make_method.returnval;

public class returnarray {
	public static String[] getarray(int val){

		String[] array = new String[4];

		array[0] = "A";
		array[1] = "B";
		array[2] = "C";
		array[3] = "D";

		if(array.length < val + 1){
//			return null;
			return new String[val + 1];//Nullではなく空の配列
		}
		return array;
	}

}
