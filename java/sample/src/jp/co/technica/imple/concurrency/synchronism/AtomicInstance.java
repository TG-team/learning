package jp.co.technica.imple.concurrency.synchronism;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicInstance extends InstanceBase {
	//カウンターとして使うのが目的であり、Integer型の代替として使うことはできない。
	AtomicInteger count = new AtomicInteger();

	@Override
	public void countUp() {
		count.getAndIncrement();
	}

	@Override
	public int getCount() {
		return count.get();
	}

}
