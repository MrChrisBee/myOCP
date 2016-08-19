package wbs.collections;

import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetExceptionDemo {

	/*
	 * wir provozieren eine ClassCastException beim verwenden eines TreeSet
	 */
	public static void main(String[] args) {
		SortedSet<StringBuffer> set = new TreeSet<>();
		set.add(new StringBuffer("abc"));
		System.out.println("one");
		set.add(new StringBuffer("cde"));
		System.out.println("two");

	}

}
