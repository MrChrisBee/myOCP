package wbs.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;



public class ListIteratorDemo {

	/*
	 * wir bestücken eine List mit einigen Integern.
	 * dann geben wir die list vom ende bis zum anfang aus
	 * und verwenden dabei einen ListIterator
	 */
	public static void main(String[] args) {
		
		List<Integer> list = new ArrayList<>();
		
		for(int i = 1;i < 7;i++) {
			list.add(i);
		}
		
		ListIterator<Integer> li = list.listIterator(list.size());
		while(li.hasPrevious()) {
			System.out.println(li.previous());
		}
		// und jetzt andersrum
		while(li.hasNext()) {
			System.out.println(li.next());
		}
	}
}
