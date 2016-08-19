package wbs.nio.attributes;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/*
 * Wir erzeugen eine Einzeilige Textdatei und schließen sie.
 * wir öffnen die Textdatei, hängen eine Zeile an und schließen erneut
 * dann setzen wir das dos-attribut readonly auf true
 * Dann versuchen wir nochmals, ein Zeile anzuhängen.
 */
public class CreateFileAndSetAttributresDemo {

	/*
	 * Hier soll eine java.nio.File
	 */
	public static void main(String[] args) {
		Path path = Paths.get("resources/io/characterdata/textdatei.txt");

		try (BufferedWriter bw = Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.CREATE_NEW);) {
			bw.write("Hier geht es los!!\n");
		} catch (Exception e) {
			e.printStackTrace();   
		}

		try (BufferedWriter bw = Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.APPEND);) {
			bw.write("Noch ne Zeile\n");
		} catch (Exception e) {
			e.printStackTrace();
		}
	
		try {
			Files.setAttribute(path, "dos:readonly", true);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		try (BufferedWriter bw = Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.APPEND);) {
			bw.write("Noch ne weitere Zeile\n");
		} catch (Exception e) {
			System.out.println("Die Datei ist schreibgeschützt");
		}

		try {
			Files.setAttribute(path, "dos:readonly", false);
			Files.delete(path);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
