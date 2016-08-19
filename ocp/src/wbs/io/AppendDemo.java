package wbs.io;

import java.io.FileWriter;
import java.io.IOException;

public class AppendDemo {
	public static void main(String[] args) {
		String out = "resources/io/characterdata/out.txt";
		try (FileWriter fw = new FileWriter(out, true)) {
			fw.write("vier");
			// fw.append(new StringBuffer("fünf"));
			// fw.append(new StringBuilder("sechs"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}