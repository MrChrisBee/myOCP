package wbs.jdbc.dao;

import java.util.List;

public class BuchDAODemo {

	/*
	 * Schwachstellen dieser Technik und die Behebung
	 * Pooling von Connections / DAOs / Komponenten
	 * DAOs klinken sich in Transaktionen ein sind aber 
	 * weder für dessen Start noch für den Commit verantwortlich 
	 */

	public static void main(String[] args) {
		IBuchDAO buchDAO = DAOFactory.getBuchDAO();

		Buch buch = new Buch();
		// setter Methoden Aufrufen
		buch.setIsbn("12345");
		buch.setTitel("Am Arsch hängt der Hammer");
		buch.setAutor("Mike Müller");
		buch.setPreis(39.95);
		buchDAO.save(buch);

		List<Buch> buecher = buchDAO.findAll();
		for (Buch b : buecher) {
			System.out.println(b);
		}
	}
}
