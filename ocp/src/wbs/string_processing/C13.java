package wbs.string_processing;

public class C13 {
	public static void main(String[] args) {
		String s1 = "abladen";
		String s2 = "hinab";
		String s3 = "aufladen";
		String pattern = "(ab.*)|(.*ab)"; 
		// ab gefolgt von irgendeinem Zeichen beliebig oft ODER
		// irgendein Zeichen beliebig oft gefolgt von ab
		System.out.println(s1.matches(pattern));
		System.out.println(s2.matches(pattern));
		System.out.println(s3.matches(pattern)); //hier gibt es die Zeichenfolge ab nicht 
	}
}