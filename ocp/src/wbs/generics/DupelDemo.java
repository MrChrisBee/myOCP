package wbs.generics;

import java.util.HashSet;
import java.util.Set;

public class DupelDemo {

	/*
	 * wir bestücken ein set mit einigen strings
	 * 
	 * dann erzeugen wir ein set, dass alle dupel von strings enthält, die dieselbe
	 * länge haben
	 */
	public static void main(String[] args) {
		
		Set<String> strings = new HashSet<>();
		Set<Dupel<String,String>> dupelSet = new HashSet<>();
		
		for(int i = 1;i < 10;i++) {
			strings.add(Integer.toBinaryString(i));
		}
		
		for(String s1 : strings) {
			for(String s2 : strings) {
				if(s1.length() == s2.length()) {
					dupelSet.add(new Dupel<>(s1, s2));
				}
			}
		}
		
		for(Dupel<String, String> dupel : dupelSet) {
			System.out.println(dupel);
		}
		System.out.println(dupelSet.size());
	}
}
