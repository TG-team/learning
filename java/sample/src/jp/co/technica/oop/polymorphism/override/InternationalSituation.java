package jp.co.technica.oop.polymorphism.override;

/**
 * 国際情勢
 * */
public class InternationalSituation {

	/**
	 * シングルトンインスタンス
	 * */
	private static final InternationalSituation INSTANCE = new InternationalSituation();

	/** 鬼の数 */
	private int demonCount = 50;
	/** 資材の数 */
	private int material = 0;
	/** 衛生度 */
	private int sanitary = 0;
	/**
	 * 外部からのインスタンス生成不可
	 * */
	private InternationalSituation(){
	}

	/**
	 * インスタンス取得
	 * */
	public static InternationalSituation getInstance(){
		return INSTANCE;
	}

	public void outPrintStatus(){
		String message = null;
		System.out.println("===============================");
		System.out.println("現在の国際情勢");

		if(demonCount > 25){
			message = "鬼に滅ぼされそうです。";
		}else if(demonCount > 10){
			message = "鬼と人類が拮抗しています。";
		}else{
			message = "平和です。";
		}
		System.out.println(String.format("脅威  %s : 鬼残り %03d 体", message,demonCount));

		if(material < 50){
			message = "資材が不足しています。";
		}else{
			message = "資材は十分に蓄えてあります。";
		}

		System.out.println(String.format("物資  %s : 資材数 %03d 個", message,material));

		if(sanitary < 50){
			message = "人類は不健康です。";
		}else{
			message = "人類は健康です。";
		}

		System.out.println(String.format("衛生  %s : 衛生度 %03d ％", message,sanitary));
		System.out.println("===============================");
	}

	public void subtractDemonCount(int count){
		demonCount -= count;
	}

	public void addDemonCount(int count){
		demonCount += count;
	}

	public void addMaterial(int count){
		material+= count;
	}

	public void addSanitary(int count){
		sanitary+=count;
	}


}
