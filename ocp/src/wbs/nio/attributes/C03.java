package wbs.nio.attributes;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class C03 {
	public static void main(String[] args) throws Exception {
		String[] strings = { "ab.pdf", "abpdf", "abhtml", "ab.html", "xzabc", "y123" };
		Path dir = Paths.get("glob");
		DirectoryStream<Path> stream;  
		String[] patterns = { "*{html}", "*.{html}", "*.{html,pdf}", ".[b1]*", "?[z1]*" };
		if (Files.exists(dir)) {
			DirectoryStream<Path> str = Files.newDirectoryStream(dir);
			for (Path path : str) { //löscht alle Einträge in glob 
				Files.delete(path);
			}
		}
		if (!Files.exists(dir)) { // erzeuge das Verzeichnis glob
			Files.createDirectory(dir);
		}
		for (String s : strings) {
			Files.createFile(Paths.get(dir + "\\" + s));
			//Erzeugt eine Datei für jeden Eintrag in strings
		}
		for (String pattern : patterns) {
			stream = Files.newDirectoryStream(dir, pattern);
			System.out.println("--- " + pattern + " ---");
			for (Path path : stream) {
				System.out.println(path);
			}
		}
	}
}