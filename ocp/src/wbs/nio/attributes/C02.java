package wbs.nio.attributes;

import java.nio.file.Path;
import java.nio.file.Paths;


public class C02 {
	public static void main(String[] args) {
		Path p1 = Paths.get("a/b/c/"); // beides sind relative Pfade
		Path p2 = Paths.get("anna/hanna"); // will ich also von p1 in p2 
		System.out.println(p1.relativize(p2)); // muss ich 3(../) mal hoch
		// und dann in /anna/hanna wechseln
		System.out.println(p1.resolve(p2)); 
		System.out.println(p1.resolveSibling(p2));
	}
}