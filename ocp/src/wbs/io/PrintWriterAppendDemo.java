package wbs.io;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintWriterAppendDemo {

	public static void main(String[] args) {
		try (FileWriter fw = new FileWriter(
				"resources/io/characterdata/out2.txt",true);
				PrintWriter pw = new PrintWriter(fw)) {
			pw.append("eins");
			pw.append("zwei");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
