package wbs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultSetDemo {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String password = "";
		String sql = "SELECT * FROM buch";
		try (Connection connection = DriverManager.getConnection(url, user, password);
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery(sql)) {
			while (resultSet.next()) {
				//System.out.println(resultSet.getInt("isbn") +" : " +  resultSet.getString("titel")+" von " + resultSet.getString("autor")+ " € " + resultSet.getDouble("preis"));
				System.out.printf("Das Buch %2$s %n",resultSet.getInt("isbn"),resultSet.getString("titel"),resultSet.getString("autor"),resultSet.getDouble("preis"));
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}