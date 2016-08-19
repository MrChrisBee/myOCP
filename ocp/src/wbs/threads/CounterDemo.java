package wbs.threads;

class Counter {
	private int zahl;

	public int getZahl() {
		return zahl;
	}

	public synchronized void increment() {
		zahl++;
	}
}

class CounterThread extends Thread {
	private Counter counter;
	private int n; // anzahl der incrementierungen
	
	public CounterThread(Counter counter, int n) {
		this.counter = counter;
		this.n = n;
	}

	// run() inkrementiert counter n mal
	@Override
	public void run() {
		while(n>0) {
			counter.increment();
			n--;
		}
	}
		
}

public class CounterDemo {

	public static void main(String[] args) {
		// beide Counter-Threads operieren auf dem selben Counter-Objekt
		Counter counter = new Counter(); 
		int n = 5000000;
		// erzeugt 2 counter-threads und startet sie
		CounterThread ct1 = new CounterThread(counter, n);
		CounterThread ct2 = new CounterThread(counter, n);
		ct1.start();
		ct2.start();
		// wartet auf das ende der beiden counter threads
		try {
			ct1.join();
			ct2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// gibt dann den Wert Zahl des counter Objektes aus
		System.out.println(counter.getZahl());
	}

}
