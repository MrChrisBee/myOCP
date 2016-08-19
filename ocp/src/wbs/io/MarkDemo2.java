package wbs.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.StringReader;

public class MarkDemo2 {
	public static void main(String[] args) {
		String in = "eins\nzwei\ndrei\nvier";
		String inFile = "resources/io/characterdata/woerterbuch_plattdeutsch_hochdeutsch.txt";
		String line;
		try (BufferedReader br = new BufferedReader(
				Math.random() > 0.5 ? new StringReader(in) : new FileReader(
						inFile))) {
			line = br.readLine();
			System.out.println(line);
			line = br.readLine();
			System.out.println(line);
			br.mark(3000);
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
			if (br.markSupported()) {
				br.reset();
				System.out.println("---------");
				line = br.readLine();
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("IOException");
		}
	}
}
