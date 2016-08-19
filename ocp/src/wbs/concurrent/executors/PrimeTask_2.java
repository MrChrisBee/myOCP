package wbs.concurrent.executors;

import java.math.BigInteger;
import java.util.NavigableSet;
import java.util.TreeSet;
import java.util.concurrent.Callable;

public class PrimeTask_2 implements Callable<PrimeTaskResult_2> {

	private BigInteger untergrenze;
	private BigInteger obergrenze;

	public PrimeTask_2(BigInteger untergrenze, BigInteger obergrenze) {
		this.untergrenze = untergrenze;
		this.obergrenze = obergrenze;
	}

	@Override
	public PrimeTaskResult_2 call() throws Exception {
		// ohne optimierungen
		BigInteger two = BigInteger.valueOf(2);
		NavigableSet<BigInteger> twinPrimes = new TreeSet<>();
		BigInteger previousPrime = BigInteger.ZERO.subtract(two);
		
		System.out.printf("%s berechne im Bereich  [%s bis %s]%n", Thread.currentThread().getName(),
				untergrenze.toString(), obergrenze.toString());
		BigInteger var = new BigInteger(untergrenze.toByteArray());
		
		for (; var.compareTo(obergrenze) <= 0; var = var.add(BigInteger.ONE)) {
			if (var.isProbablePrime(20)) {
				if(var.subtract(two).equals(previousPrime)) {
					twinPrimes.add(previousPrime);
					twinPrimes.add(var);
				}
				previousPrime = var;// wenn ich eine Primzahl habe ist die nächste durch 2 Teilbar
				var = var.add(BigInteger.ONE); // kann also übersprungen werden 
			}
		}
		return new PrimeTaskResult_2(twinPrimes);
	}
}
 