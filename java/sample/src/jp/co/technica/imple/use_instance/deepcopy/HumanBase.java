package jp.co.technica.imple.use_instance.deepcopy;

public class HumanBase {
	private String thisName;
	private HappySet hs;

	public HumanBase() {
	}

	public void setFood(HappySet hs){
		this.hs = hs;
	}

	public void eat(){
		hs.eat();
	}

	public void quaff(){
		hs.quaff();
	}

	public void outPrintStatus(){
		hs.outPrintStatus(thisName);
	}

	protected void setName(String name){
		thisName = name;
	}

	public String getName(){
		return thisName;
	}

	public void outPrintSpeak(String message){
		System.out.println(thisName + " : " + message);
	}
}
