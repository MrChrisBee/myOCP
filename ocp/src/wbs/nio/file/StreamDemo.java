package wbs.nio.file;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class StreamDemo {
	public static void main(String[] args) {
		Path in = Paths.get("resources/io/stream/wb_en_de_pejorativ.ser");
		Path out = Paths.get("resources/io/stream/wb_en_de_pejorativ_cp.ser");
		int size = 1024;
		byte[] buffer = new byte[size];
		try (InputStream is = Files.newInputStream(in, StandardOpenOption.READ);
				OutputStream os = Files.newOutputStream(out, StandardOpenOption.CREATE_NEW)) {
			while (is.read(buffer, 0, size) != -1) {
				os.write(buffer, 0, size);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}