package wbs.string_processing;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/*
 * Wir ermitteln für jedes Wort in song_of_mysqlf, wie häufig es vorkommt
 * wir geben alle Wörter aus:
 * - alphanumerisch aufsteigend
 * - absteigend nach Häufigkeit
 * 
 *  wir ignorieren groß und kleinschriebung
 */

public class WhitmanDemo {

	public static void main(String[] args) {

		// nutze den Sequenzer in einer map
		Map<String, Sequencer> words = new TreeMap<>();
		// greife auf die .txt Datei zu
		List<String> listOfWords = new ArrayList<>();
		String path = "resources//io//characterdata//song_of_myself_whitman.txt";
		File file = new File(path);
		String token;
		try (Scanner scanner = new Scanner(file)) {
			scanner.useDelimiter("\\s|[,.!?()]");
			while (scanner.hasNext()) { // sichere Ihren Inhalt
				token = scanner.next().toLowerCase();
				if (token.matches("[0-9a-z']+.*[a-z']+|[a-z]")) {
					if (!listOfWords.contains(token)) {
						listOfWords.add(token);
						words.put(token, new Sequencer());
						words.get(token).next();
					} else {
						words.get(token).next(); // zähle hoch
					}
				}

			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}

//		for (Map.Entry<String, Sequencer> eintrag : words.entrySet()) {
//			System.out.println(eintrag.getKey() + " " + eintrag.getValue().getInt());
//		}
//		for (int i = 0; i < 5; i++) {
//			System.out.println("*************************************************************************************");
//		}
		List<Map.Entry<String, Sequencer>> list = new ArrayList<>(words.entrySet());
		// list.addAll();
		Collections.sort(list, new EntryComperator());

//		for (Map.Entry<String, Sequencer> listEntry : list) {
//			System.out.println(listEntry.getKey() + " " + listEntry.getValue().getInt());
//		}
		/*
		 * das Ergebnis soll jetzt noch in eine Datei
		 */
		String pathToOutput = "resources//io//characterdata//song_of_myself_whitman_data.txt";
		try (PrintWriter myPW = new PrintWriter(pathToOutput)){
			int alleWoerter = 0;
			for (Map.Entry<String, Sequencer> listEntry : list) {
				System.out.println(listEntry.getKey() + " " + listEntry.getValue().getInt());
				myPW.printf("%-15s : %5d%n", listEntry.getKey(),listEntry.getValue().getInt());
				alleWoerter += listEntry.getValue().getInt();
			}	
			myPW.printf("Summe aller erfassten Wörter : %10s", alleWoerter);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
