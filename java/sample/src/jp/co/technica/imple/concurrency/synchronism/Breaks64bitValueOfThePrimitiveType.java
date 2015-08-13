package jp.co.technica.imple.concurrency.synchronism;


/**
 * 32bit版Javaならこれで現象がおきる？
 * */
public class Breaks64bitValueOfThePrimitiveType {
	static class Content{
		long brokenValue = 0;

		public long setValue(int val){
			brokenValue = val;
			return brokenValue;
		}
	}

	public static void main(String[] args){
		Content c = new Content();

		Thread t1 = new Thread(createRunnable(1, c));
		Thread t2 = new Thread(createRunnable(-1, c));

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		System.out.println(c.brokenValue);
		System.out.println("終了");

	}

	public static Runnable createRunnable(final int val,final Content c){
		Runnable r = new Runnable() {

			@Override
			public void run() {
				for(int i=0;i<20000000;i++){
					long ret = c.setValue(val);
					if(ret != 1 && ret != -1){
						System.out.println("ThreadName = " + Thread.currentThread().getName() + " :  i = " + i + "  :  brokenValue = " + ret);
					}
				}
			}
		};
		return r;
	}
}
