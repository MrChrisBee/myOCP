package wbs.generics;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapUtil {
	public static <K, V> Map<V, Collection<K>> invertMap(Map<K, V> map) {
		Map<V, Collection<K>> inverted = new HashMap<V, Collection<K>>();
		Collection<K> keyCollection;
		for (Map.Entry<K, V> entry : map.entrySet()) {
			if (!inverted.containsKey(entry.getValue())) {
				keyCollection = new ArrayList<>();
				inverted.put(entry.getValue(), keyCollection);
			} else {
				keyCollection = inverted.get(entry.getValue());
			}
			keyCollection.add(entry.getKey());
		}
		return inverted;
	}
}