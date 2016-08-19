package wbs.concurrent.executors;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class PrimeTaskDemo_2 {

	// gibt alle primzahlzwillinge aller intervalle aus
	// 3 5 7 11 13 17 19 29 31 41 43 ... 1999889, 1999891
	
	public static void main(String[] args) {
		long time1 = System.currentTimeMillis();
		int poolSize = 8;

		ExecutorService executor = Executors.newFixedThreadPool(poolSize);
		
		BigInteger startWert = BigInteger.valueOf(1); // sollte ungerade sein
		BigInteger interval = BigInteger.valueOf(100_000);
		int numOfIntervals = 80;
		BigInteger two = BigInteger.valueOf(2);

		PrimeTask_2 primeWorker;
 
		Collection<PrimeTask_2> workers = new HashSet<>();

		for (int i = 1; i <= numOfIntervals; i++) {
			primeWorker = new PrimeTask_2(startWert, startWert.add(interval)
					.subtract(two));
			workers.add(primeWorker);
			startWert = startWert.add(interval);
		}

		try {
			List<Future<PrimeTaskResult_2>> result = executor.invokeAll(workers);
			executor.shutdown();
			NavigableSet<BigInteger> twinPrimes = new TreeSet<>();
			for (Future<PrimeTaskResult_2> future : result) {
				twinPrimes.addAll(future.get().getTwinPrimes());
			}
			for (BigInteger bi : twinPrimes) {
				System.out.println(bi);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		long time2 = System.currentTimeMillis();
		System.out.println((time2-time1)/1000);
	}
}
