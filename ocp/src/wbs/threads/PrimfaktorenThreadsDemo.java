package wbs.threads;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class IntegerUtil {

}

public class PrimfaktorenThreadsDemo {

	/*
	 * Wir bestücken ein Array mit einigen ziemlich großen Long-Werten
	 * 
	 * für jeden dieser Long-Werte starten wir einen Thread.
	 * 
	 * Jeder Thread zerlegt die Zahl in Primfaktoren
	 * 
	 * Wenn er fertig ist schreibt er in eine Datei (resources/io/characterdata/Primfaktoren.txt):
	 * -seinen Namen
	 * -die Zahl die er Zerlegt hat
	 * -jeden Primfaktor jeweils in einer eigenen Zeile 
	 */
	private static File file = new File("resources/io/characterdata/Primfaktoren.txt");

	class PrimThread extends Thread {
		private PrintWriter pw;
		private Long zahl;
		private List<Long> zahlList = new ArrayList<>();

		public PrimThread(PrintWriter pw, Long zahl) {
			this.zahl = zahl;
			this.pw = pw;
		}

		@Override
		public void run() {
			zahlList = primFaktoren(zahl);
			System.out.println(this.getName());
			System.out.println("Für den Wert " + zahl + " ergibt sich :" + zahlList);
		
			synchronized (pw) {
				pw.println("Thread : " + this.getName());
				pw.println("Zahl :" + zahl);
				pw.println("Primfaktoren");
				for (Long werte : zahlList) {
					pw.println(werte);
				}
				pw.println("+++++++++++++++");
				pw.flush();
			}
		}

	}

	public static List<Long> primFaktoren(Long zahl) {
		List<Long> primFaktoren = new ArrayList<>();
		for (long teiler = 2; zahl != 1; teiler++) {
			while ((zahl % teiler) == 0) {
				zahl = zahl / teiler;
				primFaktoren.add(teiler);
			}
		}
		return primFaktoren;
	}

	public static void main(String[] args) {
		try (PrintWriter pw = new PrintWriter(file);) {
			Long[] longArr = new Long[25];
			Random rnd = new Random();
			for (int i = 0; i < 25; i++) {
				longArr[i] = Math.abs(rnd.nextLong() + 1) % 1000000;

				System.out.println(longArr[i]);
			}
			PrimfaktorenThreadsDemo threadDemo = new PrimfaktorenThreadsDemo();
			Thread[] threadArray = new Thread[longArr.length];

			for (int i = 0; i < longArr.length; i++) {
				threadArray[i] = threadDemo.new PrimThread(pw, longArr[i]);
				threadArray[i].start();
			}

			for (int i = 0; i < longArr.length; i++) {
				try {
					threadArray[i].join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}
