package wbs.nio.attributes;

import java.nio.file.Files;
import java.nio.file.Paths;


public class C04 {
	public static void main(String[] args) throws Exception {
		String file1 = "resources/io/file1";
		String file2 = "resources/io/file2";
		String file3 = Paths.get(file1).toAbsolutePath().toString();
		System.out.println(file3); 
		Files.createFile(Paths.get(file1));
		Files.createFile(Paths.get(file2));
		System.out.println(Files.isSameFile(Paths.get(file1), Paths.get(file2)));
		System.out.println(Files.isSameFile(Paths.get(file1), Paths.get(file3)));
	}
}