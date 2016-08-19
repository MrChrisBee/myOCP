package wbs.concurrent.locks_and_conditions;

import java.util.concurrent.ThreadLocalRandom;

public class Consumer<T> extends Thread {
	private SimpleQueue<T> finishedProducts;
	private int time;

	public Consumer(SimpleQueue<T> finishedProducts, int time) {
		this.finishedProducts = finishedProducts;
		this.time = time;
	}

	public void run() {

		while (true) {
			T product = null;
			try {
				product = this.finishedProducts.take();
				System.out.println("consuming " + product);
			} catch (InterruptedException e) {
				System.out.println("\tinterrupt consumer / take()");
				break;
			}
			int delay = ThreadLocalRandom.current().nextInt(0, time);
			try {
				Thread.sleep(delay); 
			} catch (InterruptedException e) {
				System.out.println("\tinterrupt consumer / sleep()");
				break;
			} 
			if (isInterrupted()) {
				break;
			}
		}
	}
}