package wbs.jdbc.annotation;

import java.util.HashMap;
import java.util.Map;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SQLUtilHandler extends DefaultHandler {
	
	private SQLConfig sConfig= new SQLConfig();
	
	public SQLConfig getSQLConfig(){
		return sConfig;
	}
	public Map<String,String> handleConnection(Attributes atr){
		Map<String, String> map= new HashMap<>();
		for(int i=0;i<atr.getLength();i++){
			map.put(atr.getQName(i), atr.getValue(i));
		}
		return map;
	} 
	public Map<String,String> handleTable(Attributes atr, Map<String,String>m){
		Map<String, String> map= new HashMap<>();
		if (m!=null){
			map=m;
		}
			map.put(atr.getValue("className"),atr.getValue("tableName"));
		return map;
	} 
	public Map<String,String> handleType(Attributes atr, Map<String,String>m){
		Map<String, String> map= new HashMap<>();
		if (m!=null){
			map=m;
		}
			map.put(atr.getValue("javaType"),atr.getValue("sqlType"));
		return map;
	} 
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		switch (qName){
		case "connection":
			sConfig.setConnection(handleConnection(attributes));
			break;
		case "tableMapping":
			sConfig.setTableMapping(handleTable(attributes,sConfig.getTableMapping()));
			break;
		case "typeMapping":
			sConfig.setTypeMapping(handleType(attributes,sConfig.getTypeMapping()));
			break;
		default:
		}	
		
	}

}