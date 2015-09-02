package jp.co.technica.imple.make_method.returnval;

public class SubObjPtn extends ObjPtn{

	SubObjPtn(String inName) {
		super(inName);
	}

	@Override
	void setScore(int inScore){
		score = inScore;
	}

	@Override
	void dispData(){
		System.out.println(name + "さんの得点は" + score + "点");
	}

}
