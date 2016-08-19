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
public class CreateFileAndSetAttributresMainTrowsDemo {

	/*
	 * Hier soll eine java.nio.File
	 */
	public static void main(String[] args) throws IOException {
		Path path = Paths.get("resources/io/characterdata/textdatei.txt");

		BufferedWriter bw = Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.CREATE_NEW);
		bw.write("Hier geht es los!!\n");
		bw.close(); 

		bw = Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		bw.write("Noch ne Zeile\n");
		bw.close();

		Files.setAttribute(path, "dos:readonly", true);

		bw = Files.newBufferedWriter(path, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
		bw.write("Noch ne weitere Zeile\n");
		bw.close();
		// hier ist dann Feierabend, nach dem die exception geflogen ist kommt hier keiner mehr an
		Files.setAttribute(path, "dos:readonly", false);
		Files.delete(path);
	}
}
