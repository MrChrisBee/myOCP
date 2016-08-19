package wbs.concurrent.locks_and_conditions;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
 
class ReadWriteLockList<E extends Number> {
	private ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
	private List<E> list = new ArrayList<>();

	public ReadWriteLockList(List<E> list) {
		list.addAll(list);
	}

	public void add(E e) {
		readWriteLock.writeLock().lock();
		try {
			list.add(e);
		} finally {
			readWriteLock.writeLock().unlock();
		}
	}

	public double arithmetischesMittel() {
		readWriteLock.readLock().lock();
		try {
			double x = 0;
			for (Number number : list) {
				x += number.doubleValue();
			}
			return x / list.size();
		} finally {
			readWriteLock.readLock().unlock();
		}
	}
}