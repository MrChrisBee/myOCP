package wbs.localization;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class RollDemo {

	public static void main(String[] args) {
		Locale[] ausgewaehlteLocales = { Locale.GERMAN, Locale.ENGLISH, Locale.FRANCE };
		GregorianCalendar cal1 = new GregorianCalendar(); 
		// ^^^ ohne Parameter -> das aktuelle Datum
		SimpleDateFormat simpel = new SimpleDateFormat("EEEE' der 'dd.MM.yy", ausgewaehlteLocales[0]);
		System.out.println("Heute ist der : " + simpel.format(cal1.getTime()));
		System.out.println("Ergibt wenn ich nur den Tag des Monats um 30 weiter rechne (cal1.roll(Calendar.DAY_OF_MONTH, 30);)");
		cal1.roll(Calendar.DAY_OF_MONTH, 30);
		for (Locale local : ausgewaehlteLocales) {
			simpel = new SimpleDateFormat("EEEE dd.MM.yyyy", local);
			System.out.println(simpel.format(cal1.getTime()));
		}
	}

}
