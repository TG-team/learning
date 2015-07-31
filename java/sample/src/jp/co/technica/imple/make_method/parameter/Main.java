package jp.co.technica.imple.make_method.parameter;

public class Main {

    public static void main(String[] args) {

    	int hour = 23;
    	int minute = 59;
    	int second = 59;

    	Time.disp(hour, minute, second);


    	Data data = new Data();

    	data.hour	= 12;
    	data.minute	= 30;
    	data.second	= 30;

    	Time.disp2(data);

    }
}
