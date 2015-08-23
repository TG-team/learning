package jp.co.technica.imple.use_instance.deepcopy;

public class Main {

	public static void main(String[] args){
		Main m = new Main();
		m.scenario();
	}


	private Sasaki sasa = new Sasaki();
	private Yamada_A yama = new Yamada_A();


	public void scenario(){

		kaigyo();

		//佐々木さんと山田(秋)さんはマクドナルドにいきました。

		//マクドナルドでハッピーセットを二つ頼みます。
		HappySet hs = new HappySet();

		//店員は同じ注文だったのでハッピーセットをクローンしました。
		HappySet hs2 = hs.clone();

		//お待ち同様
		sasa.setFood(hs);
		yama.setFood(hs2);

		outPrintStatus();

		sasa.outPrintSpeak("頂きます。");
		yama.outPrintSpeak("頂きます。\n");
		//二人は仲良く食事に入ります。が...

		yama.outPrintSpeak("もぐもぐ。\n");
		yama.eat();

		outPrintStatus();

		sasa.outPrintSpeak("あれ？まだ食べてないのに減ってる... \n");

		yama.outPrintSpeak("おいしいね。もぐもぐ、ごくごく \n");
		yama.eat();
		yama.quaff();

		outPrintStatus();

		sasa.outPrintSpeak("？？？食べものも飲み物も減ってる...  ギロ(視線を向ける)\n");

		yama.outPrintSpeak("ん？どうしたの？\n");

		sasa.outPrintSpeak("何人の勝手に食ってんだー!!\n");

		yama.outPrintSpeak("ええ!?食べてないよ!? 自分の分だけ食べてたよ!!\n");

		sasa.outPrintSpeak("このやろー!!     バシィ!!\n");
		yama.outPrintSpeak("や、やめてー!!  ボキィ!!（骨折）\n");

//		Object#clone()のコピー方法は、シャローコピー（shallow copy：浅いコピー）と呼ばれるもの。
//		これに対するのがディープコピー（deep copy：深いコピー）。
//
//		シャローコピーは、オブジェクトのフィールド（メンバー変数）がオブジェクト（参照型）である場合に、その参照をコピーするだけ。
//		つまりフィールドのオブジェクトは、複製元と複製先で同じオブジェクトを指すことになる。
//
//		これに対しディープコピーは、「フィールドのオブジェクト自身も複写する方式」を指す。
//		ディープコピーを自動的に行うメソッドは用意されていないので、オブジェクトのディープコピーを作りたいのであれば、ディープコピー用のメソッドを自分で作る必要がある。
//http://www.ne.jp/asahi/hishidama/home/tech/java/clone.html
	}

	public void kaigyo(){
		System.out.println();//ただの改行
	}

	public void outPrintStatus(){
		kaigyo();
		sasa.outPrintStatus();
		kaigyo();
		yama.outPrintStatus();
		kaigyo();
	}
}
