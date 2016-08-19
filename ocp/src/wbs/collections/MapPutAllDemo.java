package wbs.collections;

import java.util.HashMap;
import java.util.Map;

public class MapPutAllDemo {

	public static void main(String[] args) {
		Map<CharSequence, CharSequence> map1 = new HashMap<>();
		
		Map<String, String> map2 = new HashMap<>();
		map2.put("eins", "one");
		map2.put("zwei", "two");
		map1.putAll(map2);
		
		Map<String, StringBuffer> map3 = new HashMap<>();
		map3.put("drei", new StringBuffer());
		map3.put("vier", new StringBuffer("four"));
		map1.putAll(map3);
		
		Map<StringBuffer, StringBuilder> map4 = new HashMap<>();
		map4.put(new StringBuffer("fünf"), new StringBuilder("five"));
		map4.put(new StringBuffer("sechs"), new StringBuilder("six"));
		map1.putAll(map4);
		
		System.out.println(map1.size());  // 6

	}

}
