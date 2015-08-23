package jp.co.technica.concurrent.example;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Executor(Service)を使用したマルチスレッドのタスク実行を簡単に行うサンプルです。
 * 
 * <table border="1" width="500" cellspacing="0" cellpadding="5" bordercolor="#333333">
 * <tr>
 * <th></th>
 * <th bgcolor="#99CC00">スレッド数</th>
 * <th bgcolor="#99CC00">スケジュール可能</th>
 * </tr>
 * <tr>
 * <td bgcolor="#99CC00">SingleThreadExecutor</td>
 * <td>1(固定)</td><td>×</td>
 * </tr>
 * <tr>
 * <td bgcolor="#99CC00">SingleThreadScheduledExecutor</td>
 * <td>1(固定)</td><td>○</td>
 * </tr>
 * <tr>
 * <td bgcolor="#99CC00">FixedThreadPool</td>
 * <td>任意の数</td><td>×</td>
 * </tr>
 * <tr>
 * <td bgcolor="#99CC00">ScheduledThreadPool</td>
 * <td>任意の数</td><td>○</td>
 * </tr>
 * <tr>
 * <td bgcolor="#99CC00">CachedThreadPool</td>
 * <td>不定</td><td>×</td>
 * </tr>
 * </table>
 * 
 * @author fujimotoryouichi
 *
 */
public class ExecutorSample {
	
	static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss SSS");

	public static void main(String[] args) {
		//プロキシ（遅延評価）を無効にします。
		//これが無いと最初のタスクが他よりも重くなります。
		sdf.format(Calendar.getInstance().getTime());
		
		singleThreadExecutorTest();
		singleThreadScheduledExecutorTest();
		fixedThreadPoolTest();
		scheduledThreadPoolTest();
		cachedThreadPoolTest();
	}
	
	/**
	 * ExecutorServiceのシャットダウンと完全終了まで待機します。
	 * @param e
	 */
	public static void shutdown(ExecutorService e) {
		//必ずshutdownメソッドを実行して下さい。
		//これが無いと永遠にアプリが終了しません。
		e.shutdown();
		
		//全てのスレッドが正常終了するまで待機する
		try {
			e.awaitTermination(10, TimeUnit.SECONDS);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	/**
	 * シングルスレッド用の簡単なタスク処理クラス
	 * <br />
	 * 実行時に登録したタスク名、スレッドID、実行開始時間、実行終了時間をコンソールに出力します。
	 * 実行開始時間と実行終了時間の間には100msの処理を行っていると仮定してsleepを行っています。
	 * 
	 * @author fujimotoryouichi
	 *
	 */
	public static class Task implements Runnable {
		/** タスク名 */
		private final String taskName;
		
		public Task(String name) {
			taskName = name;
		}
		
		/**
		 * 実行時に登録したタスク名、スレッドID、実行開始時間、実行終了時間を
		 * コンソールにリアルタイムに出力します。
		 */
		@Override
		public void run() {
			System.out.print("Task Name : ");
			System.out.print(taskName);
			System.out.print(" | Thread ID : ");
			System.out.print(Thread.currentThread().getId());
			System.out.print(" | Start Time : ");
			System.out.print(sdf.format(Calendar.getInstance().getTime()));
			
			try { Thread.sleep(100); } catch (InterruptedException e) { } 
			
			System.out.print(" | End Time : ");
			System.out.print(sdf.format(Calendar.getInstance().getTime()));
			System.out.println();
		}
	}
	
	/**
	 * マルチスレッド用のタスク処理クラス。
	 * <br />
	 * シングルスレッド用同様に、
	 * 実行時に登録したタスク名、スレッドID、実行開始時間、実行終了時間を記録しますが、
	 * 即座にコンソール出力は行いません。
	 * 詳しくは{@link MultiTask#run()}メソッドを参照。
	 * 
	 * @author fujimotoryouichi
	 *
	 */
	public static class MultiTask implements Runnable {
		/** タスク名 */
		private final String taskName;
		private static ConcurrentLinkedQueue<StringBuilder> queue = new ConcurrentLinkedQueue<StringBuilder>();
		
		/** 内部キューをクリアします */
		public static void init() {
			queue.clear();
		}
		
		/** {@link MultiTask#run()}メソッドを実行した順でコンソールに出力を行います。 */
		public static void print() {
			for(StringBuilder sb : queue) {
				System.out.println(sb);
			}
		}
		
		public MultiTask(String name) {
			taskName = name;
		}
		
		/**
		 * タスクの実行情報を記録します。
		 * 記録した内容はキューに格納されます。これは、マルチスレッド実行下では、
		 * 即座にコンソール出力を行うと別スレッドと競合してしまい正しい出力結果とならなくなってしまうためです。
		 */
		@Override
		public void run() {
			//メソッドを実行した順になるようにキューに格納する
			StringBuilder printString = new StringBuilder();
			queue.offer(printString);
			
			Date startTime = Calendar.getInstance().getTime();
			printString.append("Task Name : ");
			printString.append(taskName);
			printString.append(" | Thread ID : ");
			printString.append(Thread.currentThread().getId());
			
			try { Thread.sleep(100); } catch (InterruptedException e) { } 
			Date endTime = Calendar.getInstance().getTime();
			
			//フォーマッタがスレッドセーフではないため最小限の同期化を行う
			synchronized(sdf) {
				printString.append(" | Start Time : ");
				printString.append(sdf.format(startTime));
				printString.append(" | End Time : ");
				printString.append(sdf.format(endTime));
			}
		}
	}
	
	/**
	 * {@link Executors#newSingleThreadExecutor()}から取得する
	 * ExecutorServiceの実行確認を行います。
	 */
	public static void singleThreadExecutorTest() {
		printMethodHeader();
		
		ExecutorService e = Executors.newSingleThreadExecutor();
		
		e.submit(new Task("Task A"));
		e.submit(new Task("Task B"));
		e.submit(new Task("Task C"));
		
		shutdown(e);
		printMethodFooter();
	}
	
	/**
	 * {@link Executors#newSingleThreadScheduledExecutor()}から取得する
	 * ExecutorServiceの実行確認を行います。
	 */
	public static void singleThreadScheduledExecutorTest() {
		printMethodHeader();
		
		ScheduledExecutorService e = Executors.newSingleThreadScheduledExecutor();
		
		//実行スケジュールを指定してタスクを実行する場合はscheduleメソッドを使用します。
		//メソッド実行後、第２引数で指定した時間分待ってからタスクを実行します。（時間単位は第３引数で指定）
		e.schedule(new Task("Task A"), 0, TimeUnit.MILLISECONDS);
		e.schedule(new Task("Task B"), 500, TimeUnit.MILLISECONDS);
		e.schedule(new Task("Task C"), 1000, TimeUnit.MILLISECONDS);
		e.schedule(new Task("Task D"), 50, TimeUnit.MILLISECONDS);
		
		//実行開始時間が早い順に、A→D→B→Cとなります。
		//ただし、使用出来るスレッドが1つなので、Aの実行が完了するまでDは待機します。
		//よって、スケジュール通りになるとは限りません。
		
		shutdown(e);
		printMethodFooter();
	}
	
	/**
	 * {@link Executors#fixedThreadPoolTest()}から取得する
	 * ExecutorServiceの実行確認を行います。
	 */
	public static void fixedThreadPoolTest() {
		printMethodHeader();
		
		//同時にアクティブにできるスレッドを3と指定する
		ExecutorService e = Executors.newFixedThreadPool(3);
		MultiTask.init();
		
		e.submit(new MultiTask("Task A"));
		e.submit(new MultiTask("Task B"));
		e.submit(new MultiTask("Task C"));
		e.submit(new MultiTask("Task D"));
		e.submit(new MultiTask("Task E"));
		e.submit(new MultiTask("Task F"));
		
		//基本的にはsubmitされた順に実行を試みるのでまずはA,B,Cが実行されます。
		//※必ずしもA→B→Cとならない可能性はあります。
		//A,B,Cの処理が終わり次第、空いたスレッドでD,E,Fが順次実行されます。
		//（スレッドIDが3種類あることに注目）
		
		shutdown(e);
		
		//今回は全てのスレッドが終了してからキューに格納された情報を出力するため、
		//shutdownの後に行います。
		MultiTask.print();
		
		printMethodFooter();
	}
	
	/**
	 * {@link Executors#scheduledThreadPoolTest()}から取得する
	 * ExecutorServiceの実行確認を行います。
	 */
	public static void scheduledThreadPoolTest() {
		printMethodHeader();
		
		//同時にアクティブにできるスレッドを3と指定する
		ScheduledExecutorService e = Executors.newScheduledThreadPool(3);
		MultiTask.init();
		
		e.schedule(new MultiTask("Task A"), 0, TimeUnit.MILLISECONDS);
		e.schedule(new MultiTask("Task B"), 500, TimeUnit.MILLISECONDS);
		e.schedule(new MultiTask("Task C"), 1000, TimeUnit.MILLISECONDS);
		e.schedule(new MultiTask("Task D"), 50, TimeUnit.MILLISECONDS);
		e.schedule(new MultiTask("Task E"), 1000, TimeUnit.MILLISECONDS);
		e.schedule(new MultiTask("Task F"), 1000, TimeUnit.MILLISECONDS);
		e.schedule(new MultiTask("Task G"), 1000, TimeUnit.MILLISECONDS);
		
		//実行開始時間が早い順に、A→D→B→Cとなります。
		//singleThreadScheduledExecutorTestの時と違い、
		//Dがちゃんと50ms後に実行されているのがわかります。
		//ただし、この場合でもスレッドに空きが無ければ待機します。
		//GがC,E,Fより出遅れている事がわかります。
		
		shutdown(e);
		MultiTask.print();
		
		printMethodFooter();
	}
	
	/**
	 * {@link Executors#cachedThreadPoolTest()}から取得する
	 * ExecutorServiceの実行確認を行います。
	 */
	public static void cachedThreadPoolTest() {
		printMethodHeader();
		
		//作成時にはスレッド数を指定しない
		ExecutorService e = Executors.newCachedThreadPool();
		MultiTask.init();
		
		e.submit(new MultiTask("Task A"));
		e.submit(new MultiTask("Task B"));
		e.submit(new MultiTask("Task C"));
		
		try { Thread.sleep(200); } catch (InterruptedException ex) { }
		
		e.submit(new MultiTask("Task D"));
		e.submit(new MultiTask("Task E"));
		e.submit(new MultiTask("Task F"));
		e.submit(new MultiTask("Task G"));
		
		//submitされた時、空いているスレッドが無ければ追加されるので、
		//A,B,Cは別々のスレッドを作成して実行しています。
		//D,E,Fは前のタスクが修了した後なのでスレッドを再利用しているのがわかります。
		//Gは空きスレッドが無いので追加されています。
		
		shutdown(e);
		MultiTask.print();
		
		printMethodFooter();
	}
	
	/** テストメソッドの実行直後に実行 */
	public static void printMethodHeader() {
		System.out.println(Thread.currentThread().getStackTrace()[2].getMethodName());
		System.out.println("_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/");
	}
	
	/** テストメソッドの修了直前に実行 */
	public static void printMethodFooter() {
		System.out.println("_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/_/");
		System.out.println();
	}

}
