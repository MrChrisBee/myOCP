package wbs.string_processing;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/*
 * Wir iterieren über alle Java-Sourcen in einem Verzeichnis und ermitteln
 * für jedes Schlüsselwort in Java, wie häufig es insgesamt verwendet wird
 * 
 * Die Liste mit  den Schlüsselwörtern wird aus einer Datei eingelesen (java_keywords.txt)
 * 
 * Diese liste wird absteigend sortiert nach Häufigkeit ausgegeben
 * 
 * in diesem Zusammenhang nützlich:
 * - File + FileNameFilter
 * - ScannerDemo2
 * - AtomicInteger
 */




public class CountKeywordsDemo {

	public static void main(String[] args) {
		// nutze den Sequenzer in einer map
		Map<String, Sequencer> javaKeyWords = new HashMap<>();
		// greife auf die .txt Datei zu 
		String path = "recources//io//characterdata//java_keywords.txt";
		File file = new File(path);
		try (Scanner scanner = new Scanner(file)) {
			scanner.useDelimiter("\\W+");
			while (scanner.hasNext()) { //sichere Ihren Inhalt 
				javaKeyWords.put(scanner.next(), new Sequencer());
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		path = "src//wbs//io";
		File dir = new File(path);
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java"); // filtert die Einträge
			}
		};
		File[] files = dir.listFiles(filter);
		for (File filename : files) {
			try (Scanner scanner = new Scanner(filename)) {
				scanner.useDelimiter("\\W+");
				String token;
				while (scanner.hasNext()) {
					token = scanner.next();
					if (javaKeyWords.containsKey(token)) { // gibt es das Wort
						javaKeyWords.get(token).next(); // zähle hoch
					}
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		}
		// zum Sortieren erzeuge ich eine ArrayList
		List<Map.Entry<String, Sequencer>> list = new ArrayList<>();
		list.addAll(javaKeyWords.entrySet()); // alle Einträge hinzufügen
		Collections.sort(list, new EntryComperator()); // nutze den Comperator
		for (Entry<String, Sequencer> entry : list) { // Ausgabe
			System.out.println(entry.getKey() + " " + entry.getValue().getInt());
		}
	}
}
