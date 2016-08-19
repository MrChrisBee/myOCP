package wbs.collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * wir illustrieren die beiden überladungen der methode reverseOrder() von Collections
 */
public class ReverseOrderDemo {

	public static void main(String[] args) {

		List<String> list = Arrays.asList("a", "z", "b", "y");
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);

		Comparator<String> cmp = new Comparator<String>() {
			@Override
			public int compare(String s1, String s2) {
				return s2.compareTo(s1);
			}
		};
		Collections.sort(list, Collections.reverseOrder(cmp));
		System.out.println(list);
	}
}
