package wbs.jdbc.rowset;

import java.sql.SQLException;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetFactory;
import javax.sql.rowset.RowSetProvider;

/*
 * Wir nehmen an das eine Bücherei für jedes Buch aus der Tabelle Buch ein oder 
 * mehr Exemplare hat.
 * 
 */

public class JoinRowsetDemoSoNicht {

	/*
	 * Wir schreiben die Methode populateExemplar(). Sie legt für jeden record aus der Tabelle Buch 
	 * einen oder mehrere Records in der Tabelle Exemplar an.
	 * Die Exemplare eines Buches werden fortlaufend nummeriert, das Anschaffungsjahr der Exemplare kann variieren.  
	 */

	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
		String user = "root";
		String password = "";
		RowSetFactory rowSetFactory;
		CachedRowSet cachedRowSet;
		JdbcRowSet rsJDBC;
		// sql holen der Daten
		String sqlBuch = "select * from buch";
		// sql anlegen der Records
		String sqlExemplar = "insert into exemplar (ANSCHAFFUNGSJAHR, ISBN, NR) VALUES (?,?,?)";
		// ich hole mir ein RowSet für die Tabelle Buch
		try {
			//für alles eine Factory holen
			rowSetFactory = RowSetProvider.newFactory();
			// ich brauche nur eine Kopie von buch
			cachedRowSet = rowSetFactory.createCachedRowSet();
			// auf exemplar muss ich immer wieder zugreifen
			rsJDBC = rowSetFactory.createJdbcRowSet();
			// öffne buch und lese
			cachedRowSet.setUrl(url);
			cachedRowSet.setUsername(user);
			cachedRowSet.setPassword(password);
			cachedRowSet.setCommand(sqlBuch);
			cachedRowSet.execute();
			// öffne exemplar
			rsJDBC.setUrl(url);
			rsJDBC.setUsername(user);
			rsJDBC.setPassword(password);
			// prepared Statemend für exemplar erzeugen
			rsJDBC.setCommand(sqlExemplar);
			//ANSCHAFFUNGSJAHR(int), ISBN (Varchar), NR(int)
			while(cachedRowSet.next()) {
				rsJDBC.setInt(1, 1900);
				rsJDBC.setString(2, cachedRowSet.getString(1));
				rsJDBC.setInt(3, 1);
				rsJDBC.execute();
				//rsJDBC.insertRow();
				//rsJDBC.commit();
			}
			rsJDBC.close();
			cachedRowSet.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
