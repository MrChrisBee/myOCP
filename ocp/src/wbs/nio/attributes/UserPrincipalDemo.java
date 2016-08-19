package wbs.nio.attributes;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.nio.file.attribute.UserPrincipalNotFoundException;

public class UserPrincipalDemo {
	public static void main(String[] args) throws IOException {
		String s = "resources/io/characterdata/java_keywords.txt";
		Path path = Paths.get(s);
		UserPrincipalLookupService lookupService = FileSystems.getDefault().getUserPrincipalLookupService();
		UserPrincipal userPrincipal = lookupService.lookupPrincipalByName("master");
		System.out.println("i am here");
		System.out.println(userPrincipal);
		userPrincipal = Files.getOwner(path);
		System.out.println(userPrincipal);
		try {
			Files.setOwner(path, lookupService.lookupPrincipalByName("tester"));
		} catch (UserPrincipalNotFoundException e) {
			System.out.println(e);
			System.out.println("Den User scheint es nicht zu geben!");
		}
	}
}