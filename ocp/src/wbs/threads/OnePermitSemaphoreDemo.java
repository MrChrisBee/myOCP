package wbs.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class OnePermitSemaphoreDemo {
	public static void main(String[] args) {
		OnePermitSemaphore semaphore = new OnePermitSemaphore();
		SemaphoreUser su1 = new SemaphoreUser("su1", semaphore);
		SemaphoreUser su2 = new SemaphoreUser("\tsu2", semaphore);
		SemaphoreUser su3 = new SemaphoreUser("\t\tsu3", semaphore);
		List<SemaphoreUser> lsu = new ArrayList<>();
		int rnd = ThreadLocalRandom.current().nextInt(100, 500);
		lsu.add(su1);
		lsu.add(su2);
		lsu.add(su3);
		Collections.shuffle(lsu);
		for (SemaphoreUser su : lsu) {
			try {
				Thread.sleep(rnd);
				su.start();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (SemaphoreUser su : lsu) {
			try {
				su.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("---end of main()---");
	}
}