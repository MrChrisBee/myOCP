package wbs.nio.path;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathImplAreImutabls {

	public static void main(String[] args) {
		Path path1 = Paths.get("D:\\sales\\.\\quarterly\\..\\report");
		path1 = path1.normalize();
		Path path2 = path1.relativize(Paths.get("D:\\empdetails.dat"));
		path2 = path2.resolve(path1);
		System.out.println(path1);
		System.out.println(path2);

	}

}
