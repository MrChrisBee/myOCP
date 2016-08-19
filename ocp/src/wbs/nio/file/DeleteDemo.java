package wbs.nio.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DeleteDemo {
	public static void main(String[] args) {
		Path file = Paths.get(args[0]);
		try {
			Files.delete(file);
			// Files.move(source,
			// destination,StandardCopyOption.REPLACE_EXISTING);
		} catch (NoSuchFileException nsfe) {
			nsfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}