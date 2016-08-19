package wbs.threads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class OnePermitSemaphoreDemoKK {
	public static void main(String[] args) {
		OnePermitSemaphore semaphore = new OnePermitSemaphore();
		SemaphoreUserKK su1 = new SemaphoreUserKK("MamaBär", semaphore);
		SemaphoreUserKK su2 = new SemaphoreUserKK("\tPapaBär", semaphore);
		SemaphoreUserKK su3 = new SemaphoreUserKK("\t\tBabyBär", semaphore);
		List<SemaphoreUserKK> lsu = new ArrayList<>();
		int rnd = ThreadLocalRandom.current().nextInt(100, 500);
		lsu.add(su1);
		lsu.add(su2);
		lsu.add(su3);
		Collections.shuffle(lsu);
		for (SemaphoreUserKK su : lsu) {
			try {
				Thread.sleep(rnd);
				su.start();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		for (SemaphoreUserKK su : lsu) {
			try {
				su.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("---end of main()---");
	}
}