package wbs.string_processing;

import java.util.Arrays;

//(Gierige) Quantifier
//Symbol Beschreibung
//X? höchstens ein mal
//X* beliebig oft
//X+ mindestends ein mal
//X{n} genau n mal
//X{n,} mindestens n mal
//X{n,m} mindestens n und höchstens m mal

public class C1 {
	public static void main(String[] args) {
		String s = "abrakadabra";
		System.out.println(s.split("a").length);
		System.out.println(Arrays.toString(s.split("a")));
		System.out.println(Arrays.toString(s.split("ra")));
		System.out.println(Arrays.toString(s.split("b")));
		System.out.println(Arrays.toString(s.split("z")));
		System.out.println(s.matches("[abrkd]+"));
		System.out.println(s.matches("a.*a"));
		System.out.println(s.matches("[^xyz]*"));
		System.out.println(s.matches("\\w+"));
	}
}