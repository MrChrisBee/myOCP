package wbs.string_processing;

//Word Boundaries
//Symbol Beschreibung
//\b Wortgrenze
//\B keine Wortgrenze

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C12 {
	public static void main(String[] args) {
		String regex = "\\babc\\b";
		String s = "abc xabcd abc";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		s = m.replaceAll("---");
		System.out.println(s);
	}
}