package jp.co.technica.imple.make_method.parameter;

public class Main {

    public static void main(String[] args) {

    	/* インスタンス作成 */
    	Watch watch = new Watch();
    	Time time = new Time();

    	/* 引数設定 */
    	int hour	= 23;
    	int minute	= 59;
    	int second	= 59;

    	/* メソッド実行(引数の数：3)  */
    	watch.disp(hour, minute, second);	//引数が256以上だとコンパイルエラー


    	/* 引数設定 */
    	time.hour	= 12;
    	time.minute	= 30;
    	time.second	= 30;

    	/* メソッド実行(引数の数：1) */
    	watch.disp2(time);					//3つの情報を1つの引数で渡す

    }
}
