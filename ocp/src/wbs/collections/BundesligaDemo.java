package wbs.collections;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.Random;
import java.util.TreeSet;

/*
 * nach dem ende der bundesligasaison ermitteln wir für jeden verein
 * die punktezahl und die tordifferenz
 * (differenz zwischen geschossenen und kassierten toren).
 * 
 * alle vereine packen wir in ein set.
 * 
 * dann iterieren wir über alle vereine. die iteration soll die vereine
 * aufsteigend sortiert liefern (punktestand, tordifferenz, name).
 * 
 * 1. wir brauchen ein TreeSet
 * 2. die klasse BundesligaVerein muss ein natural ordering haben
 * (also Comparable implementieren), oder dem TreeSet wird im konstruktor
 * ein passender Comparator übergeben
 */

class BundesligaVerein {

	String name;
	int punkte;
	int tordifferenz;

	public BundesligaVerein(String name, int punkte, int tordifferenz) {
		this.name = name;
		this.punkte = punkte;
		this.tordifferenz = tordifferenz;
	}

	@Override
	public String toString() {
		return "BundesligaVerein [name=" + name + ", punkte=" + punkte
				+ ", tordifferenz=" + tordifferenz + "]";
	}
}

public class BundesligaDemo {

	public static void main(String[] args) {

		Random random = new Random();

		String name;
		int punkte;
		int tordifferenz;

		BundesligaVerein verein;

		Comparator<BundesligaVerein> cmp = new Comparator<BundesligaVerein>() {

			@Override
			public int compare(BundesligaVerein v1, BundesligaVerein v2) {
				int diff = Integer.compare(v1.punkte, v2.punkte);
				if (diff == 0) {
					diff = Integer.compare(v1.tordifferenz, v2.tordifferenz);
					if (diff == 0) {
						diff = v1.name.compareTo(v2.name);
					}
				}
				return diff;
			}

		};

		NavigableSet<BundesligaVerein> vereine = new TreeSet<>(cmp);

		for (int i = 1; i <= 18; i++) {
			name = "name_" + i;
			punkte = random.nextInt(40);
			tordifferenz = random.nextInt(30);
			verein = new BundesligaVerein(name, punkte,
					Math.random() > 0.5 ? tordifferenz : -tordifferenz);
			vereine.add(verein);
		}

		for (BundesligaVerein v : vereine) {
			System.out.println(v);
		}

	}

}
