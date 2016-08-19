package wbs.string_processing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * wir iterieren über alla java-sourcen in einem verzeichnis
 * und ermitteln für jedes schlüsselwort in java, wie häufig es insgesamt
 * verwendet wird.
 * 
 * die liste mit den schlüsselwörtern wird aus einer datei eingelesen (java_keywords.txt)
 * 
 * die liste wird absteigend sortiert nach häufigkeit ausgegeben
 */

// was nützlich sein könnte:
// - File + FileNameFilter
// - ScannerDemo2
// - AtomicInteger

class EntryComparatorGZ implements Comparator<Map.Entry<String, AtomicInteger>> {
	@Override
	public int compare(Entry<String, AtomicInteger> e1,
			Entry<String, AtomicInteger> e2) {
		int diff = Integer.compare(e2.getValue().get(), e1.getValue().get());
		return diff != 0 ? diff : e1.getKey().compareTo(e2.getKey());
	}
}

public class CountKeywordsDemoGZ {
	public static NavigableMap<String, AtomicInteger> initMap(File file)
			throws IOException {
		NavigableMap<String, AtomicInteger> map = new TreeMap<>();
		String line;
		String[] tokens;
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				tokens = line.split(",");
				for (String token : tokens) {
					map.put(token, new AtomicInteger());
				}
			}
		}
		return map;
	}
	public static void updateMap(File file,
			NavigableMap<String, AtomicInteger> map) throws IOException {
		String word;
		AtomicInteger ai;
		try (Scanner scanner = new Scanner(file)) {
			scanner.useDelimiter("\\W+");
			while (scanner.hasNext()) {
				word = scanner.next();
				ai = map.get(word);
				if(ai != null) {
					ai.incrementAndGet();
				}
			}
		}
	}
	public static void main(String[] args) throws IOException {
		File dir = new File("src/wbs/io");
		File keywordFile = new File(
				"resources/io/characterdata/java_keywords.txt");
		NavigableMap<String, AtomicInteger> map = initMap(keywordFile);
		List<Map.Entry<String, AtomicInteger>> list = new ArrayList<>();
		FilenameFilter filter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".java");
			}
		};
		File[] files = dir.listFiles(filter);
		for (File file : files) {
			updateMap(file, map);
		}
		list.addAll(map.entrySet());
		Collections.sort(list, new EntryComparatorGZ());
		for (Map.Entry<String, AtomicInteger> entry : list) {
			System.out.println(entry);
		}
	}
}
