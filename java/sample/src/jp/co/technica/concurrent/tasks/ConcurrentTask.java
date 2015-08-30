package jp.co.technica.concurrent.tasks;

/**
 * マルチスレッド用のタスク処理クラス。
 * <br />
 * 実行時に登録したタスク名、スレッドID、実行開始時間、実行終了時間を記録しますが、
 * 即座にコンソール出力は行いません。
 * 詳しくは{@link ConcurrentTask#run()}メソッドを参照。
 * 
 * @author fujimotoryouichi
 *
 */
public class ConcurrentTask implements Runnable {
	/** タスク名 */
	private final String taskName;
	
	public ConcurrentTask(String taskName) {
		this.taskName = taskName;
	}
	
	/**
	 * タスクの実行情報を記録します。
	 * 
	 * 実行時に登録したタスク名、スレッドID、実行開始時間、実行終了時間をログに記録します。
	 * 実行開始時間と実行終了時間の間には100msの処理を行っていると仮定してsleepを行っています。
	 * 
	 * 記録した内容はキューに格納されます。これは、マルチスレッド実行下では、
	 * 即座にコンソール出力を行うと別スレッドと競合してしまい正しい出力結果とならなくなってしまうためです。
	 */
	@Override
	public void run() {
		//ここでログを書き込む順番を設定
		Object logId = ConcurrentLogger.beginLog();
		
		long startTime = System.currentTimeMillis();
		try { Thread.sleep(100); } catch (InterruptedException e) { } 
		long endTime = System.currentTimeMillis();
		
		ConcurrentLogger.setLog(logId, new ConcurrentLogger.Log(logStr(), startTime, endTime));
	}
	
	private String logStr() {
		StringBuilder printString = new StringBuilder();
		return printString.append("Task Name : ")
		.append(taskName)
		.append(" | Thread ID : ")
		.append(Thread.currentThread().getId())
		.append(" | Start Time : ")
		.append(ConcurrentLogger.Log.START_TIME)
		.append(" | End Time : ")
		.append(ConcurrentLogger.Log.END_TIME)
		.toString();
	}
}