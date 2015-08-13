package jp.co.technica.imple.use_instance.classcast;

public class Letter extends TakuhaiObjectBase{
	private int strength = 10;

	@Override
	public void contentsConfirmation(){
		System.out.println("手紙です。ダンボールで挟んでおきましょう");
	}

	public void setCardboard(){
		strength+=50;
		System.out.println("強度が増加されました。\n");
	}

}
