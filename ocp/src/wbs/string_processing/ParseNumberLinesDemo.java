package wbs.string_processing;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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
public class ParseNumberLinesDemo {

	public static void main(String[] args) {
		File file = new File("recources/io/characterdata/zahlen.txt");
		String line;
		StringTokenizer st;
		Integer i = 0;
		int summe = 0;
		int lineCounter = 1;
		String token = "";
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			while ((line = br.readLine()) != null) {
				st = new StringTokenizer(line);
				while (st.hasMoreElements()) {
					token = st.nextToken();
					try {
						i = Integer.parseInt(token);
					} catch (NumberFormatException e) {
						System.out.println("Der Token " + token + " passt nicht in mein Muster: Nur Zahlen sind erlaubt!\n" + "Fehler in Zeile " + lineCounter
						 		+ " der Quelldatei!");
					}
					summe += i;

				}
				System.out.println("Die Summe der Zeile " + lineCounter + " ist: " + summe);
				summe = 0;
				lineCounter++;
			}

		} catch (Exception e) {
			System.out.println("Konnte die Datei nicht finden");
			e.printStackTrace();
		}
	}

}
