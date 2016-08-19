package wbs.generics;

import java.util.ArrayList;
import java.util.List;

public class WildCardDemo {

	/*
	 * wir illustrieren die verwendung von ?
	 */
	public static void main(String[] args) {
		
		List<Integer> iList = new ArrayList<>();
		List<String> sList = new ArrayList<>();
		List<?> list;
		
		// wir bestücken iList und sList
		iList.add(1);
		sList.add("abc");
		
		list = iList;	// ok
		// was können wir unter verwendung von list für elemente hinzufügen?
		// was können wir aus der list rausholen?
		
		// list.add(2);  compilerfehler
		// list.add("def");  compilerfehler
		
		// Integer i = list.get(0);  compilerfehler
		// String s = list.get(0);   compilerfehler
		
		list.add(null);	// ok
		Object o = list.get(0);  // ok
		System.out.println(o.getClass().getSimpleName());  // java.lang.Integer
		
		list = sList;	// ok
		o = list.get(0);  // ok
		System.out.println(o.getClass().getSimpleName());  // java.lang.String
	}
}
