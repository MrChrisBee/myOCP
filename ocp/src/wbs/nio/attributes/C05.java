package wbs.nio.attributes;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;


public class C05 {
	public static void main(String[] args) throws Exception {
		String dir = "resources/io/characterdata/java_keywords.txt";
		Path path = Paths.get(dir);
		Map<String, Object> attributes = Files.readAttributes(path, "*");
		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			if (entry.getValue() != null) {
				System.out.println(entry.getKey() + "," + entry.getValue() + "  ("
						+ entry.getValue().getClass().getSimpleName() + ")");
			}
		}
		System.out.println("--------");
		attributes = Files.readAttributes(path, "dos:*");
		for (Map.Entry<String, Object> entry : attributes.entrySet()) {
			if (entry.getValue() != null) {
				System.out.println(entry.getKey() + "," + entry.getValue() + "("
						+ entry.getValue().getClass().getSimpleName() + ")");
			}
		}
	}
}