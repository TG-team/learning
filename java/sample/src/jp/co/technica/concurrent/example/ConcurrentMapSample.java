package jp.co.technica.concurrent.example;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 通常のコレクションとコンカレントコレクションの並列実行時のパフォーマンスを検証する。
 * <br/>
 * コンカレントコレクションは複数スレッドから同時アクセスされたとき、
 * 内部状態を壊されない事が保証されるが、
 * ユーザプログラムの意図した動作にならない場合があることに注意。
 * <br/>
 * 例：格納したいキーに既にデータが格納されている場合はそのままにし、データがない場合は追加する。
 * <pre>{@code if (map.get(key) == null)
 *   map.put(key, "Added");
 * }</pre>
 * と実装した場合、スレッドAが{@code if (map.get(key) == null)}の条件を満たしifブロック内に入った直後に、
 * スレッドBも同じく{@code if (map.get(key) == null)}を処理すると、スレッドAがまだ
 * {@code map.put(key, "Added");}していなかったらスレッドBも条件を満たしてしまい、
 * いずれかのスレッドが他方の内容を上書きしてしまう。
 * <br/>
 * 上記の現象を起こさないために、{@code ConcurrentHashMap}は{@code putIfAbsent()}を実装している。
 * （内部で一連の処理がスレッドセーフになっている）<br/>
 * このように複数の処理を1つの塊とし、不可分で実行する事を「原子性」という。
 * <br/>
 * コンカレントコレクションでなくてもsynchronizedでロックを取得する事で、
 * 同様の処理を行う事が出来るが、コンカレントコレクションの方がパフォーマンスにおいて優れている。
 * このサンプルで動作検証を行う。
 */
public class ConcurrentMapSample {

	public static void main(String[] args) throws InterruptedException {
		
		//普通のHashMapを使用
		int total = 0;
		System.out.print("Added Count:");
		for (int i = 0; i < 10; i++) {
			int addedCount = raceConditionTest(new HashMap<Long, String>());
			total += addedCount;
			System.out.print(addedCount + " ");
		}
		System.out.println();
		System.out.println("Average:" + total / 10f);
		
		//ConcurrentHashMapを使用
		total = 0;
		System.out.print("Added Count:");
		for (int i = 0; i < 10; i++) {
			int addedCount = raceConditionTest(new ConcurrentHashMap<Long, String>());
			total += addedCount;
			System.out.print(addedCount + " ");
		}
		System.out.println();
		System.out.println("Average:" + total / 10f);
		
		//キャッシュの影響を受けているかもしれないのでもう１度HashMapで実行
		total = 0;
		System.out.print("Added Count:");
		for (int i = 0; i < 10; i++) {
			int addedCount = raceConditionTest(new HashMap<Long, String>());
			total += addedCount;
			System.out.print(addedCount + " ");
		}
		System.out.println();
		System.out.println("Average:" + total / 10f);
	}
	
	/**
	 * Map追加スレッドを10個作成し並列実行する。
	 * Map追加スレッド内では、追加処理を1000回実行し、{@code interrupt()}が発生していない場合は、
	 * 繰り返し追加処理を実行する。
	 * ※注意：最大で「スレッド数(10) × スレッド内1ループの処理数(1000) = 10000回」誤差が発生する
	 * @param map 追加を行うマップ
	 * @return 全ての処理が完了した後のマップの追加数
	 * @throws InterruptedException
	 */
	public static int raceConditionTest(Map<Long, String> map) throws InterruptedException {
		System.gc();
		
		Thread[] threads = new Thread[]{
				new Thread(new AddTask(map, 0)),
				new Thread(new AddTask(map, 1000000L)),
				new Thread(new AddTask(map, 2000000L)),
				new Thread(new AddTask(map, 3000000L)),
				new Thread(new AddTask(map, 4000000L)),
				new Thread(new AddTask(map, 5000000L)),
				new Thread(new AddTask(map, 6000000L)),
				new Thread(new AddTask(map, 7000000L)),
				new Thread(new AddTask(map, 8000000L)),
				new Thread(new AddTask(map, 9000000L))
		};
		
		for (Thread t : threads) {
			t.start();
		}
		
		//0.5秒間続行
		Thread.sleep(500l);
		
		for (Thread t : threads) {
			t.interrupt();
		}
		
		//全てのスレッドの完全停止を待つ
		for (Thread t : threads) {
			while(t.isAlive()) Thread.sleep(10);
		}
		
		return map.size();
	}
	
	/**
	 * Map追加タスク
	 * <br/>
	 *
	 */
	static class AddTask implements Runnable {
		
		private final Map<Long, String> workMap;
		private final long offset;
		public AddTask(Map<Long, String> map, long offset) {
			workMap = map;
			this.offset = offset;
		}

		@Override
		public void run() {
			//System.out.println("AddTask start");
			long i = offset;
			while (true) {
				//1000回ループ
				do {
					if (workMap instanceof ConcurrentHashMap) {
						putIfAbsent((ConcurrentMap<Long, String>) workMap, i++);
					} else {
						putIfAbsent(workMap, i++);
					}
				} while (i % 1000 != 0);
				
				//mainスレッドの割り込みを受信出来るようにする
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					//Thread.sleep()が呼ばれるまでにinterrupt()が呼ばれていた場合
					//System.out.println("AddTask Stopped");
					break;
				}
			}
		}
		
		/**
		 * コンカレントコレクションを使用して追加を行う。
		 * keyが既に追加されているか確認し、無ければ追加を行う。
		 * （{@code putIfAbsent()}が内部的に行う）
		 * アクセスにはインターフェイス{@code ConcurrentMap}を使用する。
		 * @param map
		 * @param key
		 */
		private void putIfAbsent(ConcurrentMap<Long, String> map, long key) {
			map.putIfAbsent(key, "Added");
		}
		
		/**
		 * コレクションを使用して追加を行う。
		 * keyが既に追加されているか確認し、無ければ追加を行う。
		 * このとき、並列実行可能なようにsynchronizedを使用する。
		 * ※java1.8以降であれば{@code putIfAbsent()}を使用する事は出来る。
		 * ただし、その場合もスレッドセーフではないので、synchronizedを使用する事。
		 * @param map
		 * @param key
		 */
		private void putIfAbsent(Map<Long, String> map, long key) {
			synchronized(map) {
				if (map.get(key) == null) {
					map.put(key, "Added");
				}
			}
		}
	}

}
