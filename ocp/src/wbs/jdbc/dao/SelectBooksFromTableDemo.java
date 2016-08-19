package wbs.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectBooksFromTableDemo {

	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		String query = "select ISBN, TITEL, AUTOR, PREIS from buch";

		try (Connection conn = DriverManager.getConnection(url, user, password);
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {

			while (rs.next()) {
				String isbn = rs.getString("ISBN");
				String titel = rs.getString("TITEL");
				String autor = rs.getString("AUTOR");
				double preis = rs.getDouble("PREIS");
				System.out.println(isbn + ";" + titel + ";" + autor + ";" + preis);
			}

		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
