package wbs.concurrent.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * Wir erzeugen zwei Threads die beide das selbe AtomicInteger-Objekt 
 * 1000000 mal inkrementieren.
 * Der Main-Thread wartet auf das Ende dieser beiden Threads und 
 * gibt dann den Endwert aus.
 */
class AtomInt implements Runnable {
	private AtomicInteger aInt;
	@SuppressWarnings("unused")
	private char c;

	public AtomInt(AtomicInteger aInt, char c) {
		super();
		this.aInt = aInt;
		this.c = c;
	}

	@Override
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			aInt.incrementAndGet();
//			System.out.print(this.c);
//			if(i%60 == 0)
//				System.out.println();
		}

	}

}

public class AtomicIntegerDemo {

	public static void main(String[] args) {
		AtomicInteger aInt = new AtomicInteger();
		Thread t1 = new Thread(new AtomInt(aInt,'.'));
		Thread t2 = new Thread(new AtomInt(aInt,','));
		
		long zeit1 = System.currentTimeMillis();
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	long zeit2 = System.currentTimeMillis();
	
		System.out.println(aInt.get());
		System.out.println(zeit2-zeit1);
	}
	

}
