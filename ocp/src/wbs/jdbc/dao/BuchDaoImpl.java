package wbs.jdbc.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BuchDaoImpl implements IBuchDAO {

	String url = "jdbc:mysql://127.0.0.1:3306/jdbc?useUnicode=yes&characterEncoding=UTF-8";
	String user = "root";
	String password = "";
	String file4Save = "resources/sql/insertBooks.sql";
	String sqlSave;
	String sqlFindAll = "select * from buch where 1";
	Statement stmt = null;

	@Override
	public void save(Buch buch) throws PersistenceException {
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			try {
				sqlSave = new String(Files.readAllBytes(Paths.get(file4Save)));
			} catch (IOException e1) {
				throw new PersistenceException("Konnte das SQL nicht einlesen !");
			}
			PreparedStatement pstmt = conn.prepareStatement(sqlSave);
			pstmt.setString(1, buch.getIsbn());
			pstmt.setString(2, buch.getTitel());
			pstmt.setString(3, buch.getAutor());
			pstmt.setDouble(4, buch.getPreis());

			pstmt.execute();

		} catch (Exception e) {
			throw new PersistenceException("Fehler beim speicher ...");
		}
	}

	@Override
	public List<Buch> findAll() throws PersistenceException {
		List<Buch> buecher = new ArrayList<>();
		Buch tmpBook;
		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sqlFindAll);
			while (rs.next()) {
				tmpBook = new Buch();
				tmpBook.setIsbn(rs.getString("ISBN"));
				tmpBook.setTitel(rs.getString("TITEL"));
				tmpBook.setAutor(rs.getString("AUTOR"));
				tmpBook.setPreis(rs.getDouble("PREIS"));
				buecher.add(tmpBook);
			}
		} catch (Exception e) {
			throw new PersistenceException("Fehler beim Laden ...");
		}
		return buecher;
	}

}
