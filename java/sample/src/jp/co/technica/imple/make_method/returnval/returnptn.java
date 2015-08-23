package jp.co.technica.imple.make_method.returnval;

abstract class returnptn {
	protected String name;

	public void setdisp(String date){
		name = date;
		return;
	}

	abstract void disp();

}
