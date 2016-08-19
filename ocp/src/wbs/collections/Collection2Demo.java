package wbs.collections;

import java.util.LinkedHashSet;
import java.util.Set;

public class Collection2Demo {

	/*
	 * wir illustrieren die methoden addAll(), removeAll() und retainAll() von
	 * Collection
	 */
	public static void main(String[] args) {

		Set<Integer> set1 = new LinkedHashSet<>();
		Set<Integer> set2 = new LinkedHashSet<>();
		Set<Integer> set3 = new LinkedHashSet<>();

		Set<Integer> set4 = new LinkedHashSet<>();

		for (int i = 1; i <= 5; i++) {
			set1.add(i);
			set2.add(i);
			set3.add(i);
		}

		for (int i = 3; i <= 7; i++) {
			set4.add(i);
		}

		set1.addAll(set4); // vereinigung: in this ODER in other
		set2.retainAll(set4); // durchschnitt: in this UND in other
		set3.removeAll(set4); // komplement: in this UND NICHT in other

		System.out.println(set1); // [1, 2, 3, 4, 5, 6, 7]
		System.out.println(set2); // [3, 4, 5]
		System.out.println(set3); // [1, 2]
	}

}
