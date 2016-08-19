package wbs.concurrent.executors;

import java.util.Comparator;
import java.util.concurrent.Future;

class PrimeTaskResultComparator implements Comparator<Future<PrimeTaskResult>> {

	@Override
	public int compare(Future<PrimeTaskResult> f1, Future<PrimeTaskResult> f2) {
		int result = 0;
		try {
			result = f1.get().getAnzahl().compareTo(f2.get().getAnzahl());
		} catch (Exception e) {
			System.out.println("exception: " + e);
		}
		return result;
	}
}
