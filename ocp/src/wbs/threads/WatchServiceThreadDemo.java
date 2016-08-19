package wbs.threads;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/*
 * Die Main Methode startet einen WatchService in einem eigenen thread.
 * In dem Verzeichnis, das vom WatchService überwacht wird, erzeugt der 
 * main()-Thread einige neue Dateien (und pausiert dazwischen)
 * 
 *  Mit dem Ende von main() soll soll auch der WatchServiceTread beendet werden. 
 */
class WatchMyDir extends Thread {

	@Override
	public void run() {
		Path path = Paths.get("C:/Users/Master/git/UnterichtsmaterialOCP/ocp/resources/watchme");
		WatchService watchService = null;
		try {
			watchService = path.getFileSystem().newWatchService();
			path.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		for (;;) {
			WatchKey key = null;
			try {
				key = watchService.take();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			for (WatchEvent<?> event : key.pollEvents()) {
				//System.out.println(event);
				switch (event.kind().name()) {
				case "OVERFLOW":
					System.out.println("We lost some events");
					break;
				case "ENTRY_DELETE":
					System.out.println("File " + event.context() + " was deleted!");
					break;
				case "ENTRY_CREATE":
					System.out.println("File " + event.context() + " has been created!");
					break;
				case "ENTRY_MODIFY":
					System.out.println("File " + event.context() + " is changed!");
					break;
				}
			}
			key.reset();
		}
	}
}

public class WatchServiceThreadDemo {
	public static void main(String[] args) {
		WatchMyDir watchIt = new WatchMyDir();
		watchIt.setDaemon(true);
		watchIt.start();
		Path dir = Paths.get("C:/Users/Master/git/UnterichtsmaterialOCP/ocp/resources/watchme");
		try {
				if (!Files.exists(dir)) { // erzeuge das Verzeichnis aus dir
					Files.createDirectory(dir);
				}
				Thread.sleep(500);
				Files.createFile(Paths.get(dir + "\\" + "A.txt"));
				Thread.sleep(500);
				Files.createFile(Paths.get(dir + "\\" + "B.txt"));
				Thread.sleep(500);
				Files.move(Paths.get(dir + "\\" + "B.txt"), Paths.get(dir + "\\" + "C.txt"));
				Thread.sleep(500);
				Files.delete(Paths.get(dir + "\\" + "A.txt"));
				Thread.sleep(500);
				Files.delete(Paths.get(dir + "\\" + "C.txt"));
				Thread.sleep(1000);
			
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} 
}
