package wbs.threads;

import java.util.concurrent.ThreadLocalRandom;

public class SemaphoreUser extends Thread {
	private String name;
	private OnePermitSemaphore semaphore;

	public SemaphoreUser(String name, OnePermitSemaphore semaphore) {
		this.name = name;
		this.semaphore = semaphore;
	}

	public void run() {
		try {
			int rnd1 = ThreadLocalRandom.current().nextInt(1, 5);
			int rnd2 = ThreadLocalRandom.current().nextInt(100, 500);
			System.out.println(this.name + " start");
			for (int i = 0; i < rnd1; i++) {
				System.out.println(this.name + " before using resource");
				Thread.sleep(rnd2);
			}
			System.out.println(this.name + " waiting for permit...");
			this.semaphore.acquire();
			System.out.println(this.name + " permit acquired");
			for (int i = 0; i < rnd1; i++) {
				System.out.println(this.name + " using resource");
				Thread.sleep(rnd2);
			}
			System.out.println(this.name + " releasing permit ");
			this.semaphore.release();
			for (int i = 0; i < rnd1; i++) {
				System.out.println(this.name + " after using resource");
				Thread.sleep(rnd2);
			}
			System.out.println(this.name + " end");
		} catch (InterruptedException e) {
			System.out.println(e);
		}
	}
}