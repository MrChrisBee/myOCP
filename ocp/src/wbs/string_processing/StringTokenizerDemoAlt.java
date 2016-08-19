package wbs.string_processing;

import java.util.StringTokenizer;

public class StringTokenizerDemoAlt {
	public static void main(String[] args) {
		String s1 = "a1b25345678c3323d4e51";
		String delim1 = "12345";
		StringTokenizer st1 = new StringTokenizer(s1, delim1);
		while (st1.hasMoreElements()) {
			System.out.println(st1.nextToken());
		}
		System.out.println("----------");
		String s2 = "a b c d e ";
		StringTokenizer st2 = new StringTokenizer(s2);
		while (st2.hasMoreElements()) {
			System.out.println("[" + st2.nextToken() + "]");
		}
		System.out.println("---------- der erste Teil mit Split");
		String regex1 = "[1-5]+";
		String[] aa = s1.split(regex1);
		for(String a :aa) {
			System.out.println(a);
		}
		System.out.println("---------- der zweite Teil mit Split");
		regex1 = "\\s";
		aa = s2.split(regex1);
		for(String a :aa) {
			System.out.println("["+a+"]");
		}
	}
}