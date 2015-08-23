package jp.co.technica.imple.use_instance.classcast;

/**
 * 精密機械
 * */
public class PrecisionMachinery extends TakuhaiObjectBase {

	@Override
	public void contentsConfirmation(){
		System.out.println("精密機械ですね。取り扱い注意");
	}

	/**
	 * 割れ物ステッカーを貼ります。
	 * */
	public void setWaremonoSticker(){
		System.out.println("シールを貼りました。\n");
	}
}
