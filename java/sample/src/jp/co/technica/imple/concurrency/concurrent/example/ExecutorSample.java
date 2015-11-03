package jp.co.technica.imple.concurrency.concurrent.example;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import jp.co.technica.imple.concurrency.concurrent.tasks.ConcurrentLogger;
import jp.co.technica.imple.concurrency.concurrent.tasks.ConcurrentTask;

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

	public static void main(String[] args) {

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
	 * {@link Executors#newSingleThreadExecutor()}から取得する
	 * ExecutorServiceの実行確認を行います。
	 */
	public static void singleThreadExecutorTest() {
		printMethodHeader();

		ExecutorService e = Executors.newSingleThreadExecutor();

		e.submit(new ConcurrentTask("Task A"));
		e.submit(new ConcurrentTask("Task B"));
		e.submit(new ConcurrentTask("Task C"));

		shutdown(e);
		ConcurrentLogger.printTaskLog();

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
		e.schedule(new ConcurrentTask("Task A"), 0, TimeUnit.MILLISECONDS);
		e.schedule(new ConcurrentTask("Task B"), 500, TimeUnit.MILLISECONDS);
		e.schedule(new ConcurrentTask("Task C"), 1000, TimeUnit.MILLISECONDS);
		e.schedule(new ConcurrentTask("Task D"), 50, TimeUnit.MILLISECONDS);

		//実行開始時間が早い順に、A→D→B→Cとなります。
		//ただし、使用出来るスレッドが1つなので、Aの実行が完了するまでDは待機します。
		//よって、スケジュール通りになるとは限りません。

		shutdown(e);
		ConcurrentLogger.printTaskLog();

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

		e.submit(new ConcurrentTask("Task A"));
		e.submit(new ConcurrentTask("Task B"));
		e.submit(new ConcurrentTask("Task C"));
		e.submit(new ConcurrentTask("Task D"));
		e.submit(new ConcurrentTask("Task E"));
		e.submit(new ConcurrentTask("Task F"));

		//基本的にはsubmitされた順に実行を試みるのでまずはA,B,Cが実行されます。
		//※必ずしもA→B→Cとならない可能性はあります。
		//A,B,Cの処理が終わり次第、空いたスレッドでD,E,Fが順次実行されます。
		//（スレッドIDが3種類あることに注目）

		shutdown(e);
		//全てのスレッドが終了してからキューに格納された情報を出力するため、
		//shutdownの後に行います。
		ConcurrentLogger.printTaskLog();

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

		e.schedule(new ConcurrentTask("Task A"), 0, TimeUnit.MILLISECONDS);
		e.schedule(new ConcurrentTask("Task B"), 500, TimeUnit.MILLISECONDS);
		e.schedule(new ConcurrentTask("Task C"), 1000, TimeUnit.MILLISECONDS);
		e.schedule(new ConcurrentTask("Task D"), 50, TimeUnit.MILLISECONDS);
		e.schedule(new ConcurrentTask("Task E"), 1000, TimeUnit.MILLISECONDS);
		e.schedule(new ConcurrentTask("Task F"), 1000, TimeUnit.MILLISECONDS);
		e.schedule(new ConcurrentTask("Task G"), 1000, TimeUnit.MILLISECONDS);

		//実行開始時間が早い順に、A→D→B→Cとなります。
		//singleThreadScheduledExecutorTestの時と違い、
		//Dがちゃんと50ms後に実行されているのがわかります。
		//ただし、この場合でもスレッドに空きが無ければ待機します。
		//GがC,E,Fより出遅れている事がわかります。

		shutdown(e);
		ConcurrentLogger.printTaskLog();

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

		e.submit(new ConcurrentTask("Task A"));
		e.submit(new ConcurrentTask("Task B"));
		e.submit(new ConcurrentTask("Task C"));

		try { Thread.sleep(200); } catch (InterruptedException ex) { }

		e.submit(new ConcurrentTask("Task D"));
		e.submit(new ConcurrentTask("Task E"));
		e.submit(new ConcurrentTask("Task F"));
		e.submit(new ConcurrentTask("Task G"));

		//submitされた時、空いているスレッドが無ければ追加されるので、
		//A,B,Cは別々のスレッドを作成して実行しています。
		//D,E,Fは前のタスクが修了した後なのでスレッドを再利用しているのがわかります。
		//Gは空きスレッドが無いので追加されています。

		shutdown(e);
		ConcurrentLogger.printTaskLog();

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
