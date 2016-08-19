package wbs.collections;

import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class SimpleDictDemo {

	/*
	 * wir bestücken eine map mit deutsch-englischen wortpaaren
	 */
	public static void main(String[] args) {

		Map<String, String> dict = new TreeMap<>();

		dict.put("eins", "one");
		dict.put("zwei", "two");
		dict.put("drei", "three");

		/*
		 * wir geben alle key-values-pairs aus
		 */
		// 1. foreach über alle keys
		// 2. foreach über alle map.entries
		// 3. iterator über alle keys
		// 4. iterator über alle map.entries

		// 5. welche dieser alternativen würden sie bevorzugen

		// 1
		for (String key : dict.keySet()) {
			System.out.println(key + " -> " + dict.get(key));
		}
		System.out.println("---------");
		// 2
		for (Map.Entry<String, String> entry : dict.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
		System.out.println("---------");
		// 3
		Iterator<String> it1 = dict.keySet().iterator();
		String key;
		while (it1.hasNext()) {
			key = it1.next();
			System.out.println(key + " -> " + dict.get(key));
		}
		System.out.println("---------");
		// 4
		Iterator<Map.Entry<String, String>> it2 = dict.entrySet()
				.iterator();
		Map.Entry<String, String> entry;
		while(it2.hasNext()) {
			entry = it2.next();
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}

}
