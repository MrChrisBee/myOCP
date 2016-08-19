package wbs.nio.attributes;

import java.nio.file.Path;
import java.nio.file.Paths;

public class C01 {
	public static void main(String[] args) {
		Path path = Paths.get("resources\\io\\characterdata\\..\\..\\..\\..\\nasowas");
		System.out.println(path.getNameCount()); // auch die .. (Wechsel) werden gezählt
		System.out.println(path.subpath(0, 4));
		System.out.println(path.normalize()); //gehe 3 hoch (3*..) der Rest ist die Ausgabe
		System.out.println(path.normalize().subpath(0, 1));
		System.out.println(path.normalize().getNameCount());
		System.out.println(path.endsWith("nasowas"));
		System.out.println(path.endsWith("was"));
	}
}