package wbs.string_processing;

import java.util.Arrays;

public class C9 {
	public static void main(String[] args) {
		String s = "ab.cd.de.ef";
		System.out.println(Arrays.toString(s.split("\\.")));
	}
}