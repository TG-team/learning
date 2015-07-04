package jp.co.technica.concurrent.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * スレッドセーフではないコレクションとスレッドセーフなコレクションの動作比較サンプル。
 * <br/>
 * ○処理内容<br/>
 * 　2つのタスクを用意。<br/>
 * 　・タスク１(AddTask)<br/>
 * 　　0〜9の整数をリストの先頭に順に追加する<br/>
 * 　　(先頭に追加指定ので数字が逆順になる)<br/>
 * 
 * 　・タスク２(RemoveTask)<br/>
 * 　　リスト内に9があれば、1〜9を削除する（0を残す）<br/>
 * <br/>
 * スレッドセーフであれば、AddTaskで追加された0〜9の数字を、
 * RemoveTaskで1〜9を削除し0だけが残る事になる。
 * <br/>
 * スレッドセーフではない場合は、AddTask内の{@code List.add()}メソッドと、
 * RemoveTask内の{@code List.remove()}メソッドを同時に実行した場合に、
 * 意図しないレコードを削除してしまう。
 *
 */
public class SynchronizedWrapSample {

	public static void main(String[] args) throws InterruptedException {
		threadUnsafeTest();
		threadSafeTest();
		
		//MapやSetのスレッドセーフ化もできる
		//Collections.synchronizedMap(map);
		//Collections.synchronizedSet(set);
	}
	
	/**
	 * スレッドセーフではないリストをそのまま使用した場合の動作確認
	 * @throws InterruptedException
	 */
	public static void threadUnsafeTest() throws InterruptedException {
		
		//スレッドセーフではないリストの作成
		List<Integer> threadUnsafeList = new ArrayList<Integer>();
		
		//タスク（スレッド）の平行実行開始
		Thread addTask = new Thread(new AddTask(threadUnsafeList));
		Thread removeTask = new Thread(new RemoveTask(threadUnsafeList));
		addTask.start();
		removeTask.start();
		
		//1秒間続行
		Thread.sleep(1000l);
		
		//タスク（スレッド）終了
		//先に追加タスクの終了を行う
		addTask.interrupt();
		
		//追加タスクで追加したリスト全てを処理出来るように少し終了をずらす
		Thread.sleep(50l);
		removeTask.interrupt();
		
		//両スレッドの完全終了を待つ
		while(addTask.isAlive() || removeTask.isAlive()) {
			Thread.sleep(10l);
		}
		
		//「0」意外入っていないはずなので全て削除されるはず・・・
		threadUnsafeList.removeAll(Arrays.asList(0));
		System.out.println(threadUnsafeList);
	}
	
	/**
	 * スレッドセーフではないリストを
	 * {@code Collections.synchronizedList()}でラップしたリストの動作確認
	 * @throws InterruptedException
	 */
	public static void threadSafeTest() throws InterruptedException {
		
		//スレッドセーフではないリストの作成
		List<Integer> threadUnsafeList = new ArrayList<Integer>();
		
		//リストをスレッドセーフなリストにラップする
		//========================================================
		List<Integer> threadSafeList = Collections.synchronizedList(threadUnsafeList);
		//========================================================
		
		//タスク（スレッド）の平行実行開始
		Thread addTask = new Thread(new AddTask(threadSafeList));
		Thread removeTask = new Thread(new RemoveTask(threadSafeList));
		addTask.start();
		removeTask.start();
		
		//1秒間続行
		Thread.sleep(1000l);
		
		//タスク（スレッド）終了
		//先に追加タスクの終了を行う
		addTask.interrupt();
		
		//追加タスクで追加したリスト全てを処理出来るように少し終了をずらす
		Thread.sleep(50l);
		removeTask.interrupt();
		
		//両スレッドの完全終了を待つ
		while(addTask.isAlive() || removeTask.isAlive()) {
			Thread.sleep(10l);
		}
		
		//「0」意外入っていないはずなので全て削除されるはず・・・
		threadSafeList.removeAll(Arrays.asList(0));
		System.out.println(threadSafeList);
	}
	
	/**
	 * リスト追加タスク
	 * <br/>
	 * 0から9までの整数をリストの先頭に追加していく。
	 * ※先頭に追加するので逆順となる。
	 *
	 */
	static class AddTask implements Runnable {
		
		private final List<Integer> workList;
		public AddTask(List<Integer> list) { workList = list;}

		@Override
		public void run() {
			System.out.println("AddTask start");
			while (true) {
				//9〜0をリストの先頭に追加する
				//(9〜0の数は同数になる)
				for (int i = 0; i < 1000; i++) {
					workList.add(0, i % 10);
				}
				
				//mainスレッドの割り込みを受信出来るようにする
				try {
					//高負荷になりすぎないように、10ミリ秒停止する
					Thread.sleep(10);
				} catch (InterruptedException e) {
					//Thread.sleep()が呼ばれるまでにinterrupt()が呼ばれていた場合
					System.out.println("AddTask Stopped");
					break;
				}
			}
		}
	}
	
	/**
	 * リスト削除タスク
	 * <br/>
	 * リストに「9」があれば「9」〜「1」を削除する(「0」を残す)
	 *
	 */
	static class RemoveTask implements Runnable {
		
		private final List<Integer> workList;
		public RemoveTask(List<Integer> list) { workList = list;}

		@Override
		public void run() {
			System.out.println("RemoveTask start");
			while (true) {
				//リストから「0」以外を削除する
				//（「9」が存在すれば、0〜8も同数のはずなので存在する）
				while (workList.contains(9)) {
					workList.remove((Integer)9);
					workList.remove((Integer)8);
					workList.remove((Integer)7);
					workList.remove((Integer)6);
					workList.remove((Integer)5);
					workList.remove((Integer)4);
					workList.remove((Integer)3);
					workList.remove((Integer)2);
					workList.remove((Integer)1);
				}
				
				//mainスレッドの割り込みを受信出来るようにする
				try {
					//高負荷になりすぎないように、10ミリ秒停止する
					Thread.sleep(10);
				} catch (InterruptedException e) {
					//Thread.sleep()が呼ばれるまでにinterrupt()が呼ばれていた場合
					System.out.println("RemoveTask Stopped");
					break;
				}
			}
		}
	}

}
