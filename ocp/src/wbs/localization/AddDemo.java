package wbs.localization;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/*
 * Wir geben den vollen Namen des Wochentags aus, den wir in 100 Tagen haben werden,
 * und das machen wir in verschiedenen Sprachen 
 */
public class AddDemo {

	public static void main(String[] args) {
		Locale[] ausgewaehlteLocales = { Locale.GERMAN, Locale.ENGLISH, Locale.FRANCE };
		GregorianCalendar cal1 = new GregorianCalendar(); 
		// ^^^ ohne Parameter -> das aktuelle Datum
		SimpleDateFormat simpel = new SimpleDateFormat("EEEE' der 'dd.MM.yy", ausgewaehlteLocales[0]);
		System.out.println("Heute ist der : " + simpel.format(cal1.getTime()));
		System.out.println("in 100 Tagen ist ");
		cal1.add(Calendar.DAY_OF_MONTH, 100);
		for (Locale local : ausgewaehlteLocales) {
			simpel = new SimpleDateFormat("EEEE", local);
			System.out.println(simpel.format(cal1.getTime()));
		}
	}

}
