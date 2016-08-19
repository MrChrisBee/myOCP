package wbs.jdbc.annotation;

import java.util.HashMap;
import java.util.Map;

public class SQLUtilConfig {
	
	private Map<String , String> connection = new HashMap<String, String>();
	private Map<String , String> tableMapping = new HashMap<String, String>();
	private Map<String , String> typeMapping = new HashMap<String, String>();
	
	public Map<String, String> getConnection() {
		return connection;
	} 
	
	public void setConnection(Map<String, String> connection) {
		this.connection = connection;
	}
	
	public Map<String, String> getTableMapping() {
		return tableMapping;
	}
	
	public void setTableMapping(Map<String, String> tableMapping) {
		this.tableMapping = tableMapping;
	}
	
	public Map<String, String> getTypeMapping() {
		return typeMapping;
	}
	
	public void setTypeMapping(Map<String, String> typeMapping) {
		this.typeMapping = typeMapping;
	}

	public void setDriver(String value) {
		System.out.println(value);
		connection.put("driver", value);
	}
	public void setUrl(String value) {
		connection.put("url", value);
		System.out.println(value);
	}
	public void setUser(String value) {
		connection.put("user", value);
		System.out.println(value);
	}
	public void setPassword(String value) {
		connection.put("passwort", value);
		System.out.println(value);
	}
	
}
