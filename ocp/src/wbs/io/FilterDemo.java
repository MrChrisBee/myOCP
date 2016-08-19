package wbs.io;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.Arrays;

public class FilterDemo {
	public static void main(String[] args) {
		String path = "resources/io/characterdata";
		File dir = new File(path);
		File[] files;
		files = dir.listFiles(new FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.length() > 200 && file.length() < 300;
			}
		});
		System.out.println(Arrays.toString(files));
		System.out.println("---------------");
		files = dir.listFiles(new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});
		System.out.println(Arrays.toString(files));
	}
}