package wbs.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * wir erzeugen 10000 sets mit genau 6 verschiedenen zufallszahlen zwischen 1 und 49.
 * 
 * für jedes dieser sets ermitteln wir die trefferzahl (zahlen der letzten ziehung: 4, 16 ,18, 37 ,38 ,42).
 * 
 * dann bauen wir eine map auf. schlüssel in der map ist die trefferzahl, der zugehörige wert eine list,
 * die alle sets enthält mit der trefferzahl, die dem schlüssel entspricht.
 * 
 * dann geben wir für jede trefferzahl die anzahl der sets mit dieser trefferzahl aus.
 */

public class LottoMapDemo_GZ {
	
	private static Random random = new Random();
	
	public static Set<Integer> createTipp() {
		Set<Integer> set = new HashSet<>();
		while (set.size() < 6) {
			set.add(random.nextInt(49) + 1);
		}
		return set;
	}
	
	public static int treffer(Set<Integer> tipp, Set<Integer> ziehungsZahlen) {
		Set<Integer> set = new HashSet<>();
		set.addAll(tipp);
		set.retainAll(ziehungsZahlen);
		return set.size();
	}
	
	public static void main(String[] args) {
		NavigableMap<Integer, List<Set<Integer>>> map = new TreeMap<>();
		Set<Integer> tipp;
		NavigableSet<Integer> ziehungsZahlen = new TreeSet<>(Arrays.asList(4,
				16, 18, 37, 38, 42));
		int treffer;
		for (int i = 0; i <= 6; i++) {
			map.put(i, new ArrayList<Set<Integer>>());
		}
		for (int i = 0; i < 10000; i++) {
			tipp = createTipp();
			treffer = treffer(tipp, ziehungsZahlen);
			map.get(treffer).add(tipp);
		}
		for(Map.Entry<Integer,List<Set<Integer>>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue().size());
		}
	}
}
