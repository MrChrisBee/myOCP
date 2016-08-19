package wbs.jdbc;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.Driver;

public class DataBaseMetaDataDemo {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/";
		String user = "root";
		String password = "";
		ResultSet resultSet;

		/*
		 * Wir ändern den Code. Wir holen uns die Connection Direkt vom MySql Treiber
		 * und verwenden den DriverManager nicht.
		 * -> Class.forName()
		 * -> newInstance() über das ClassObjekt
		 * -> connect() mit geeigneter properties-instanz
		 */

		Properties props = new Properties();
		props.put("url", "jdbc:mysql://localhost:3306/");
		props.put("user", user);
		props.put("password", password);
		Driver driver = null;
		try { 
			driver = (Driver) Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = driver.connect(url, props);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// try (Connection conn = DriverManager.getConnection(url, user,
		// password)) {
		DatabaseMetaData meta = conn.getMetaData();
		System.out.println(meta.getDatabaseProductName());
		System.out.println(meta.getDatabaseProductVersion());
		System.out.println(meta.getDriverMajorVersion());
		System.out.println(meta.getDriverMinorVersion());
		System.out.println(meta.getURL());
		System.out.println(meta.getMaxUserNameLength());
		System.out.println("-----------------");
		resultSet = meta.getCatalogs();
		while (resultSet.next()) {
			for (int i = 1; i <= resultSet.getMetaData().getColumnCount(); i++) {
				System.out.println(resultSet.getMetaData().getColumnName(i) + " -> " + resultSet.getObject(i));
			}
		}
		resultSet.close();
	}
}
