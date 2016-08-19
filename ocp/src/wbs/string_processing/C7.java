package wbs.string_processing;

//Symbol Beschreibung
//. ein beliebiges Zeichen
//\d Ziffer
//\D keine Ziffer
//\s white space
//\S kein white space
//\w [a-zA-Z0-9_]
//\W [^a-zA-Z0-9_]

public class C7 {
	public static void main(String[] args) {
		System.out.printf("%s %s %s%n", "eins", "zwei", "drei");
		// eins zwei drei =^ kein Whitespace
		System.out.printf("%2$s %1$s%n", "eins", "zwei", "drei"); // zwei eins
		System.out.printf("%1$s %2$s %s %n", "eins", "zwei", "drei");
		// eins zwei drei ups
		// das erste erscheinen von %n (eines nicht positionsgebundenen
		// Ausdrucks)
		// spricht das erste element der Parameterliste an
		System.out.printf("%1$s %2$s %3$s %<s%n", "eins", "zwei", "drei");
		// eins zwei drei drei
	}
}