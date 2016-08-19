package wbs.nio.file;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

// was passiert wenn src nicht existiert
// 		wirft java.nio.file.NoSuchFileException
// was passiert wenn dst existiert. Wovon ist das abhängig?
// 		wirft java.nio.file.FileAlreadyExistsException wenn StandardCopyOption.REPLACE_EXISTING nicht angegeben wird
// ggf. mit resolve() oder mit resolveSibling() arbeiten

public class MoveDemo {
	public static void main(String[] args) {
		Path source = Paths.get(args[0]);
		Path destination = Paths.get(args[1]);
		try {
			//Files.move(source, destination);
			Files.move(source, destination,StandardCopyOption.REPLACE_EXISTING);
		} catch (FileAlreadyExistsException fae) {
			fae.printStackTrace();
		} catch (NoSuchFileException nsfe) {
			nsfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}