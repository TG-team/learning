package jp.co.technica.imple.concurrency.synchronism;

import java.text.NumberFormat;

public class Main {
	public static void main(String[] args){
		long start = 0L;
		long end = 0L;
		//破壊が起きるインスタンス
		InstanceBase instance = new BrokenInstance();
		//排他を掛けたインスタンス
//		InstanceBase instance = new SynchronizedInstance();
		//スレッドセーフが保障されたインスタンス
//		InstanceBase instance = new AtomicInstance();

		Thread t1 = getThreadInstance(instance);
		Thread t2 = getThreadInstance(instance);


		start = System.nanoTime();

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		end = System.nanoTime();

		NumberFormat nf = NumberFormat.getInstance();
		nf.setMaximumFractionDigits(10);

		String time = nf.format((double)(end - start) / 1000000000);



		System.out.println("カウント：" + instance.getCount());
		System.out.println("計測時間：" + time);
	}



	public static Thread getThreadInstance(InstanceBase instance){
		Thread t = new Thread(){
			InstanceBase ib;

			private Thread setBroken(InstanceBase ib) {
				this.ib = ib;
				return this;
			}

			@Override
			public void run(){
				//スレッドが起動すると200万回InstanceBaseのサブクラスに
				//カウントアップを行います。
				for(int i=0;i<2000000;i++){
					ib.countUp();
				}
			}
		}.setBroken(instance);

		return t;
	}
}
