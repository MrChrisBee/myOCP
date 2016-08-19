package wbs.string_processing;

import java.util.Locale;
import java.util.Scanner;

public class Scanner5Demo {
	public static void main(String[] args) {
		int n = 0;
		double x = 0;
		boolean b = false;
		String s = null;
		try (Scanner scanner = new Scanner(System.in)) {
			scanner.useLocale(Locale.US);
			if (scanner.hasNextInt()) {
				n = scanner.nextInt();
			}
			if (scanner.hasNextDouble()) {
				x = scanner.nextDouble();
			}
			if (scanner.hasNextBoolean()) {
				b = scanner.nextBoolean();
			}
			if (scanner.hasNext()) {
				s = scanner.next();
			}
		}
		System.out.println("n: " + n); // 1
		System.out.println("x: " + x); // 2.0
		System.out.println("b: " + b); // true
		System.out.println("s: " + s); // lalla
	}
}