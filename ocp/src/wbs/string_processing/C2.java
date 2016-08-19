package wbs.string_processing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Symbol Beschreibung
//. ein beliebiges Zeichen
//\d Ziffer
//\D keine Ziffer
//\s white space
//\S kein white space
//\w [a-zA-Z0-9_]
//\W [^a-zA-Z0-9_]


// (Gierige) Quantifier
//Symbol Beschreibung
//X? höchstens ein mal
//X* beliebig oft
//X+ mindestens ein mal
//X{n} genau n mal
//X{n,} mindestens n mal
//X{n,m} mindestens n und höchstens m mal

public class C2 {
	public static void main(String[] args) {
		String s = "aber was ist denn das 99a";
		String r1 = "a.*a"; // ein a gefolgt von beliebig vielen Zeichen gefolgt von einem A (ber w | s ist denn d  )
		// r1 macht nicht das was ich erwartet hätte es nimmt den größten möglichen Treffer (is greedy)
		String r2 = "\\s.*\\s"; // ein Whitespace (kann alles sein) .* ein whitespace nimmt auch den größten möglichen Treffer
		String r3 = "\\w+";
		Pattern pattern = Pattern.compile(r1);
		Matcher matcher = pattern.matcher(s);
		while (matcher.find()) {
			System.out.printf("<%s> an position [%d,%d] gefunden%n", matcher.group(), matcher.start(), matcher.end());
		}
		System.out.println("-------------");
		pattern = Pattern.compile(r2);
		matcher = pattern.matcher(s);
		while (matcher.find()) {
			System.out.printf("%s an position [%d,%d] gefunden%n", matcher.group(), matcher.start(), matcher.end());
		}
		System.out.println("-------------");
		pattern = Pattern.compile(r3);
		matcher = pattern.matcher(s);
		while (matcher.find()) {
			System.out.printf("%s an position [%d,%d] gefunden%n", matcher.group(), matcher.start(), matcher.end());
		}
	}
}