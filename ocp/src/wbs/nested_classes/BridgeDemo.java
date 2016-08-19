package wbs.nested_classes;

import java.util.Arrays;
import java.util.List;

public class BridgeDemo {

	/*
	 * an einem bridgeturnier nehmen 10 bridge-spielerinnen teil.
	 * 
	 * wir listen alle möglichen zusammenstellungen von 4 damen
	 * zu einer bridge-partie auf.
	 */
	public static void main(String[] args) {
		String[] bridgeSpielerinnen = { "beatrice", "zazie", "marilyn", "dorothy",
				"clementia", "julietta", "anne", "anna", "joan", "johanna" };

		List<String> list = Arrays.asList(bridgeSpielerinnen);
		MyList<String> mylist = new MyList<>(list);

		int n = 0;

		for (List<String> sublist : mylist) {
			if (sublist.size() == 4) {
				System.out.println(sublist);
				n++;
			}
		}

		System.out.println("bei " + bridgeSpielerinnen.length
				+ " teilnehmerinnen gibt es " + n
				+ " mögliche zusammenstellungen von 4 spielerinnen");
	}
}
