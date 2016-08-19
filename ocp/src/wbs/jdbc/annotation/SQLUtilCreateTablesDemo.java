package wbs.jdbc.annotation;


public class SQLUtilCreateTablesDemo {

	public static void main(String[] args) throws Exception {

		String pathToDescriptor = "resources/sql/persistence.xml";

		SQLUtil sqlUtil = new SQLUtil(pathToDescriptor);

		/*
		 * erzeugt alle Tabellen,
		 * für die es in persistence.xml einen Eintrag gibt
		 */

		sqlUtil.createTables();
	}
}
