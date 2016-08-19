package wbs.concurrent.executors;

import java.math.BigInteger;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/*
 * berechnet, ausgehend von einem startwert,
 * für eine gegebene anzahl gleich grosser intervalle
 * die anzahl der primzahlen in jedem dieser intervalle
 */
public class PrimeTaskDemo {

	public static void main(String[] args) {
		long time1 = System.currentTimeMillis();
		int poolSize = 4;
		// int maxPoolSize = 5;
		// long keepAliveTime = 60;

		// BlockingQueue<Runnable> workQueue = new LinkedBlockingQueue<Runnable>();

//		ThreadPoolExecutor executor = new ThreadPoolExecutor(corePoolSize,
//				maxPoolSize, keepAliveTime, TimeUnit.SECONDS, workQueue);
		
		ExecutorService executor = Executors.newFixedThreadPool(poolSize);

		BigInteger startWert = BigInteger.valueOf(1); // sollte ungerade sein
		BigInteger interval = BigInteger.valueOf(1_000_000);
		int numOfIntervals = 20;
		BigInteger two = BigInteger.valueOf(2);

		PrimeTask primeWorker;

		Collection<PrimeTask> workers = new HashSet<>();
		
		System.out.println("start of main");

		for (int i = 1; i <= numOfIntervals; i++) {
			primeWorker = new PrimeTask(startWert, startWert.add(interval)
					.subtract(two));
			workers.add(primeWorker);
			startWert = startWert.add(interval);
		}

		try {
			System.out.println("before invokeAll()");
			// invokeAll() kehrt zurück, wenn isDone()
			// für jedes Future true liefert
			List<Future<PrimeTaskResult>> result = executor.invokeAll(workers);
			System.out.println("after invokeAll()");
			executor.shutdown();
			Collections.sort(result, new PrimeTaskResultComparator());
			for (Future<PrimeTaskResult> future : result) {
				System.out.println("[" + future.get().getUntergrenze() + " : "
						+ future.get().getObergrenze() + "]" + " -> "
						+ future.get().getAnzahl());

			}
			System.out.println("end of main");
		} catch (Exception e) {
			e.printStackTrace();
		}
		long time2 = System.currentTimeMillis();
		System.out.println((time2-time1)/1000);
	}
}
