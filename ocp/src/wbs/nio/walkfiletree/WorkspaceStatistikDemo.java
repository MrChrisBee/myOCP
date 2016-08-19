package wbs.nio.walkfiletree;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

/*
 * Wir ermitteln, wie viele Java-Source-Dateien sich in unserem Workspace befinden, 
 * und wie viel Speicherplatz sie belegen.
 */
public class WorkspaceStatistikDemo {
	static int anzahlDerDateien = 0;
	static int belegterSpeicher = 0;

	public static void main(String[] args) {
		Path searchDir = Paths.get("C://Users//Master//git//UnterichtsmaterialOCP//ocp");
		String javaDateien = "glob:*.java";
		String ignoriereDies = "glob:bin"; // ist es irgenwie möglich .settings
											// auszuschliessen?
		final PathMatcher matchFiles = FileSystems.getDefault().getPathMatcher(javaDateien);
		final PathMatcher matchDirs = FileSystems.getDefault().getPathMatcher(ignoriereDies);
		try {
			Files.walkFileTree(searchDir, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
					if (matchDirs.matches(dir.getFileName())) {
						System.out.println("Suche in " + dir.getFileName() + " wird übersprungen!");
						return FileVisitResult.SKIP_SUBTREE; 
						//überspringt alle Treffer in Verzeichnissen
						// die matchDirs entsprechen (bring nur einen Zeitvorteil)
					}
					return FileVisitResult.CONTINUE;
				}

				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					if (matchFiles.matches(file.getFileName())) {
						anzahlDerDateien++;
						belegterSpeicher += attrs.size();
					}
					return FileVisitResult.CONTINUE;
				}
			});
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		System.out.println("Es gibt " + anzahlDerDateien + " Dateien, die ca. " + (belegterSpeicher / 1024)
				+ " Speicherplatz kb belegen!");
	}
}
