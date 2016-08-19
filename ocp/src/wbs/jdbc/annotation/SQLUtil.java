package wbs.jdbc.annotation;

//von Kerstin
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import wbs.jdbc.annotation.SQLUtilHandler;

public class SQLUtil {
	private SQLConfig sCon = new SQLConfig();
	private SQLUtilHandler sqlHandler = new SQLUtilHandler();

	public SQLConfig getSCon() {
		return sCon;
	}

	public SQLUtil(String pathToDescriptor) {
		String xmlFile = "resources/sql/persistence.xml";
		InputSource source = new InputSource(xmlFile);

		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setValidating(true);
		factory.setNamespaceAware(false);

		XMLReader reader = null;
		try {
			reader = factory.newSAXParser().getXMLReader();

			reader.setContentHandler(sqlHandler);
			try {
				reader.parse(source);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (SAXException | ParserConfigurationException e) {
			e.printStackTrace();
		}
		sCon = sqlHandler.getSQLConfig();

	}

	public SQLUtil() {
	}

	public String class2Table(String className, String tabelName, Map<String, String> typeMap) {
		String result = "Create table " + tabelName + "(";
		Column column;
		PrimaryKey pk;
		String pkStr = "primary key(";
		Map<Integer, String> map = new TreeMap<>();
		try {
			for (Field f : Class.forName(className).getDeclaredFields()) {
				// für das Feld alle Annotations ermitteln
				column = f.getAnnotation(Column.class);
				if (column != null) {
					// Annotation column dabei?
					String s = typeMap.get(f.getType().getSimpleName());

					if (column.length().equals("")) {
						switch (s) {
						case "varchar":
							s = s + "(255)";
							break;
						case "dezimal":
							s = s + "(8,2)";
						}

					} else
						s = s + "(" + column.length() + ")";
					result = result + f.getName() + " " + s + ",";
				}

				pk = f.getAnnotation(PrimaryKey.class);

				if (pk != null) {
					map.put(pk.index(), f.getName());
				}

			}

		} catch (SecurityException | ClassNotFoundException e) {
			System.out.println(e);
			;
		}
		for (Integer entry : map.keySet()) {
			pkStr += (map.get(entry));
			if (entry != ((TreeMap<Integer, String>) map).lastKey()) {
				pkStr += ",";
			}
		}

		result += pkStr + "))";
		return result;

	}

	public void createTables() {
		try (Connection conn = DriverManager.getConnection(sCon.getConnection().get("url"),
				sCon.getConnection().get("user"), sCon.getConnection().get("password"))) {
			try (Statement st = conn.createStatement()) {
				for (Entry<?, ?> e : sCon.getTableMapping().entrySet()) {
					st.execute(class2Table((String) e.getKey(), (String) e.getValue(), sCon.getTypeMapping()));
				}
			} catch (SQLException e) {
				System.out.println("Fehler beim Anlegen Tabelle!");
				e.printStackTrace();
			}
		} catch (SQLException e) {
			System.out.println("Fehler beim Verbindungsaufbau!");
			e.printStackTrace();
		}
 
	}

}
