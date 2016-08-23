package wbs.concurrent.fork_join;

import java.math.BigInteger;
import java.util.TimerTask;
import java.util.concurrent.ForkJoinPool;

class myTimedTask extends TimerTask {
	@Override
	public void run() {
		System.out.println("Make my day.");
	}
}

public class PrimeWorkerForkJoinDemo {
	public static void main(String[] args) {
		BigInteger untergrenze = BigInteger.ONE;
		BigInteger obergrenze = BigInteger.valueOf(10_000_000);
		BigInteger maxInterval = BigInteger.valueOf(100_000);
		boolean isSlow = false;
		long time_1;
		long time_2;
		int numberOfProcessors = Runtime.getRuntime().availableProcessors();
		boolean isPrinting = true;
		ForkPrimeWorker.setMaxInterval(maxInterval);
		ForkPrimeWorker.setSlow(isSlow);
		ForkPrimeWorker.setPrinting(isPrinting);
		ForkJoinPool pool = new ForkJoinPool(numberOfProcessors);
		time_1 = System.currentTimeMillis();
		BigInteger anzahl = pool.invoke(new ForkPrimeWorker(untergrenze, obergrenze));
		time_2 = System.currentTimeMillis();
		System.out.printf("[%,12d%,12d] -> %,12d%n", untergrenze, obergrenze, anzahl);
		System.out.println("time: " + (time_2 - time_1));
	}
}