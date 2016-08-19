package wbs.threads;

import java.math.BigInteger;

class Deadlock implements Runnable {
	private String s1;
	private String s2;
	private String name;
	private BigInteger bi;

	public Deadlock(String s1, String s2, String name, String bigInteger) {
		this.s1 = s1;
		this.s2 = s2;
		this.name = name;
		bi = new BigInteger(bigInteger);
	}

	private void faktoren() {
		for (BigInteger teiler = BigInteger.ONE; teiler.compareTo(bi) < 0; teiler = teiler.add(BigInteger.ONE))
			;
	}

	public void run() {
		System.out.println(name + " waiting for lock for " + s1);
		synchronized (s1) {
			faktoren();
			System.out.println(name + " waiting for lock for " + s2);
			synchronized (s2) {
				faktoren();
			}
		}
		System.out.println(name + " finished");
	}
}

public class DeadlockDemo {
	public static void main(String args[]) throws InterruptedException {
		String s1 = "s1";
		String s2 = "s2";
		Thread t1 = new Thread(new Deadlock(s1, s2, "one", "12345"));
		Thread t2 = new Thread(new Deadlock(s2, s1, "two", "12345"));
		t1.start();
		t2.start();
		t1.join();
		t2.join();
		System.out.println("end of main");
	}
}