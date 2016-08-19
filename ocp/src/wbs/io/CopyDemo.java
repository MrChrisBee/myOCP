package wbs.io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyDemo {
	public static void main(String[] args) {
		String src = "resources/io/characterdata/in.txt";
		String dst = "resources/io/characterdata/out.txt";
		try (InputStream is = new FileInputStream(src);
				OutputStream os = new FileOutputStream(dst)) {
			int bufferSize = 4096;
			byte[] buffer = new byte[bufferSize];
			int size;
			while ((size = is.read(buffer)) != -1) {
				os.write(buffer, 0, size);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}