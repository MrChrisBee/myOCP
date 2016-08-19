package wbs.localization;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/*
 * Wir geben das aktuelle Datum in jeweils 4 verschiedenen Varianten aus:
 * SHORT, MEDIUM, LONG, FULL
 * 
 * das machen wir für verschiedene Locales (die Referenzen holen wir uns über Konstanten oder Konstruktoren der Klasse Locale)
 */
public class Locale1Demo {
	public static void main(String[] args) {
		Date d = new Date();
		Locale[] locales = { Locale.FRENCH , Locale.US, Locale.UK, new Locale("de"), new Locale("pt","BR")};
		DateFormat df;
		for(Locale locale : locales) {
			System.out.println(locale.getDisplayLanguage());
			System.out.println("++++++++++++++++++");
			df = DateFormat.getDateInstance(DateFormat.SHORT, locale);
			System.out.println(df.format(d));
			df = DateFormat.getDateInstance(DateFormat.MEDIUM, locale);
			System.out.println(df.format(d));
			df = DateFormat.getDateInstance(DateFormat.LONG, locale);
			System.out.println(df.format(d));
			df = DateFormat.getDateInstance(DateFormat.FULL, locale);
			System.out.println(df.format(d));
			System.out.println();
		}
	}

}
