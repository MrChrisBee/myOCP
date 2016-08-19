package wbs.nested_classes;

import java.util.Arrays;
import java.util.List;

public class SkatDemo {

	/*
	 * an einem skatturnier nehmen 10 herren teil.
	 * 
	 * wir listen alle möglichen zusammenstellungen von 3 herren zu einer
	 * skat-partie auf.
	 */
	public static void main(String[] args) {

		String[] skatSpieler = { "pablo", "ernest", "thomas", "oscar",
				"raymond", "arthur", "immanuel", "john", "edward", "iannis" };

		List<String> list = Arrays.asList(skatSpieler);
		MyList<String> mylist = new MyList<>(list);

		int n = 0;

		for (List<String> sublist : mylist) {
			if (sublist.size() == 3) {
				System.out.println(sublist);
				n++;
			}
		}

		System.out.println("bei " + skatSpieler.length
				+ " teilnehmern gibt es " + n
				+ " mögliche zusammenstellungen von 3 spielern");

	}

}
