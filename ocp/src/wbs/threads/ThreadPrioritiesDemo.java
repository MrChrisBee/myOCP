package wbs.threads;

public class ThreadPrioritiesDemo {
	public static void main(String[] args) {
		System.out.println(Thread.MIN_PRIORITY); // 1
		System.out.println(Thread.NORM_PRIORITY); // 5
		System.out.println(Thread.MAX_PRIORITY); // 10

		/*
		 * Wir legen uns 5 Sekunden schlafen und sagen dann
		 * das wir wiedder wach sind
		 */

		System.out.println("Ich der Thread \n " 
				+ Thread.currentThread().getName() + "\n "
				+ Thread.currentThread().getPriority() + "\n "
				+ Thread.currentThread().getThreadGroup()+ "\n"
				+ "lege mich 5s schlafen");

		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println();
		System.out.println("Ich " + Thread.currentThread() + " bin wieder wach!");
	}
}