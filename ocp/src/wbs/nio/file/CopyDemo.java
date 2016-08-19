package wbs.nio.file;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/*
 * was passiert wenn src nicht existiert
 * 		wirft java.nio.file.NoSuchFileException
 * was passiert wenn dst existiert. Wovon ist das abhängig?
 * 		wirft java.nio.file.FileAlreadyExistsException wenn StandardCopyOption.REPLACE_EXISTING nicht angegeben wird
 * ggf. mit resolve() oder mit resolveSibling() arbeiten
 */

public class CopyDemo {
	public static void main(String[] args) {
		Path source = Paths.get(args[0]);
		Path destination = source.resolveSibling(Paths.get(args[1])); 
		// hier reicht  es dann für args[1] nur einen Dateinamen anzugeben 
		
		try {
			Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING); // überschreiben wenn notwendig
		} catch (FileAlreadyExistsException fae) {
			fae.printStackTrace();
		} catch (NoSuchFileException nsfe) {
			nsfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}