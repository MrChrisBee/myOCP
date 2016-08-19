package wbs.concurrent.locks_and_conditions;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Producer<T1, T2> extends Thread {
	private Collection<T1> rawProducts;
	private SimpleQueue<T2> finishedProducts;
	private int time;

	public Producer(Collection<T1> rawProducts, SimpleQueue<T2> finishedProducts, int time) {
		this.rawProducts = rawProducts;
		this.finishedProducts = finishedProducts;
		this.time = time;
	}

	public void run() {
		T2 finishedProduct;
		for (T1 rawProduct : rawProducts) {
			try {
				Thread.sleep(ThreadLocalRandom.current().nextInt(time));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			try {
				finishedProduct = transform(rawProduct);
				this.finishedProducts.put(finishedProduct);
				System.out.printf("refining (%s -> %s)%n", rawProduct, finishedProduct);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public abstract T2 transform(T1 rawProduct);
}