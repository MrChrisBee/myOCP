package wbs.nested_classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GemischtesDoppelDemo {

	/*
	 * an einem bridge-turnier nehmen 13 damen und 7 herren teil.
	 * 
	 * wir listen alle zusammenstellungen von 4 personen auf, bei denen genau 2
	 * damen und genau 2 herren beteiligt sind. wie viele solcher
	 * zusammenstellungen gibt es?
	 */
	public static void main(String[] args) {
		String[] bridgeSpieler = { "pablo", "ernest", "thomas", "oscar",
				"raymond", "arthur", "immanuel" };

		String[] bridgeSpielerinnen = { "beatrice", "zazie", "marilyn",
				"dorothy", "clementia", "julietta", "anne", "anna", "joan",
				"johanna", "anastasia", "berenice", "anita" };

		List<String> spieler = Arrays.asList(bridgeSpieler);
		List<String> spielerinnen = Arrays.asList(bridgeSpielerinnen);

		MyList<String> spielerList = new MyList<>(spieler);
		MyList<String> spielerinnenList = new MyList<>(spielerinnen);

		List<String> viererBande = new ArrayList<>();

		int n = 0;

		for (List<String> subList1 : spielerList) {
			for (List<String> subList2 : spielerinnenList) {
				if (subList1.size() == 2 && subList2.size() == 2) {
					viererBande.clear();
					viererBande.addAll(subList1);
					viererBande.addAll(subList2);
					System.out.println(viererBande);
					n++; // ((7 * 6) * (13 * 12)) / ((1*2)(1*2))
				}
			}
		}
		System.out.println(n);

	}

}
