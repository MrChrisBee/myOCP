package wbs.concurrent.locks_and_conditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class ProducerConsumerDemo {
	public static void main(String[] args) throws InterruptedException {
		Collection<String> rawProducts = new ArrayList<String>();
		int queueSize = 4;
		rawProducts.addAll(Arrays.asList("anton", "berta", "chris", "dora", "emil", "franz", "gerda", "hannelore"));
		SimpleQueue<StringBuffer> finishedProducts = new SimpleArrayBlockingQueue<>(StringBuffer.class, queueSize);
		Producer<String, StringBuffer> producer = new Producer<String, StringBuffer>(rawProducts, finishedProducts, 300) {
			@Override
			public StringBuffer transform(String rawProduct) {
				return new StringBuffer(rawProduct.replaceAll("[aeiou]+", "-"));
			}
		};
		Consumer<StringBuffer> consumer = new Consumer<StringBuffer>(finishedProducts, 900);
		producer.start();
		consumer.start();
		producer.join();
		Thread.sleep(5000);
		consumer.interrupt();
		consumer.join();
		System.out.println("...finis");
	}
}