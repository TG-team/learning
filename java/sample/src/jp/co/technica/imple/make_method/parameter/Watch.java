package jp.co.technica.imple.make_method.parameter;

public class Watch {

	public void disp(int hour, int minute, int second){
		/* メソッド名出力 */
		System.out.println("メソッド名："+ Thread.currentThread().getStackTrace()[1].getMethodName());

		/* パラメータの正当性チェック */
		if(hour < 0 || 24 <= hour){
	        System.out.println("hour NG !!");
	        hour = 0;
		}
		if(minute < 0 || 60 <= minute){
	        System.out.println("minute NG !!");
	        minute = 0;
		}
		if(second < 0 || 60 <= second){
	        System.out.println("second NG !!");
	        second = 0;
		}

		/* 引数出力 */
		System.out.println(hour + ":" + minute + ":" + second);
		System.out.println("");
	}

	public void disp2(Time data){
		/* メソッド名出力 */
		System.out.println("メソッド名："+ Thread.currentThread().getStackTrace()[1].getMethodName());

		/* パラメータの正当性チェック */
		if(data.hour < 0 || 24 <= data.hour){
			System.out.println("hour NG !!");
			data.hour = 0;
		}
		if(data.minute < 0 || 60 <= data.minute){
			System.out.println("minute NG !!");
			data.minute = 0;
		}
		if(data.second < 0 || 60 <= data.second){
			System.out.println("second NG !!");
			data.second = 0;
		}

		/* 引数出力 */
		System.out.println(data.hour + ":" + data.minute + ":" + data.second);
		System.out.println("");
	}

}
