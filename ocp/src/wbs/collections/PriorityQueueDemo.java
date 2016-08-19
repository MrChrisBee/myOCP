package wbs.collections;

import java.util.PriorityQueue;

public class PriorityQueueDemo {
	// das element mit der höchsten priorität ist am ende (tail) der queue
	// am head der queue ist das element mit der niedrigsten priorität
	// null- elemente sind nicht erlaubt
	// basis der prioritätsbestimmung ist das natural ordering der elemente
	// oder ein im konstruktor übergebener comparator
	// iteratoren garantieren keine bestimmte reihenfolge
	public static void main(String[] args) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		pq.add(5);
		pq.add(7);
		pq.add(3);
		pq.add(9);
		while (!pq.isEmpty()) {
			System.out.println(pq.remove());
		}
		// ausgabe: 3 5 7 9
	}
}