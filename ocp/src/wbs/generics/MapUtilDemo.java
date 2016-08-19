package wbs.generics;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class MapUtilDemo {

	public static void main(String[] args) {
		/*
		 * wir bestücken eine map.
		 * schlüssel sind strings, die zugehörigen werte die längen der strings.
		 * 
		 * dann invertieren wir die map (die alten werte werden zu schlüsseln der invertierten map,
		 * die alten schlüssel werden zu werten der invertierten map)
		 * 
		 */
		Random rnd = new Random();
		Map<String,Integer> map = new HashMap<>();
		String zahlAsBinaryString;
		while(map.size() < 50) {
			zahlAsBinaryString = Integer.toBinaryString(rnd.nextInt(1023) + 1);
			map.put(zahlAsBinaryString, zahlAsBinaryString.length());
		}
		
		Map<Integer, Collection<String>> inverted = MapUtil.invertMap(map);
		for(Map.Entry<Integer, Collection<String>> entry : inverted.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
	}
}
