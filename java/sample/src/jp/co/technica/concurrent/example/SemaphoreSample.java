package jp.co.technica.concurrent.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * セマフォ(Semaphore)を使用したスレッドの実行許可を制御するサンプルです。
 * <br />
 * 
 * セマフォは初めに指定した数の許可証（パーミッション）を保持します。
 * 各スレッドはセマフォに対して許可証の交付申請(acquire)を行います。
 * セマフォは許可証が無くなるまでスレッドの実行を許可します。
 * 許可証を全て交付済みであれば、次に許可証の交付申請を行ったスレッドを待機させます。
 * 待機中にセマフォに許可証の返却(release)が発生し交付可能になった時、
 * スレッドの待機を終了して実行を許可します。
 * 
 * @author fujimotoryouichi
 *
 */
public class SemaphoreSample {

	public static void main(String[] args) {
		ExecutorService e = Executors.newFixedThreadPool(7);
		Semaphore permission = new Semaphore(3, true);
		
		e.execute(new Task("Task A", permission));
		e.execute(new Task("Task B", permission));
		e.execute(new Task("Task C", permission));
		e.execute(new Task("Task D", permission));
		e.execute(new Task("Task E", permission));
		
		//タスクが終了するのを期待して少し待つ
		try { Thread.sleep(200); } catch (InterruptedException ex) { }
		
		e.execute(new Task("Task F", permission));
		e.execute(new Task("Task G", permission));
		
		e.shutdown();
	}

	public static class Task implements Runnable {
		public final String taskName;
		private final Semaphore permission;
		
		public Task(String name, Semaphore permission) {
			taskName = name;
			this.permission = permission;
		}
		
		/**
		 * 処理実行前に許可証の交付申請を行い、許可された場合は処理を行った後、許可証の返却を行います。
		 * 最大50ms待って許可がおりなかった場合は、拒否を表示して終了します。
		 */
		@Override
		public void run() {
			try {
				System.out.println("Require : " + taskName);
				//パーミッションが残っていたら即座に処理が終了してTrueを返します。
				//残っていなかった場合、指定した時間待ってその後も残っていなかった場合falseを返します。
				if (permission.tryAcquire(50, TimeUnit.MILLISECONDS)) {
					//残りのパーミッション数を大体で返します。
					//大体なのは、この処理を行っている最中にも変動する事がありうるからです。
					//（このサンプルのようなサーキットコンディションの場合ほとんど間違った値になります。）
					System.out.println("Grant : " + taskName + " LastTicket " + permission.availablePermits());
					
					Thread.sleep(100);
					
					//パーミッションを戻します。
					//取得したパーミッションを戻す事で再利用する事ができます。
					permission.release();
					System.out.println("Release : " + taskName);
				} else {
					System.out.println("Denied : " + taskName);
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
}
