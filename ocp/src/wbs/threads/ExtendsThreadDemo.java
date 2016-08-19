package wbs.threads;

class ExtendsThread extends Thread {
	@Override
	public void run() {
		System.out.println("Ausgabe der Runmethode : " + Thread.currentThread());
	}
}

public class ExtendsThreadDemo {
	public static void main(String[] args) {
		ExtendsThread extendsThread = new ExtendsThread();
		extendsThread.start();
		//extendsThread.run(); // hier startet KEIN neuer Thread
		System.out.println("Ausgabe von main : " + Thread.currentThread());
	}
}