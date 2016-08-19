package wbs.concurrent.misc;

import java.util.concurrent.Exchanger;

class ExchangingThread_1 extends Thread {
	
	private Exchanger<String> exchanger;

	public ExchangingThread_1(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
	}

	public void run() {
		String s1 = "One";
		String s2;
		try {
			sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(this.getName() + " exchanging " + s1);
		try {
			s2 = this.exchanger.exchange(s1);
			System.out.println(this.getName() + " receiving " + s2);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class ExchangingThread_2 extends Thread {
	
	private Exchanger<String> exchanger;

	public ExchangingThread_2(Exchanger<String> exchanger) {
		this.exchanger = exchanger;
	}

	public void run() {
		String s1 = "Two";
		String s2;
		try {
			sleep(2000);
		} catch (Exception e) {
			// ignore
		}
		System.out.println(this.getName() + " exchanging " + s1);
		try {
			s2 = this.exchanger.exchange(s1);
			System.out.println(this.getName() + " receiving " + s2);
		} catch (Exception e) {
			// ignore
		}
	}
}

public class ExchangerDemo {
	public static void main(String[] args) throws InterruptedException {
		Exchanger<String> exchanger = new Exchanger<String>();
		new ExchangingThread_1(exchanger).start();
		new ExchangingThread_2(exchanger).start();
	}
}
