package wbs.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearchDemo {

	/*
	 * wir bestücken eine list mit vornamen als strings. dann sortieren wir die
	 * list aufsteigend. dann suchen wir mit binarySearch() einen vornamen, der
	 * in der list ist, und einen vornamen, der nicht in der list ist, und
	 * interpretieren das ergebnis.
	 * 
	 * dann machen wir dasselbe nochmal, aber die vornamen sind jetzt keine
	 * strings, sondern stringbuffer.
	 */
	public static void main(String[] args) {

		String[] vornamen = { "emily", "dorothy", "bernd", "jim", "john",
				"julio", "julia", "julius" };

		List<String> vornamenAsList = Arrays.asList(vornamen);

		Collections.sort(vornamenAsList);
		System.out.println(vornamenAsList);

		int pos1 = Collections.binarySearch(vornamenAsList, "julia");
		int pos2 = Collections.binarySearch(vornamenAsList, "johanna");

		System.out.println(pos1);
		System.out.println(pos2);

		// variante 2
		List<StringBuffer> vornamen2 = new ArrayList<>();
		for (int i = 0; i < vornamen.length; i++) {
			vornamen2.add(new StringBuffer(vornamen[i]));
		}
		Comparator<StringBuffer> cmp = new Comparator<StringBuffer>() {
			@Override
			public int compare(StringBuffer sb1, StringBuffer sb2) {
				return sb1.toString().compareTo(sb2.toString());
			}
		};
		Collections.sort(vornamen2, cmp);
		pos1 = Collections.binarySearch(vornamen2, new StringBuffer("julia"), cmp);
		pos2 = Collections.binarySearch(vornamen2, new StringBuffer("johanna"), cmp);
		System.out.println("-------------");
		System.out.println(pos1);
		System.out.println(pos2);

	}

}
