package wbs.string_processing;

import java.util.Arrays;

public class SplitDemo1 {
	public static void main(String[] args) {
		
		String s1 = ",a,b,c,d";
		String s2 = "a,b,c,d,";
		
		String[] sa1 = s1.split(",");
		String[] sa2 = s2.split(",");
		
		// delimiter am anfang liefert ein leeres feld!
		System.out.println(sa1.length + " -> " + Arrays.toString(sa1));
		
		// delimiter am ende lefert kein leeres feld
		System.out.println(sa2.length + " -> " + Arrays.toString(sa2));
	}
}