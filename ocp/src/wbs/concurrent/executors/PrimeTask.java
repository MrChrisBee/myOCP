package wbs.concurrent.executors;

import java.math.BigInteger;
import java.util.concurrent.Callable;

public class PrimeTask implements Callable<PrimeTaskResult> {

	private BigInteger untergrenze;
	private BigInteger obergrenze;

	public PrimeTask(BigInteger untergrenze, BigInteger obergrenze) {
		this.untergrenze = untergrenze;
		this.obergrenze = obergrenze;
	}

	@Override
	public PrimeTaskResult call() throws Exception {
		// ohne optimierungen
		System.out.printf("%s berechne im Bereich  [%s bis %s]%n", Thread.currentThread().getName(),
				untergrenze.toString(), obergrenze.toString());
		BigInteger anzahl = BigInteger.ZERO;
		BigInteger var = new BigInteger(untergrenze.toByteArray());
		for (; var.compareTo(obergrenze) <= 0; var = var.add(BigInteger.ONE)) {
			if (var.isProbablePrime(10)) {
				anzahl = anzahl.add(BigInteger.ONE);
			}
		}
		return new PrimeTaskResult(untergrenze, obergrenze, anzahl);
	}
}
