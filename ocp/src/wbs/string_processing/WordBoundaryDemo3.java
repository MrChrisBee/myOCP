package wbs.string_processing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordBoundaryDemo3 {
	public static void main(String[] args) {
		String regex1 = "\\B";
		String s1 = "^23 *$76 bc";
		Pattern p1 = Pattern.compile(regex1);
		Matcher m1 = p1.matcher(s1);
		while (m1.find()) {
			System.out.print(m1.start() + " ");
		}
		// 0 2 4 5 7 10
	}
}