package jp.co.technica.imple.make_method.parameter;

public class Main {

    public static void main(String[] args) {

    	/* 引数設定 */
    	Watch watch = new Watch();
    	int hour	= 23;
    	int minute	= 59;
    	int second	= 59;

    	/* メソッド実行(引数の数：3)  */
    	watch.disp(hour, minute, second);	//引数が256以上だとコンパイルエラー


    	/* 引数設定 */
    	Time time = new Time();
    	time.hour	= 12;
    	time.minute	= 30;
    	time.second	= 30;

    	/* メソッド実行(引数の数：1) */
    	watch.disp2(time);					//3つの情報を1つの引数で渡す
    										//Data型の場合、参照渡しとなるため、Call先の書き換えに注意が必要

    }
}
