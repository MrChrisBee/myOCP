package wbs.threads;

public class OnePermitSemaphore {
	private boolean isFree = true;

	public void acquire() throws InterruptedException {
		// der Thread der acqure() aufruft, versucht,
		// den Monitorlock zu erwerben. Notwendig wegen wait()
		synchronized (this) {
			/*
			 *  der Thread geht ins wait-set des Monitor Objektes, falls isFree False ist
			 *  der Monitor Lock wird durch den Aufruf von wait freigegeben
			 *  wg. spurious wakeups sollte hier eine While-Schleife und nicht 
			 *  if verwendet werden
			 */
			while (!this.isFree) {
				this.wait();
			}
			this.isFree = false;
		}
	}

	public void release() {
		/*
		 *  der Thread der notyfyAll() aufruft, versucht,
		 *  den Monitorlock zu erwerben. Notwendig wegen notyfyAll()
		 */
		 
		synchronized (this) {
			this.isFree = true;
			/* allen Threads, die im wait-set des Monitor-Objektes sind,
			 * wird ein Signal geschickt.
			 *  Diese Threads konkurrieren nun darin den Lock für das MonitorObjekt zu erwerben
			 * Das wird nur einem gelingen
			 */
			/*
			 * Verwende wenn Du nicht sehr starke Gründe hast notifyAll() statt notify()
			 */
			this.notifyAll();
		}
	}
}