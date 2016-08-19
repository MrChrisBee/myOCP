package wbs.generics;

import java.util.ArrayList;
import java.util.List;

/*
 * wir illustrieren die verwendung von ? super
 */
public class WildcardSuperDemo {

public static void main(String[] args) {
		
		List<Integer> iList = new ArrayList<>();
		List<Double> dList = new ArrayList<>();
		List<String> sList = new ArrayList<>();
		List<Object> oList = new ArrayList<>();
		List<Number> nList = new ArrayList<>();
		List<? super Number> list;
		
		iList.add(1);	// ok
		dList.add(2.0);	// ok
		sList.add("abc");	// ok
		oList.add("0815"); // ok
		oList.add(0715); // ok
		
		// list = sList;  // compilerfehler
		// list = iList;	// compilerfehler
		// list = dList;  // compilerfehler
		list = oList;	// ok
		
		// list.add("abc");	// compilerfehler
		// list.add(new Object());	// compilerfehler
		list.add(1);	// ok
		list.add(Double.valueOf(2.0));  // ok
		
		list = nList;
		list.add(12345);	// ok
		System.out.println(nList.get(0));  // 12345
	}
}
