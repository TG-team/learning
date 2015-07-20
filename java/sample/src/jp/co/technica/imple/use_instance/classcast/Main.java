package jp.co.technica.imple.use_instance.classcast;

public class Main {
	public static void main(String[] args){
		DeliveryCenter dc = new DeliveryCenter();

		//addObjectの引数はTakuhaiObjectBase型であり、そのサブクラスは
		//アップキャスト明示的に行わなくても問題は無い。
		dc.addObject(new TakuhaiObjectBase());
		//もちろんキャストを行ってもOK.
		dc.addObject((TakuhaiObjectBase)new PrecisionMachinery());
		dc.addObject(new Letter());
		dc.addObject((TakuhaiObjectBase)(new PrecisionMachinery()));

		dc.sortingWork();
	}
}
