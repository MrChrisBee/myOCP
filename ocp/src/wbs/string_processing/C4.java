package wbs.string_processing;

import java.util.Scanner;

public class C4 {
	public static void main(String[] args) {
		String s = "1 22  333 4444 fuenf 666666";
		Scanner scanner = new Scanner(s);
		while (scanner.hasNext()) {
			//System.out.println(i++); // das Programm hängt sich auf
			if (scanner.hasNextInt()) {
				System.out.println(scanner.nextInt());
			} // wenn das nächste Element kein Int ist 
			  // bleibt die Klasse mit Ihrem Zeiger immer auf der gleichen Position im String
		}
		scanner.close();
	}
}