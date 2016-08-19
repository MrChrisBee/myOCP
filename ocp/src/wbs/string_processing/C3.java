package wbs.string_processing;

import java.util.Scanner;

//Symbol Beschreibung
//. ein beliebiges Zeichen
//\d Ziffer
//\D keine Ziffer
//\s white space
//\S kein white space
//\w [a-zA-Z0-9_]
//\W [^a-zA-Z0-9_]

public class C3 {
	public static void main(String[] args) {
		String s = "a b c d   		e f";
		Scanner scanner1 = new Scanner(s);
		// der Standard scheint useDelimiter("\\s+"); zu sein so viele Whitespace wie du finden kannst
		while (scanner1.hasNext()) {
			System.out.println(scanner1.next());
		}
		scanner1.close();
		System.out.println("----");
		Scanner scanner2 = new Scanner(s);
		scanner2.useDelimiter("\\s+");
		while (scanner2.hasNext()) {
			System.out.println(scanner2.next());
		}
		scanner2.close();
	}
}