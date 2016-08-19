package wbs.string_processing;

import java.util.StringTokenizer;

public class StringTokenizerDemo {
	public static void main(String[] args) {
		String s1 = "a1b25345678c3323d4e51gg35bb";
		String delim1 = "12345"; // alle Elemente aus dem String gelten als delimiter z.B. auch 51 1  
		StringTokenizer st1 = new StringTokenizer(s1, delim1);
		while (st1.hasMoreElements()) {
			System.out.println(st1.nextToken());
		}
		System.out.println("----------");
		String s2 = "a    b c d e ";
		StringTokenizer st2 = new StringTokenizer(s2);
		while (st2.hasMoreElements()) {
			System.out.println("[" + st2.nextToken() + "]");
		}
	}
}