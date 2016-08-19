package wbs.string_processing;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

class Sequencer {

	private final AtomicInteger atomicInt = new AtomicInteger(0);

	public Integer next() {
		return atomicInt.getAndIncrement();
	}

	public int getInt() {
		return atomicInt.intValue();
	}
}

class EntryComperator implements Comparator<Map.Entry<String, Sequencer>> {

	@Override
	public int compare(Entry<String, Sequencer> o1, Entry<String, Sequencer> o2) {
		int diff = Integer.compare(o2.getValue().getInt(), o1.getValue().getInt());
		return diff != 0 ? diff : o1.getKey().compareTo(o2.getKey());
	}
}