package jp.co.technica.imple.make_method.parameter;

public class Time {
	public static void disp(int hour, int minute, int second){
        System.out.println("disp");

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
        System.out.println(hour + ":" + minute + ":" + second);
	}

	public static void disp2(Data data){
        System.out.println("disp2");

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
        System.out.println(data.hour + ":" + data.minute + ":" + data.second);
	}

}
