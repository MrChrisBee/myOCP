package wbs.threads;

class ExtendsThread2 extends Thread {
	@Override
	public void run() {
		System.out.println("Tach");
		while (true) {
		}
	}
}

public class DeamonThreadDemo {

	/*
	 * Der Main Thread startet einen Thread der in eine Endlosschleife geht
	 * 
	 * was passiert wenn der Endlos-Thread ein Deamon ist / kein Deamon ist
	 * 
	 * was Passiert, wenn wir setDeamon() nach dem start eines Threads aufrufen
	 */

	public static void main(String[] args) {
		ExtendsThread2 exT = new ExtendsThread2();
		exT.setDaemon(true);
		exT.start();
	}
}
