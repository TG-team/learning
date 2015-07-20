package jp.co.technica.imple.use_instance.classcast;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 配送センター
 * */
public class DeliveryCenter {

	private Queue<TakuhaiObjectBase> souko = new ArrayDeque<TakuhaiObjectBase>();

	public void addObject(TakuhaiObjectBase tob){
		//キャストが行われると、実態はどうあれキャストした型として振舞うことになる。
		//tob.setCardboard();	//引数の実態がLetter型だったとしてもsetCardboard()メソッドを呼び出すことができない。
		souko.add(tob);
	}

	public void sortingWork(){

		System.out.println("届いた荷物への仕分け作業を行います。\n");

		while( ! souko.isEmpty()){

			TakuhaiObjectBase obj =  souko.poll();
			obj.contentsConfirmation();

			//「A instanceof B」 = 「A は B であるか」となり、true,falseが帰ってくる。
			//AがBのサブクラスである場合trueが帰ってくるので注意が必要。

//			//すべてここを通ってしまう。
//			if(obj instanceof TakuhaiObjectBase){
//				System.out.println("宅配オブジェクトベース\n");
//
//				//インスタンスの実態が明確になっていなくてもキャスト事態は行うことができる。
//				//コンパイルエラーにはならないが、実行時エラーが発生する。
//
//				Letter l = (Letter) obj;
//					//Exception in thread "main" java.lang.ClassCastException:
//					//型変換のエラー発生時、eclipseのクイックフィックスで最初の項目によく現れるが、
//					//意味の分からないままクイックフィックスに頼ると、コンパイルエラーはないのに実行時でエラーだらけになり、
//					//取り返しのつかないレベルになるまで盛大にバグる。
//
//			}else

			if( obj instanceof Letter){
				//手紙にはダンボールを挟む作業が必要

				//objの実態はLetterであり、３６行のif文で証明されているので
				//objをLetter型にダウンキャストする。
				Letter letter = (Letter)obj;
				letter.setCardboard(); //Letter型になったことでsetCardboard()メソッドが使えるようになる。

			}else if(obj instanceof PrecisionMachinery){
				//精密機器には取り扱い注意のシールを貼る
				((PrecisionMachinery)obj).setWaremonoSticker();

			}else{
				obj = null;
			}
		}
	}
}
