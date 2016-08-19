package wbs.generics;

import java.util.ArrayList;
import java.util.List;

/*
 * wir illustrieren die verwendung von ? extends
 */

public class WildcardExtendsDemo {

	public static void main(String[] args) {
		
		List<Integer> iList = new ArrayList<>();
		List<Double> dList = new ArrayList<>();
		List<String> sList = new ArrayList<>();
		List<? extends Number> list;
		
		iList.add(1);	// ok
		dList.add(2.0);	// ok
		sList.add("abc");	// ok
		
		// list = sList;  // compilerfehler
		list = iList;	// ok
		// list.add(2);  compilerfehler
		// Integer i = list.get(0);  compilerfehler
		Number n = list.get(0);	// ok
		System.out.println(n.getClass().getSimpleName());  // Integer
		
		list = dList;  // ok
		n = list.get(0);	// ok
		System.out.println(n.getClass().getSimpleName());  // Double
		
	}
}
