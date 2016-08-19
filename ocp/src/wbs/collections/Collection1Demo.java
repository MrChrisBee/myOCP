package wbs.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashSet;

public class Collection1Demo {

	public static void main(String[] args) {
		
		/*
		 * wir illustrieren die verwendung von ? und ? extends
		 * im interface Collection
		 */
		Collection<CharSequence> c1 = new ArrayList<>();
		
		Collection<String> c11 = new HashSet<>();
		Collection<StringBuffer> c12 = new LinkedHashSet<>();
		
		c11.add("abc");
		c12.add(new StringBuffer("def"));
		
		c1.addAll(c11);
		c1.addAll(c12);
		
		Collection<Integer> c2 = new ArrayList<>();
		c2.add(123);
		
		// c1.addAll(c2);  compilerfehler
		System.out.println(c1.containsAll(c2));  // false
		

	}

}
