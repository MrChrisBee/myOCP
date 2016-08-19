package wbs.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Savepoint;

public class SavepointDemo {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc";
		String user = "root";
		String password = "";
		String sql = "insert into buch (ISBN, TITEL, AUTOR, PREIS) VALUES (?,?,?,?)";
		Savepoint sp1;
		Savepoint sp2;
		Savepoint sp3;
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			conn.setAutoCommit(false);
			PreparedStatement pstmt = conn.prepareStatement(sql);
			sp1 = conn.setSavepoint();
			pstmt.setString(1, "21234567890");
			pstmt.setString(2, "Ne echt, schonwieder, das braucht keiner");
			pstmt.setString(3, "Karl Zum Kotzen");
			pstmt.setString(4, "299.50");
			pstmt.execute();
			sp2 = conn.setSavepoint("sp2");
			pstmt.setString(1, "00174567890");
			pstmt.setString(2, "Mein erstes Buch");
			pstmt.setString(3, "Karl Zum Kotzen");
			pstmt.setString(4, "199.50");
			pstmt.execute();
			sp3 = conn.setSavepoint("sp3");
			pstmt.setString(1, "01714567890");
			pstmt.setString(2, "Mein erstes günstiges Buch");
			pstmt.setString(3, "Karl Zum Kotzen");
			pstmt.setString(4, "59.50");
			pstmt.execute();

			conn.rollback(sp2);
			conn.commit();
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}
	}
}