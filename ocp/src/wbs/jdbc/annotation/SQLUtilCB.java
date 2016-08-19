package wbs.jdbc.annotation;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;


public class SQLUtilCB {

	// liefert ein table-create Statement für className
	public String class2Table(String className, Map<String, String> tableMappings, Map<String, String> typeMappings) {
		Column column;
		PrimaryKey primaryKey;

		String dstTable = tableMappings.get(className);
		StringBuffer result = new StringBuffer("create table " + dstTable + " ( ");
		StringBuffer primaKey = new StringBuffer("primary key(");
		Field[] fields = null;
		NavigableMap<Integer, String> primary = new TreeMap<Integer, String>();
		try {
			fields = Class.forName(className).getDeclaredFields();
		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		for (Field field : fields) {
			column = field.getAnnotation(Column.class);
			if (column != null) {
				result.append(field.getName() + " " + typeMappings.get(field.getType().getSimpleName()) + ", ");
				primaryKey = field.getAnnotation(PrimaryKey.class);
				if (primaryKey != null) {
					// Achtung index Pos beachten, noch einfach
					primary.put(primaryKey.index(), field.getName());
				}
			}
		}
		for (int i = 1; i <= primary.size(); i++) {
			primaKey.append(primary.get(i));
			if (i < primary.size()) {
				primaKey.append(",");
			} else
				primaKey.append("))");
		}
		result.append(primaKey);
		return result.toString();
	}
}
