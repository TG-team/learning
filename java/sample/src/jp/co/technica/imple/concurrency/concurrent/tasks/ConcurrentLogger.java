package jp.co.technica.imple.concurrency.concurrent.tasks;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * マルチスレッドで実行している環境において、特定のポイントに到達した順でログを出力する事を可能にします。
 * 特定のポイントは{@link ConcurrentLogger#beginLog()}によって指定します。
 *
 * @author fujimotoryouichi
 *
 */
public final class ConcurrentLogger {

	/** 時間のフォーマット形式 */
	private static SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss SSS");
	/** 複数のタスク（スレッド）から記録されたログを保持するキュー */
	private static ConcurrentLinkedQueue<IDLog> queue = new ConcurrentLinkedQueue<IDLog>();

	private ConcurrentLogger() {}

	/**
	 * ログ情報をコンソールに出力します。
	 * 出力後は内部に保持しているログはクリアされます。
	 */
	public static void printTaskLog() {
		IDLog idLog;
		while ((idLog = queue.poll()) != null) {
			if (idLog.log != null && idLog.log != Log.DEFAULT_LOG)
				System.out.println(idLog.log.getLog());
		}
	}

	/**
	 * {@link TaskFactory.#setLog()}でログを設定する時に使用するログIDを発行します。
	 * ログをコンソールに出力する際、このメソッドを実行した順で表示されます。
	 * @return ログID
	 */
	public static Object beginLog() {
		Object id = new Object();
		queue.offer(new IDLog(id, Log.DEFAULT_LOG));
		return id;
	}

	/**
	 * ログを内部キューに設定します。
	 * キューにはこのメソッドを実行した順ではなく、
	 * {@link ConcurrentLogger#beginLog()}を実行した順で並びます。
	 * @param id {@link ConcurrentLogger#beginLog()}で取得したログID
	 * @param log 出力したいログ情報
	 */
	public static void setLog(Object id, Log log) {
		for (IDLog idLog : queue) {
			if (idLog.id.equals(id)) {
				idLog.log = log;
				break;
			}
		}
	}

	/** ID付きログ */
	private static class IDLog {
		public Object id;
		public Log log;
		public IDLog(Object id, Log log) {
			this.id = id;
			this.log = log;
		}
	}

	/**
	 * 開始時間と終了時間及びログを保持するクラス
	 * <br />
	 * 設定時に開始時間と終了時間を指定する事が出来ます。
	 * また、ログ文字列には開始時間と終了時間の挿入箇所をマークする事で、
	 * 出力時に適切にフォーマットして出力します。
	 *
	 * @author fujimotoryouichi
	 *
	 */
	public static class Log {

		public static final Log DEFAULT_LOG = new Log("", 0, 0);
		/** 開始時間を挿入するための置換文字列 */
		public static final String START_TIME = "【開始時刻】";
		/** 終了時間を挿入するための置換文字列 */
		public static final String END_TIME = "【終了時刻】";

		/** 複数行ログ */
		private final String log;
		/** 開始時間 */
		private final long startTime;
		/** 終了時間 */
		private final long endTime;

		public Log(String log, long startTime, long endTime) {
			this.log = log;
			this.startTime = startTime;
			this.endTime = endTime;
		}
		/**
		 * 内部に保持されたログ文字列の出力を行います。
		 * この時、開始時間、終了時間が設定されている場合は適切にフォーマットして挿入します。
		 * 挿入箇所は{@link Log#START_TIME}を設定した箇所に開始時間、
		 * {@link Log#END_TIME}を設定した箇所に終了時間をそれぞれ挿入します。
		 *
		 * @return 内部保持したログ文字列に開始時間と終了時間を挿入した文字列
		 */
		public String getLog() {
			String result = log;
			synchronized (sdf) {
				if (startTime > 0) {
					result = result.replace(START_TIME, sdf.format(new Date(startTime)));
				}
				if (endTime > 0) {
					result = result.replace(END_TIME, sdf.format(new Date(endTime)));
				}
			}
			return result;
		}
	}

}
