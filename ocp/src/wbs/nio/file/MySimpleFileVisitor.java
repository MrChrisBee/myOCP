package wbs.nio.file;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;

public class MySimpleFileVisitor extends SimpleFileVisitor<Path> {
	@Override
	public FileVisitResult postVisitDirectory(Path dir, IOException ioe) throws IOException {
		System.out.println("post -> " + dir.toAbsolutePath());
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
		System.out.println("pre -> " + dir.toAbsolutePath());
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
		System.out.println("visiting -> " + file.toAbsolutePath());
		return FileVisitResult.CONTINUE;
	}

	@Override
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException {
		System.out.println("failed -> " + file.toAbsolutePath());
		return FileVisitResult.CONTINUE;
	}
}