package jp.co.technica.imple.concurrency.synchronism;


/**
 * 32bit版Javaならこれで現象がおきる？
 * */
public class Breaks64bitValueOfThePrimitiveType {
	private static long longValue = 0;

	public static void main(String[] args) throws Exception {
		final int LOOP = 1000 * 1000 * 1000;

		Thread th1 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < LOOP; i++) {
					longValue = 1;
					check(longValue);
				}
			}
		});

		Thread th2 = new Thread(new Runnable() {
			public void run() {
				for (int i = 0; i < LOOP; i++) {
					longValue = -1;
					check(longValue);
				}
			}
		});

		th1.start();
		th2.start();

		th1.join();
		th2.join();

		System.out.println("終了");
	}

	private static void check(long value) {
		if (value != 1 && value != -1) {
			throw new RuntimeException(String.valueOf(value));
		}
	}
}
