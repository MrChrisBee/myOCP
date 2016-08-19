package wbs.concurrent.executors;

import java.math.BigInteger;
import java.util.NavigableSet;
import java.util.TreeSet;

public class PrimeTaskResult_2 {

	NavigableSet<BigInteger> twinPrimes = new TreeSet<>();

	public NavigableSet<BigInteger> getTwinPrimes() {
		return twinPrimes;
	}

	public void setTwinPrimes(NavigableSet<BigInteger> twinPrimes) {
		this.twinPrimes = twinPrimes;
	}

	public PrimeTaskResult_2(NavigableSet<BigInteger> twinPrimes) {
		this.twinPrimes = twinPrimes;
	}

	
	
}
