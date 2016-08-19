package wbs.threads;

class ImplementsRunnable implements Runnable {

	public void run() {
		System.out.println("Ausgabe der RunMethode : " + Thread.currentThread());
	}
	
}

public class ImplementsRunnableDemo {
	public static void main(String[] args) {
		ImplementsRunnable implementsRunnable = new ImplementsRunnable();
		Thread thread = new Thread(implementsRunnable);
		thread.start();
		System.out.println("Ausgabe von Main : " + Thread.currentThread());
	}
}