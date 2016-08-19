package wbs.jdbc.annotation;
//von Kerstin
import java.util.Map;

public class SQLConfig {
	private Map<String, String> connection;
	private Map<String, String> tableMapping;
	private Map<String, String> typeMapping;
	
	public Map<String, String> getConnection() {
		return connection;
	}
	public Map<String, String> getTableMapping() {
		return tableMapping;
	}
	public Map<String, String> getTypeMapping() {
		return typeMapping;
	}
	public void setConnection(Map<String, String> connection) {
		this.connection = connection;
	}
	public void setTableMapping(Map<String, String> tableMapping) {
		this.tableMapping = tableMapping;
	}
	public void setTypeMapping(Map<String, String> typeMapping) {
		this.typeMapping = typeMapping;
	}
	
	

}
