package wbs.concurrent.fork_join;

import java.util.Timer;
import java.util.TimerTask;

class Task extends TimerTask {
	@Override
	public void run() {
		System.out.println("Make my day.");
	}
}

public class TimerTaskDemo {
	public static void main(String[] args) {
		Timer timer = new Timer();

		// Start in einer Sekunde dann Ablauf jede Sekunde
		timer.schedule(new Task(), 1000, 1000);
	}
}