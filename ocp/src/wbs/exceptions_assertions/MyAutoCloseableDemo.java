package wbs.exceptions_assertions;

public class MyAutoCloseableDemo {
	
	public static void main(String[] args) {
		// voraussetzung für try-with-resources:
		// implementierung von Autocloseable (neu in 1.7)
		try (MyAutoCloseable_1 myAutoCloseable_1 = new MyAutoCloseable_1();
				MyAutoCloseable_2 myAutoCloseable_2 = new MyAutoCloseable_2()) {
			// myAutoCloseable_1 und myAutoCloseable_2 sind implizit final
			// myAutoCloseable_1 = new MyAutoCloseable_1();  compilerfehler
			myAutoCloseable_1.m();
		} catch (Exception e) {
			System.out.println("exception: " + e.getMessage());
		} finally {
			System.out.println("in finally");
		}
	}
}