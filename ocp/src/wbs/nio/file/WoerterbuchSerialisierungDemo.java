package wbs.nio.file;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import wbs.collections.Woerterbuch;

/*
 * Wir machen die Klasse Woerterbuch serialisierbar
 * dann erzeugen wir ein woerterbuch und lesen Daten aus einer csv-Datei ein
 * dann serialisieren wir das Woerterbuch und holen uns den Stream zu schreiben von Files
 * dann holen wir einen Inputstream von Files, lesen das serialisierte Woertebuch ein
 * und geben den Inhalt auf stdout aus
 */

public class WoerterbuchSerialisierungDemo {

	public static void main(String[] args) throws ClassNotFoundException {
		Path in = Paths.get("resources/io/characterdata/schimpfwoerter.txt");
		Path out = Paths.get("resources/io/stream/schimpfwoerter.ser");

		// Wörterbuch erzeugen
		Woerterbuch wbNeu = new Woerterbuch("schwaebisch", "hochdeutsch");

		try {
			wbNeu.importFromCSV(in.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		// in wbNeu haben wir es

		// nun schreiben wir es in eine Stream Datei
		try (ObjectOutputStream oos = new ObjectOutputStream(Files.newOutputStream(out, StandardOpenOption.CREATE_NEW))) {
			oos.writeObject(wbNeu);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// lösche das alte wöerterbuch
		wbNeu = null;

		try (ObjectInputStream ois = new ObjectInputStream(Files.newInputStream(out, StandardOpenOption.READ))) {
			wbNeu = (Woerterbuch) ois.readObject();
			for (String eintrag : wbNeu.getSrcWords()) {
				System.out.println(eintrag + " -> " + wbNeu.getEntry(eintrag));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			Files.delete(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
