package wbs.jdbc;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

//design by Holgi

public class InsertBooksIntoTableDemo {

	public static void main(String[] args)  {

		// Verbindung zur Datenbank deklarieren
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		// Pfad zur insert-sql-Datei deklarieren
		String path = "resources/sql/insertBooks.sql";
		String sql = "";
		try {
			sql = new String(Files.readAllBytes(Paths.get(path)));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		// Pfad zur Eingabedatei deklarieren
		String pathBooks = "resources/sql/books.txt";
		File file = new File(pathBooks);
		// sonstige Deklarationen
		String token;
		int count = 0;
		// Verbindung zur Datenbank aufbauen
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			// PreparedStatement mit insert-sql deklarieren
			PreparedStatement pstmt = conn.prepareStatement(sql);
			// einlesen der csv-datei
			try (Scanner scanner = new Scanner(file)) {
				// Trennzeichen Semikolon und Zeilenende deklarieren
				scanner.useDelimiter("[;\n]");
				// schleife bis alle Elemente verarbeitet sind
				while (scanner.hasNext()) {
					token = scanner.next();
					if (token.length() != 0) {
						// weil die Zuweisung für das vorcompilierte
						// PreparedStatement mit dem Wert 1 beginnt
						count++;
						// Zuweisen der Werte in das vorcompilierte
						// PreparedStatement
						if (count < 4) {
							pstmt.setString(count, token);
						} else {
							// das letzte Feld ist vom Typ double
							pstmt.setDouble(4, Double.parseDouble(token));
							// ausführen des PreparedStatements
							try {
								pstmt.execute();
							}catch (SQLException e){
								System.err.println("FEHLER beim insert in Datenbank: " + e);
							}
							// rücksetzen des Feldes count für die nächste Zeile
							count = 0;
						}
					}
				}
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		System.out.println("--- Programm Ende ---");
	}
}
