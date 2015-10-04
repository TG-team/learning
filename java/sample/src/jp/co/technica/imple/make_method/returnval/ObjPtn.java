package jp.co.technica.imple.make_method.returnval;

abstract class ObjPtn {
	protected String name;
	protected int score;

	ObjPtn(String inName){
		name = inName;
		return;
	}
	abstract void setScore(int inScore);

	abstract void dispData();

}
