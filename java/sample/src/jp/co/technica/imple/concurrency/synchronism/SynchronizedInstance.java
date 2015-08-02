package jp.co.technica.imple.concurrency.synchronism;

public class SynchronizedInstance extends InstanceBase {
	int count = 0;

	@Override
	public /*synchronized*/ void countUp() {
		synchronized (this) {
			count++;
		}
	}

	@Override
	public int getCount() {
		return count;
	}

}
