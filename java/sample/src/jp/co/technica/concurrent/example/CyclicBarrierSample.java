package jp.co.technica.concurrent.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * サイクリックバリア(CyclicBarrier)を使用した並列実行のサンプルです。
 * <br />
 * 
 * バリア(Barrier)とはスレッドがある箇所で待機し、
 * 他のスレッドもバリアポイントに到達したした段階で一斉に処理を再開するような同期方法のことです。
 * 再利用可能なためサイクリック(Cyclic)と付いています。
 * <br />
 * 
 * 主に以下のような使い方があります。
 * <ul>
 * <li>全てのスレッドを同時に実行したい。</li>
 * <li>全てのスレッドの処理完了を待ちたい。</li>
 * </ul>
 * 
 * @author fujimotoryouichi
 *
 */
public class CyclicBarrierSample {
	
	public static volatile int count = 0;

	public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
		ExecutorService e = Executors.newFixedThreadPool(3);
		//全てのタスク（スレッド）の実行を同時に行うためのバリア
		CyclicBarrier runBarrier = new CyclicBarrier(4);
		//全てのタスクの処理が終了した事を確認するためのバリア
		CyclicBarrier completionBarrier = new CyclicBarrier(4);
		
		e.execute(new Task("Task A", runBarrier, completionBarrier, 1));
		Thread.sleep(200);
		e.execute(new Task("Task B", runBarrier, completionBarrier, 10));
		Thread.sleep(200);
		e.execute(new Task("Task C", runBarrier, completionBarrier, 100));
		Thread.sleep(200);
		
		//最後にバリアの解除を行う
		System.out.println("実行開始");
		runBarrier.await();
		
		Thread.sleep(100);
		
		//すべてのタスクが処理完了するまで待機する
		System.out.println("処理完了待機");
		completionBarrier.await();
		System.out.println("count : " + count);
		
		e.shutdown();
	}
	
	public static class Task implements Runnable {
		public final String taskName;
		/** 他のタスクの実行準備を待機するバリア */
		private final CyclicBarrier runBarrier;
		/** このタスクの処理が完了した事を通知するバリア */
		private final CyclicBarrier completionBarrier;
		private final int addCount;
		
		public Task(String name, CyclicBarrier runBarrier, CyclicBarrier completionBarrier, int addCount) {
			taskName = name;
			this.runBarrier = runBarrier;
			this.completionBarrier = completionBarrier;
			this.addCount = addCount;
		}
		
		/**
		 * 処理前にバリアポイントで他のタスクの実行を待ちます。
		 * 処理が完了したら別のバリアポイントで処理終了を通知します。
		 */
		@Override
		public void run() {
			try {
				//他のタスクの準備が完了するまで待機します。
				System.out.println("Await : " + taskName);
				runBarrier.await();
				
				//このタスクの処理
				System.out.println("Proccess : " + taskName);
				count += addCount;
				Thread.sleep(500);
				
				//処理終了を報告
				completionBarrier.await();
				
			} catch (InterruptedException | BrokenBarrierException e) {
				e.printStackTrace();
			}
		}
		
	}

}
