package jp.co.technica.imple.make_method.parameter;

public class Watch {

	public void disp(int hour, int minute, int second){

    	int dispHour;
    	int dispMinute;
    	int dispSecond;

		/* メソッド名出力 */
		System.out.println("メソッド名："+ Thread.currentThread().getStackTrace()[1].getMethodName());

		/* パラメータの正当性チェック */
		if(hour < 0 || 24 <= hour){
	        System.out.println("hour NG !!");
	        dispHour = 0;
		}else{
			dispHour = hour;
		}
		if(minute < 0 || 60 <= minute){
	        System.out.println("minute NG !!");
	        dispMinute = 0;
		}else{
			dispMinute = minute;
		}

		if(second < 0 || 60 <= second){
	        System.out.println("second NG !!");
	        dispSecond = 0;
		}else{
			dispSecond = second;
		}

		/* 引数出力 */
		System.out.println(dispHour + ":" + dispMinute + ":" + dispSecond);
		System.out.println("");
	}

	public void disp2(Time data){

    	int dispHour;
    	int dispMinute;
    	int dispSecond;

		/* メソッド名出力 */
		System.out.println("メソッド名："+ Thread.currentThread().getStackTrace()[1].getMethodName());

		/* パラメータの正当性チェック */
		if(data.hour < 0 || 24 <= data.hour){
			System.out.println("hour NG !!");
			dispHour = 0;
		}else{
			dispHour = data.hour;
		}

		if(data.minute < 0 || 60 <= data.minute){
			System.out.println("minute NG !!");
			dispMinute = 0;
		}else{
			dispMinute = data.minute;
		}

		if(data.second < 0 || 60 <= data.second){
			System.out.println("second NG !!");
			dispSecond = 0;
		}else{
			dispSecond = data.second;
		}

		/* 引数出力 */
		System.out.println(dispHour + ":" + dispMinute + ":" + dispSecond);
		System.out.println("");
	}

}
