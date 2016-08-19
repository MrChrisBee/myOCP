package wbs.collections;

import java.util.SortedSet;
import java.util.TreeSet;

public class SubSetDemo {

	/*
	 * wir bestücken ein SortedSet mit einigen elementen.
	 * 
	 * dann holen wir zu diesem set ein subset.
	 * 
	 * dann fügen wir in dieses subset ein neues element ein (innerhalb der
	 * intervallgrenzen) und geben das original aus.
	 * 
	 * wir versuchen, in das subset ein neues element ausserhalb der
	 * intervallgrenzen einzufügen, und ermitteln, was passiert.
	 */
	public static void main(String[] args) {

		SortedSet<Integer> set = new TreeSet<>();
		SortedSet<Integer> subset;

		for (int i = 1; i <= 10; i++) {
			set.add(i * 3);
		}
		
		System.out.println(set); // [3, 6, 9, 12, 15, 18, 21, 24, 27, 30]
		
		subset = set.subSet(10, 20);
		System.out.println(subset);  // [12, 15, 18]
		
		subset.add(14);
		System.out.println(set); // [3, 6, 9, 12, 14, 15, 18, 21, 24, 27, 30]
		
		try {
			subset.add(20);
		}
		catch(IllegalArgumentException e) {
			System.out.println("ups...");
		}
	}

}
