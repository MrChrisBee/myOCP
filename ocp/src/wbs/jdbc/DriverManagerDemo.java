package wbs.jdbc;

import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;

public class DriverManagerDemo {
/*
 * Wir ermitteln welche Treiber dem DriverManager bekannt sind,
 * und geben für jeden dieser Treiber den voll Qualifizierten 
 * Klassennamen aus.
 */
	public static void main(String[] args) {
		Enumeration<Driver> allDriver = DriverManager.getDrivers();
		Driver driver;
		while(allDriver.hasMoreElements()) {
			driver = allDriver.nextElement();
			System.out.println(driver.getClass().getName());
		}
	}
}
