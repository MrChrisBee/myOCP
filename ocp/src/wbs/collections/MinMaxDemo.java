package wbs.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/*
 * wir bestücken 10 lists mit jeweils 15 zufallszahlen zwischen 1 und 50.
 * 
 * dann bestücken wir eine list mit referenzen auf diese 10 list.
 * 
 * dann sortieren wir die list of lists aufsteigend nach der differenz zwischen
 * dem minimum und dem maximum
 */

public class MinMaxDemo {
	public static void main(String[] args) {

		List<Integer> iList;
		List<List<Integer>> listOfLists = new ArrayList<>();

		Random rnd = new Random();
		
		Comparator<List<Integer>> cmp = new Comparator<List<Integer>>() {
			@Override
			public int compare(List<Integer> list1, List<Integer> list2) {
				int diff1 = Collections.max(list1) - Collections.min(list1);
				int diff2 = Collections.max(list2) - Collections.min(list2);
				return diff1 - diff2;
			}
		};
		
		for(int i = 0;i < 10;i++) {
			iList = new ArrayList<>();
			for(int k = 0;k < 15;k++) {
				iList.add(rnd.nextInt(50) + 1);
			}
			listOfLists.add(iList);
		}
		
		Collections.sort(listOfLists, cmp);
		
		for(List<Integer> list : listOfLists) {
			System.out.println(list + " -> " + (Collections.max(list) - Collections.min(list)));
		}
	}
}
