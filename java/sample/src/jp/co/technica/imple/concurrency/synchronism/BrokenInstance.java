package jp.co.technica.imple.concurrency.synchronism;

public class BrokenInstance extends InstanceBase{
	int count = 0;


	public void countUp(){
		count++;
	}

	public int getCount(){
		return count;
	}
}
