package wbs.collections;

import java.io.IOException;

public class WoerterbuchIODemo {

	public static void main(String[] args) throws IOException {
		/*
		 * wir lesen daten in ein wörterbuch ein, aus einer csv- datei,
		 * und geben dann die eingelesenen daten aus mit System.out...
		 */
		Woerterbuch wb = new Woerterbuch("plattdeutsch", "hochdeutsch");
		String file = "resources/io/characterdata/woerterbuch_plattdeutsch_hochdeutsch.txt";
		wb.importFromCSV(file);
		for(String srcWord : wb.srcWords()) {
			System.out.println(srcWord + " -> " + wb.getWords(srcWord));
		}
		
		wb.exportAsCSV("resources/io/characterdata/exported.txt");
	}
}
