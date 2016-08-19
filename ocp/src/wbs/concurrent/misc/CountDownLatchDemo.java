package wbs.concurrent.misc;

import java.util.concurrent.CountDownLatch;

class CountDownThread extends Thread {
	
	private CountDownLatch countDownLatch;

	public CountDownThread(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	public void run() {
		for (int i = 0; i < 4; i++) {
			try {
				sleep(500);
				System.out.println(this.getName() + " countDown");
				this.countDownLatch.countDown();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class WaitingThread extends Thread {
	
	private CountDownLatch countDownLatch;

	public WaitingThread(CountDownLatch countDownLatch) {
		this.countDownLatch = countDownLatch;
	}

	public void run() {
		
		System.out.println(this.getName() + " waiting");
		
		try {
			this.countDownLatch.await();
			System.out.println(this.getName() + " continues");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

public class CountDownLatchDemo {
	
	public static void main(String[] args) {
	
		CountDownLatch countDownLatch = new CountDownLatch(4);
		
		new CountDownThread(countDownLatch).start();
		
		new WaitingThread(countDownLatch).start();
		new WaitingThread(countDownLatch).start();
	}
}