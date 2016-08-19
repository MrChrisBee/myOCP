package wbs.concurrent.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class ConcurrentMapThread extends Thread {

	private int n;
	private HashMap<Integer, String> map;
	private ConcurrentHashMap<Integer, String> cmap;

	private Set<String> values = new HashSet<>();

	public ConcurrentMapThread(int n, HashMap<Integer, String> map,
			ConcurrentHashMap<Integer, String> cmap) {
		this.n = n;
		this.map = map;
		this.cmap = cmap;
	}

	@Override
	public void run() {
		for (int i = 0; i < n; i++) {
			if (!map.containsKey(i)) {
				values.add(Integer.toString(i));
				map.put(i, Integer.toString(i));
			}
			cmap.putIfAbsent(i, Integer.toString(i));
		}
	}

	public ConcurrentHashMap<Integer, String> getCmap() {
		return cmap;
	}

	public void setCmap(ConcurrentHashMap<Integer, String> cmap) {
		this.cmap = cmap;
	}

	public Set<String> getValues() {
		return values;
	}

	public HashMap<Integer, String> getMap() {
		return map;
	}
}

public class ConcurrentMapDemo {

	public static void main(String[] args) {
		int n = 100_000;
		HashMap<Integer, String> map = new HashMap<>();
		ConcurrentHashMap<Integer, String> cmap = new ConcurrentHashMap<>();

		ConcurrentMapThread t1 = new ConcurrentMapThread(n, map, cmap);
		ConcurrentMapThread t2 = new ConcurrentMapThread(n, map, cmap);

		Set<String> union = new HashSet<>();

		t1.start();
		t2.start();

		try {
			t1.join();
			t2.join();

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("values / thread-1: " + t1.getValues().size());
		System.out.println("values / thread-2: " + t2.getValues().size());

		System.out.println("map.size(): " + map.size());
		System.out.println("cmap.size(): " + cmap.size());

		union.addAll(t1.getValues());
		union.addAll(t2.getValues());

		System.out.println("union.size(): " + union.size());
	}
}
