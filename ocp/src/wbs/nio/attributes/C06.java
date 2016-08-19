package wbs.nio.attributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class C06 {
	public static void main(String[] args) throws IOException {
		String file1 = "resources/io/characterdata/newFile.txt";
		String file2 = "resources/io/characterdata/copy.txt";
		Path path1 = Paths.get(file1);
		Path path2 = Paths.get(file2);
		Files.deleteIfExists(path1);
		Files.createFile(path1);
		Files.copy(path1, path2);
		Files.copy(path1, path2 , StandardCopyOption.REPLACE_EXISTING);
	}
}