package jp.co.technica.imple.make_method.returnval;

import java.util.List;

public class Main {

	static int count;
	public static void main(String[] args) {

    	String[] arraye;
    	List<String> list;
    	int num, count;

    	num = 4;

    	arraye = returnarray.getarray(num);
    	for(count = 0 ; arraye.length > count ; count++){
    		System.out.print(arraye[count] + ",");
    	}


		System.out.println("");
		System.out.println("");


    	list = returnlist.getlist(num);
        System.out.println(list);


		System.out.println("");


		returnptn[] ptn ={
				new Subreturnptn(),
				//null
				new nullreturnptn()//NullではなくNullObjectパターン
		};

		for(returnptn tmpptn : ptn){
			tmpptn.setdisp("DISP");
			tmpptn.disp();
		}

    }
}
