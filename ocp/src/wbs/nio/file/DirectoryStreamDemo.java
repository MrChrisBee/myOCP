package wbs.nio.file;

import java.io.IOException;
import java.nio.file.DirectoryIteratorException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
 

//Übergabeparameter z.B. src/wbs/io
public class DirectoryStreamDemo {
	public static void main(String[] args) {
		// das klappt so nicht
		//final PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:*Demo.{java}");
		Path dir = Paths.get(args[0]);
		try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, "*Demo.{java}")) {
			for (Path path : stream) {
				System.out.println(path.getFileName());
			}
		} catch (DirectoryIteratorException die) {
			die.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}