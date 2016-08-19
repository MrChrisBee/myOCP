package wbs.nio.file;

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
		//String s = "E:/git/UnterichtsmaterialOCA/oca/src/wbs/basics/ListUndSet.java";
		String s = "c:/info.txt";
		Path path = Paths.get(s);
		UserPrincipalLookupService lookupService = FileSystems.getDefault().getUserPrincipalLookupService();
		UserPrincipal userPrincipal = lookupService.lookupPrincipalByName("master");
		System.out.println(userPrincipal);
		userPrincipal = Files.getOwner(path);
		System.out.println(userPrincipal);
		try {
			Files.setOwner(path, lookupService.lookupPrincipalByName("gz2"));
		} catch (UserPrincipalNotFoundException e) {
			e.printStackTrace();
		}
	}
}