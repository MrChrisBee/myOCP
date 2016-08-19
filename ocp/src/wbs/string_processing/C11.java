package wbs.string_processing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C11 {
	public static void main(String[] args) {
		String s = "1aaabb2deeaeed34aaaa56edde";
		String regex = "[ab]+|[de]+";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(s);
		s = m.replaceAll("-");
		System.out.println(s);
	}
}