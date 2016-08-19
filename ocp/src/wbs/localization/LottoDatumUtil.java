package wbs.localization;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class LottoDatumUtil {
	/*
	 * Wir schreiben eine Methode ersterZiehungsTag() die den Tag berechnet an dem ein
	 * eingereichter Lottoschein zum ersten mal an einer Ziehung teilnimmt 
	 */
	//abgabeSchlussMittwoch 18 (Uhr)
	//abgabeschlussSammstag 19 (Uhr)
	static int bisMittwoch(GregorianCalendar gregorAgabeDatum) {
		int result = Calendar.WEDNESDAY - gregorAgabeDatum.get(Calendar.DAY_OF_WEEK);
		if(result < 0) {
			result = 7 -(result * -1);
		}
		return result;
	}
	 
	static int bisSamstag(GregorianCalendar gregorAgabeDatum) {
		int result = Calendar.SATURDAY - gregorAgabeDatum.get(Calendar.DAY_OF_WEEK);
		if(result < 0) {
			result = 7 -(result * -1);
		}
		return result;
	}
	
	public static Date ersterZiehungstag(Date abgabeDatum, boolean isMittwoch, boolean isSamstag,
			int abgabeSchlussMittwoch, int abgabeSchlussSammstag) {
	
		GregorianCalendar gcal = new GregorianCalendar();
		gcal.setTime(abgabeDatum);
		System.out.println("Erster Wochentag ist :" + gcal.getFirstDayOfWeek());
		System.out.println("Der Montag ist definiert mit :" +Calendar.MONDAY);
		System.out.println("Heute ist : " +gcal.get(Calendar.DAY_OF_WEEK));
		System.out.println("Der Mittwoch ist definiert mit :" +Calendar.WEDNESDAY);
		System.out.println("Errechnete Differenz bis Mittwoch ist :" + bisMittwoch(gcal));
		
		return new Date();
	}

}
