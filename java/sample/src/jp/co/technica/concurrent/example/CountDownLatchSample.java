package jp.co.technica.concurrent.example;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * カウントダウンラッチ(CountDownLatch)を使用したスレッドの待ち合わせを簡単に行うサンプルです。
 * <br />
 * 
 * カウントダウンラッチは初めに指定した数でカウンターを保持します。
 * カウントダウンラッチに対して待ち合わせ（await）を行うとそのスレッドは待機されます。
 * 待機が解除される条件は、カウントダウンラッチのカウンターを0にすることです。
 * カウンターは、他のスレッドがカウントダウンラッチに対してカウントダウン（countDown）を行う事で減少します。
 * 主にあるスレッドの実行を開始するために、他のスレッドの終了を待ってから行いたい場合に使用します。
 * このサンプルでは、
 * mainスレッドが各Taskがすべて修了した後に実行されるように待機します。
 * 
 * @author fujimotoryouichi
 *
 */
public class CountDownLatchSample {

	public static void main(String[] args) throws InterruptedException {
		//同時にアクティブにできるスレッドを3と指定する
		ExecutorService e = Executors.newFixedThreadPool(3);
		CountDownLatch latch = new CountDownLatch(3);
		
		e.execute(new Task("Task A", latch));
		e.execute(new Task("Task B", latch));
		e.execute(new Task("Task C", latch));
		
		//3つのタスクが終了するまで最大10秒待機する
		latch.await(10, TimeUnit.SECONDS);
		System.out.println("main End.");
		
		e.shutdown();

	}
	
	public static class Task implements Runnable {
		public final String taskName;
		public final CountDownLatch exitChecker;
		
		public Task(String name, CountDownLatch latch) {
			taskName = name;
			exitChecker = latch;
		}

		/**
		 * 処理が終わったらカウントダウンを行います。
		 */
		@Override
		public void run() {
			System.out.println("Task Name : " + taskName + " start.");
			
			try { Thread.sleep(100); } catch (InterruptedException e) { }
			
			System.out.println("Task Name : " + taskName + " end.");
			
			//カウンターを減少させる
			exitChecker.countDown();
		}
		
	}

}
