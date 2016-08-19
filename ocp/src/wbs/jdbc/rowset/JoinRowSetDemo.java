package wbs.jdbc.rowset;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JoinRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

public class JoinRowSetDemo {
	private static String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
	private static String user = "root";
	private static String password = "";

	// sql holen der Daten
	private static String sqlBuch = "select * from buch";
	// sql anlegen der Records
	private static String sqlExemplar = "insert into exemplar (isbn, nr, anschaffungsjahr) values (?,?,?)" ;
	private static String sqlSelectEx = "select * from exemplar";
	private static Random random = new Random();
	
	private static RowSetFactory rowSetFactory;
	private static CachedRowSet cachedRowSetBuch;
	private static CachedRowSet cachedRowSetExemplar;
	private static JoinRowSet joinRowSet;
	

	public static void populateExemplar() {
		try (Connection conn = DriverManager.getConnection(url, user, password);
				Statement stmt = conn.createStatement();
				PreparedStatement pstmt = conn.prepareStatement(sqlExemplar)) {
			ResultSet rs = stmt.executeQuery(sqlBuch); 
			while(rs.next()) {
				for(int i=1;i<3;i++) {
					// Anschaffungsjahr ist 3
					pstmt.setInt(3, 1900 + random.nextInt(116));
					// ISBN ist 1
					pstmt.setString(1, rs.getString(1));
					// Exemplarnummer ist 2
					pstmt.setInt(2,i);
					pstmt.execute();
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		//populateExemplar(); // ist erzeugt und wird nicht mehr benötigt
		
		/*
		 * Wir erzeugen ein CachedRowSet und legen dort alle records der Tabelle Buch ab
		 * Wir erzeugen ein zweites CachedRowSet und legen dort alle records der Tabelle Exemplar ab
		 * Dann verknüpfen wir beide Ergebnismengen über einen join unter der Verwendung eines JoinRowSet.
		 * Dann geben wir für alle Bücher die Buchdaten aus, die Nummer und das Anschaffungsjahr
		 */
		
		//für alles eine Factory holen
		try {
			rowSetFactory = RowSetProvider.newFactory();
			cachedRowSetBuch = rowSetFactory.createCachedRowSet();
			cachedRowSetExemplar = rowSetFactory.createCachedRowSet();
			joinRowSet = rowSetFactory.createJoinRowSet();
			// alle daten für Buch
			cachedRowSetBuch.setUrl(url);
			cachedRowSetBuch.setUsername(user);
			cachedRowSetBuch.setPassword(password);
			cachedRowSetBuch.setCommand(sqlBuch);
			cachedRowSetBuch.execute();
			while(cachedRowSetBuch.next()) {
				System.out.print(cachedRowSetBuch.getString(1) + " ");
				System.out.print(cachedRowSetBuch.getString(2) + " ");
				System.out.print(cachedRowSetBuch.getString(3) + " ");
				System.out.println(cachedRowSetBuch.getDouble(4));
			}
			System.out.println("****************************************");
			cachedRowSetExemplar.setUrl(url);
			cachedRowSetExemplar.setUsername(user);
			cachedRowSetExemplar.setPassword(password);
			cachedRowSetExemplar.setCommand(sqlSelectEx);
			cachedRowSetExemplar.execute();
			joinRowSet.addRowSet(cachedRowSetBuch,"isbn");
			joinRowSet.addRowSet(cachedRowSetExemplar,"isbn");
			
			while (joinRowSet.next()) {
				System.out.println(
						joinRowSet.getString(1)+" "+
						joinRowSet.getString(2)+" "+
						joinRowSet.getString(3)+" "+
						joinRowSet.getString(4)+" "+
						joinRowSet.getString(5)+" "+
						joinRowSet.getString(6)
						);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// ich brauche nur eine Kopie von buch
	}
}
