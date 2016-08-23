package wbs.concurrent.fork_join;

import java.math.BigInteger;
import java.util.concurrent.RecursiveTask;

class ForkPrimeWorker extends RecursiveTask<BigInteger> {
	private static final long serialVersionUID = 1L;
	private static final BigInteger TWO = BigInteger.valueOf(2);
	private final BigInteger untergrenze;
	private final BigInteger obergrenze;
	private static BigInteger maxInterval = BigInteger.valueOf(100_000);
	private static boolean isSlow = false;
	private static boolean isPrinting = true;

	public ForkPrimeWorker(BigInteger untergrenze, BigInteger obergrenze) {
		this.untergrenze = untergrenze;
		this.obergrenze = obergrenze;
	}

	public static void setMaxInterval(BigInteger maxInterval) {
		ForkPrimeWorker.maxInterval = maxInterval;
	}

	public static void setSlow(boolean isSlow) {
		ForkPrimeWorker.isSlow = isSlow;
	}

	public static void setPrinting(boolean isPrinting) {
		ForkPrimeWorker.isPrinting = isPrinting;
	}

	@Override
	public BigInteger compute() {
		BigInteger interval = obergrenze.subtract(untergrenze);
		if (interval.compareTo(maxInterval) <= 0) {
			// intervall ist klein genug. rechne.
			BigInteger anzahl = BigInteger.ZERO;
			BigInteger var = new BigInteger(untergrenze.toByteArray());
			// ohne optimierung
			for (; var.compareTo(obergrenze) <= 0; var = var.add(BigInteger.ONE)) {
				if (var.isProbablePrime(40)) {
					anzahl = anzahl.add(BigInteger.ONE);
				}
			}
			if (isPrinting) {
				System.out.printf("%s comp [%,12d%,12d] -> %,12d%n", Thread.currentThread().getName(), untergrenze,
						obergrenze, anzahl);
			}
			return anzahl;
		} else {
			// intervall ist zu gross
			// zerlege das intervall in 2 teilintervalle
			// erzeuge eine neue RecursiveTask für das erste teilintervall.
			// stelle diese task mit fork() in einer task-queue ab.
			// (von dort wird sie ein thread aktiv holen (stehlen), der gerade
			// nix zu tun
			// hat).
			// erzeuge eine RecursiveTask für das zweite teilintervall und lasse
			// rechnen.
			// warte, bis die erste task abgearbeitet wurde.
			// addiere und liefere.
			BigInteger mid = (untergrenze.add(obergrenze)).divide(TWO);  // Untergrenze + Obergrenze / 2
			if (isPrinting) {
				System.out.printf("%s fork " + "[%,12d%,12d]<->[%,12d%,12d]%n", Thread.currentThread().getName(),
						untergrenze, mid, mid.add(BigInteger.ONE), obergrenze);
			}
			ForkPrimeWorker firstWorker = new ForkPrimeWorker(untergrenze, mid);
			firstWorker.fork();
			ForkPrimeWorker secondWorker = new ForkPrimeWorker(mid.add(BigInteger.ONE), obergrenze);
			if (!isSlow) {
				BigInteger resultSecondWorker = secondWorker.compute();
				BigInteger resultFirstWorker = firstWorker.join();
				return resultSecondWorker.add(resultFirstWorker);
			} else {
				return firstWorker.join().add(secondWorker.compute());
			}
		}
	}
}