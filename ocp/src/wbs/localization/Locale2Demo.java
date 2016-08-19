package wbs.localization;

import java.util.Locale;

/*
 * Wir geben für alle verfügbaren Locales die Sprache aus,
 * und zwar in deutsch, englisch, französisch, chinesisch und japanisch
 * 
 * -> getAviableLocales()
 * -> getDisplayLanguage()
 */
public class Locale2Demo {

	public static void main(String[] args) {
		Locale[] verfuegbareLocales = Locale.getAvailableLocales();
		Locale[] ausgewaehlteLocales = {Locale.GERMAN,Locale.ENGLISH, Locale.FRANCE, Locale.CHINESE,Locale.JAPANESE};
		String temp = ""; 
		for(Locale localeAusgewaehlt : ausgewaehlteLocales) {
			//System.out.println("++++++++++++++++++");
			//System.out.println(localeAusgewaehlt);
			//System.out.println("++++++++++++++++++");
			temp = localeAusgewaehlt.toString();
			for (Locale localesVerfuegbar :verfuegbareLocales) {
				//System.out.println(localesVerfuegbar.getDisplayLanguage(localeAusgewaehlt));
				temp += " " + localesVerfuegbar.getDisplayLanguage(localeAusgewaehlt).toString();
			}
			System.out.println(temp);
		}
	}

}
