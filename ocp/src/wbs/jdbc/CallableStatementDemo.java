package wbs.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementDemo {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String password = "";
		CallableStatement callableStatement;
		ResultSet resultSet;
		String sql = "{call booksByPrice(?, ?)}";
		int fromId = 10;
		int toId = 20;
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			callableStatement = conn.prepareCall(sql);
			callableStatement.setInt(1, fromId);
			callableStatement.setInt(2, toId);
			resultSet = callableStatement.executeQuery();
			while (resultSet.next()) {
				System.out.println(resultSet.getString(2) + " -> " + resultSet.getString(3)+ " -> " + resultSet.getDouble(4));
			}
			callableStatement.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}