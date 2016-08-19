package wbs.nio.path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class App {
	public static void main(String[] args) {
		Path path = Paths.get("C:\\education\\institute\\student\\report.txt");
		System.out.printf("getName(2): %s%n", path.getName(2));
		System.out.printf("subpath(0, 3): %s%n", path.subpath(0, 3));
		System.out.printf("getRoot(): %s%n", path.getRoot());
		System.out.printf("Path: %s%n", path);
	}
}