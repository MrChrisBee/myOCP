package wbs.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * wir geben alle zeilen einer text-datei aus
 */
public class BufferedReaderDemo {

	public static void main(String[] args) throws IOException {

		String path = "resources/io/characterdata/woerterbuch_oesterreichisch_hochdeutsch.txt";
		String line;
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		}
	}
}
