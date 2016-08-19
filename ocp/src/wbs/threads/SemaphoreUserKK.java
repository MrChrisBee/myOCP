package wbs.threads;

import java.util.concurrent.ThreadLocalRandom;

public class SemaphoreUserKK extends Thread {
	private String name;
	private OnePermitSemaphore semaphore;

	public SemaphoreUserKK(String name, OnePermitSemaphore semaphore) {
		this.name = name;
		this.semaphore = semaphore;
	}

	public void run() {
		try {
			int rnd1 = ThreadLocalRandom.current().nextInt(1, 3);
			int rnd2 = ThreadLocalRandom.current().nextInt(100, 500);
			System.out.println(this.name + " ist aufgewacht");
			for (int i = 0; i < rnd1; i++) {
				System.out.println(this.name + " ist auf dem Weg zum Bad");
				Thread.sleep(rnd2);
			}
			System.out.println(this.name + " schaut ob das Bad frei ist...");
			this.semaphore.acquire();
			System.out.println(this.name + " fast an die Badezimmerklinke");
			for (int i = 0; i < rnd1; i++) {
				System.out.println(this.name + " ist im Bad");
				Thread.sleep(rnd2);
			}
			System.out.println(this.name + " verläßt das Bad ");
			this.semaphore.release();
			for (int i = 0; i < rnd1; i++) {
				System.out.println(this.name + " ist glücklich");
				Thread.sleep(rnd2);
			}
			System.out.println(this.name + " sitzt am Frühstücktisch");
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}