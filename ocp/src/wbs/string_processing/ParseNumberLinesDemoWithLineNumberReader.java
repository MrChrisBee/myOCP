package wbs.string_processing;

import java.io.File;
import java.io.FileReader;
import java.io.LineNumberReader;
import java.util.StringTokenizer;

/*
 * wir berechnen für jede Zeile aus zahlen.txt die summe und geben Sie aus.
 * zum zerlegen der Zeile verwenden wir einen StringTokenizer (veraltet aber für die Prüfung wichtig)
 * bei Fehlerhaften Zeilen geben wir eine Fehlermeldung aus und machen mit der nächsten Zeile weiter
 * 
 *    Techniken
 *    -> java.io / BufferedReader
 *    -> try with resources
 *    -> string processing
 *    -> exception handling
 *    
 *     Schwierigkeit: medium
 */
public class ParseNumberLinesDemoWithLineNumberReader {

	public static void main(String[] args) {
		File file = new File("recources/io/characterdata/zahlen.txt");
		String line;
		StringTokenizer st;
		Integer i = 0;
		int summe = 0;
		String token = "";
		try (LineNumberReader br = new LineNumberReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				st = new StringTokenizer(line);
				while (st.hasMoreElements()) {
					token = st.nextToken();
					try {
						i = Integer.parseInt(token);
					} catch (NumberFormatException e) {
						System.out.println("Der Token " + token + 
								" passt nicht in mein Muster: Nur Zahlen sind erlaubt!\n" + "Fehler in Zeile " 
								+ br.getLineNumber() + " der Quelldatei!");
					}
					summe += i;

				}
				System.out.println("Die Summe der Zeile " + br.getLineNumber() + " ist: " + summe);
				summe = 0;
			}
			System.out.println(br.getLineNumber() + " Zeilen eingelesen!");
		} catch (Exception e) {
			System.out.println("Konnte die Datei nicht finden");
			e.printStackTrace();
		}
	}

}
