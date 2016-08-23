package wbs.concurrent.fork_join;

import java.math.BigInteger;
import java.util.concurrent.ForkJoinPool;

class ProgressThread extends Thread {
	BigInteger doneNumbers = BigInteger.ZERO;
	BigInteger maxValue;

	public ProgressThread(BigInteger maxValue) {
		this.maxValue = maxValue;
	}

	public synchronized void addProgress(int addInt) {
		doneNumbers = doneNumbers.add(BigInteger.valueOf(addInt));
	}

	public void run() {
		Integer percent = 0;
		while (percent < 100) {
			percent = (doneNumbers.multiply(BigInteger.valueOf(100)).divide(maxValue)).intValue();
			System.out.printf("[%,12d%,12d] -> %5d %% %n", doneNumbers, maxValue, percent);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

public class PrimeWorkerForkJoinDemo_2 {
	public static void main(String[] args) throws InterruptedException {
		BigInteger untergrenze = BigInteger.ONE;
		BigInteger obergrenze = BigInteger.valueOf(10_000_000);
		BigInteger maxInterval = BigInteger.valueOf(10_000);

		boolean isSlow = false;
		long time_1;
		long time_2;
		int numberOfProcessors = Runtime.getRuntime().availableProcessors();
		boolean isPrinting = false;
		ForkPrimeWorker_2.setMaxInterval(maxInterval);
		ForkPrimeWorker_2.setSlow(isSlow);
		ForkPrimeWorker_2.setPrinting(isPrinting);
		ForkJoinPool pool = new ForkJoinPool(numberOfProcessors);
		time_1 = System.currentTimeMillis();
		ProgressThread progressThread = new ProgressThread(obergrenze);
		progressThread.start();
		BigInteger anzahl = pool.invoke(new ForkPrimeWorker_2(untergrenze, obergrenze, progressThread));
		time_2 = System.currentTimeMillis();
		progressThread.join();
		System.out.println("-----------------------");
		System.out.printf("[%,12d%,12d] -> %,12d%n", untergrenze, obergrenze, anzahl);
		System.out.println("time: " + (time_2 - time_1));
	}
}