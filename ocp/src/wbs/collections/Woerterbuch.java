package wbs.collections;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * wir könnte aus ihrer sicht die schnittstelle eines brauchbaren
 * wörterbuchs aussehen (für den zweck des schimpfens)
 */

/*
 * zu einem der quellsprache kann es beliebig viele wörter der zielsprache 
 * geben (wörter der zielsprache aufsteigend sortiert)
 * 
 * ein wörterbuch soll invertiert werden können; neue wörterbücher
 * sollen aus bereits bestehenden erzeugt werden können.
 * 
 * wörterbücher sollen persistiert werden können (als csv- datei (comma
 * separated values), als serialsiertes java-objekt, als xml-datei, datenbank) und aus
 * externen dateien / datenbank rekonstruiert werden können
 * 
 * elementare operationen:
 * 
 * putWord()  -> zu einem wort der quellsprache ein wort der zielsprache eintragen
 * putWords()  -> zu einem wort der quellsprache beliebig viele wörter der zielsprache eintragen
 * updateWord() -> ersetzt zu einem wort der quellsprache ein wort der zielsprache durch ein anderes
 * removeWord() -> löscht zu einem wort der quellsprache ein wort der zielsprache
 * removeEntry() -> löscht einen eintrag der quellsprache komplett
 * 
 * alle methoden liefern den typ boolean (true, falls durch den aufruf der operation das wörterbuch
 * geändert wurde)
 */

public class Woerterbuch implements Serializable {

	private static final long serialVersionUID = 1L;

	private NavigableMap<String, NavigableSet<String>> dictionary;

	private String srcLanguage;
	private String dstLanguage;

	public Woerterbuch(String srcLanguage, String dstLanguage) {
		this.srcLanguage = srcLanguage;
		this.dstLanguage = dstLanguage;
		dictionary = new TreeMap<>();
	}

	public String getSrcLanguage() {
		return srcLanguage;
	}

	public String getDstLanguage() {
		return dstLanguage;
	}

	public boolean putWord(String srcWord, String dstWord) {
		NavigableSet<String> dstWords = dictionary.get(srcWord);
		if (dstWords == null) {
			dstWords = new TreeSet<>();
			dictionary.put(srcWord, dstWords);
		}
		return dstWords.add(dstWord);
	}

	public boolean putWords(String srcWord, String dstWord, String... dstWords) {
		boolean isChanged_1 = putWord(srcWord, dstWord);
		boolean isChanged_2 = dictionary.get(srcWord).addAll(Arrays.asList(dstWords));
		return (isChanged_1 || isChanged_2);
	}

	// srcWord(0) -> false
	// srcWord(1), dstOldWord(0) -> false
	// srcWord(1), dstOldWord(1), dstNewWord(1) -> false
	// srcWord(1), dstOldWord(1), dstNewWord(0) -> true
	public boolean updateWord(String srcWord, String dstOldWord, String dstNewWord) {
		boolean isChanged = false;
		NavigableSet<String> dstWords = dictionary.get(srcWord);
		if (dstWords != null && dstWords.contains(dstOldWord) && !dstWords.contains(dstNewWord)) {
			dstWords.remove(dstOldWord);
			dstWords.add(dstNewWord);
			isChanged = true;
		}
		return isChanged;
	}

	public boolean removeWord(String srcWord, String dstWord) {
		boolean isChanged = false;
		NavigableSet<String> dstWords = dictionary.get(srcWord);
		if (dstWords != null) {
			isChanged = dstWords.remove(dstWord);
			if (dstWords.size() == 0) {
				dictionary.remove(srcWord);
				isChanged = true;
			}
		}
		return isChanged;
	}

	public boolean removeEntry(String srcWord) {
		return (dictionary.remove(srcWord) != null);
	}

	public NavigableSet<String> getWords(String srcWord) {
		return dictionary.get(srcWord);
	}

	/*
	 * wir schreiben eine methode, die alle wörter der quellsprache liefert
	 */
	public Set<String> srcWords() {
		return dictionary.keySet();
	}

	public Set<String> getSrcWords() {
		return dictionary.keySet();
	}

	public Set<String> getEntry(String srcWords) {
		return dictionary.get(srcWords);
	}

	public Woerterbuch invertDict() {
		Woerterbuch inverted = new Woerterbuch(this.getDstLanguage(), this.getSrcLanguage());
		for (Map.Entry<String, NavigableSet<String>> entry : dictionary.entrySet()) {
			for (String word : entry.getValue()) {
				inverted.putWord(word, entry.getKey());
			}
		}
		return inverted;
	}

	/*
	 * wir schreiben die methode combine(). sie liefert zu 2 wörterbüchern ein
	 * drittes wörterbuch.
	 * 
	 * wb1: a -> b (österreichisch -> hochdeutsch) wb2: b -> c (hochdeutsch ->
	 * plattdeutsch) ergebnis: wb3: a -> c (österreichisch -> plattdeutsch)
	 */
	public static Woerterbuch combine(Woerterbuch wb1, Woerterbuch wb2) throws IllegalArgumentException {
		if (!wb1.getDstLanguage().equals(wb2.getSrcLanguage()) || wb2.getDstLanguage().equals(wb1.getSrcLanguage())) {
			throw new IllegalArgumentException("invalid arguments...");
		}
		Woerterbuch wb = new Woerterbuch(wb1.getSrcLanguage(), wb2.getDstLanguage());
		NavigableSet<String> words;
		for (Map.Entry<String, NavigableSet<String>> entry : wb1.dictionary.entrySet()) {
			for (String srcWord : entry.getValue()) {
				words = wb2.getWords(srcWord);
				if (words != null) {
					for (String dstWord : words) {
						wb.putWord(srcWord, dstWord);
					}
				}
			}
		}
		return wb;
	}

	/*
	 * wir schreiben die methode importFromCSV(). sie importiert daten aus einer
	 * externen datei ins wörterbuch. format der eingabedatei:
	 * source:dest1,dest2,dest3
	 */

	public void importFromCSV(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			String line;
			String srcWord;
			String[] dstWords;
			int pos;
			while ((line = br.readLine()) != null) {
				try {
					pos = line.indexOf(':');
					srcWord = line.substring(0, pos);
					dstWords = line.substring(pos + 1).split(",");
					for (String dstWord : dstWords) {
						putWord(srcWord, dstWord);
					}
				} catch (RuntimeException e) {
					System.out.println("error..." + e);
				}
			}
		}
	}

	/*
	 * wir schreiben nun die methode exportAsCSV(); sie exportiert alle einträge
	 * des wörterbuches in einem format, das von importFromCSV() eingelesen
	 * werden kann.
	 */

	public void exportAsCSV(String path) throws FileNotFoundException {
		int numberOfTokens;
		int numberOfLines = dictionary.size();
		int nTokens;
		int nLines = 1;
		try (PrintWriter pw = new PrintWriter(path)) {
			for (Map.Entry<String, NavigableSet<String>> entry : dictionary.entrySet()) {
				nTokens = 1;
				pw.print(entry.getKey() + ":");
				numberOfTokens = entry.getValue().size();
				for (String dstWord : entry.getValue()) {
					pw.print(dstWord);
					if (nTokens < numberOfTokens) {
						pw.print(",");
					}
					nTokens++;
				}
				if (nLines < numberOfLines) {
					pw.println();
				}
				nLines++;
			}
		}
	}

}
