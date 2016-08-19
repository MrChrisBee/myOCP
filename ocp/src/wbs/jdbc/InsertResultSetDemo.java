package wbs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertResultSetDemo {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String password = "mysql";
		String sqlSelect = "SELECT * FROM Testtable";
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try {
			connection = DriverManager.getConnection(url, user, password);
			connection.setAutoCommit(false);
			statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			resultSet = statement.executeQuery(sqlSelect);
			resultSet.moveToInsertRow();
			resultSet.updateString(2, "inserted data");
			resultSet.insertRow();
			connection.commit();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			connection.rollback();
		} finally {
			if (connection != null) {
				// ...
				connection.close();
			}
		}
	}
}