package jp.co.technica.imple.make_method.returnval;

abstract class ObjPtn {
	protected String name;

	public void setDisp(String date){
		name = date;
		return;
	}

	abstract void disp();

}
