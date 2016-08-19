package wbs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
	/*
	 * wir erhöhern die Preise aller Bücher um 20%
	 */

public class UpdateResultSetDemo {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		String sqlSelect = "SELECT * FROM buch";
		// ggf try...catch...finally (OHNE try-with-resources)
		try (Connection connection = DriverManager.getConnection(url, user, password);
				Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
						ResultSet.CONCUR_UPDATABLE); ResultSet resultSet = statement.executeQuery(sqlSelect)) {
			while (resultSet.next()) {
				resultSet.updateDouble(4, resultSet.getDouble(4)*1.2);
				resultSet.updateRow();
				System.out.println(resultSet.getString(2)+  " ist jetzt 20% teuerer, kostet also " + resultSet.getDouble(4) + " €!");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}