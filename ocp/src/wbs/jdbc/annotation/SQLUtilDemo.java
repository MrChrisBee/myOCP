package wbs.jdbc.annotation;

import java.util.HashMap;
import java.util.Map;

public class SQLUtilDemo {

	public static void main(String[] args) throws Exception {
		
		SQLUtilCB sqlUtil = new SQLUtilCB();
				
		Map<String, String> tableMappings = new HashMap<String, String>();
		Map<String, String> typeMappings = new HashMap<String, String>();
		
		String sql;
		// bildet Klassennamen auf Tabellennamen ab
		tableMappings.put("wbs.jdbc.dao.Buch", "Buch");
		
		typeMappings.put("int", "integer");
		typeMappings.put("String", "varchar(255)");
		typeMappings.put("double", "decimal(8,2)");
				
		// generiert wird ein createTable Statement 
		// übergeben wird:
		// - der Bezeichner der Klasse, zu der das Statement generiert wird
		// - eine map, die Klassennamen auf Tabellen abbildet
		sql = sqlUtil.class2Table("wbs.jdbc.dao.Buch", tableMappings, typeMappings);
		
		System.out.println(sql);
	}
}
