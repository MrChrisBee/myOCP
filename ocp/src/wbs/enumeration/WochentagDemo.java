package wbs.enumeration;

enum Wochentag {
	// nach der letzten enum-konstanten kann auch ein semikolon stehen.
	// zuweisungen von initialen werten sind nicht erlaubt:
	// MO = 1 geht n i c h t!
	MO, DI, MI, DO, FR, SA, SO
}

public class WochentagDemo {

	public static void m(Wochentag tag) {
		switch (tag) {
		// case Wochentag.MO: compilerfehler!
		case MO:
		case DI:
		case MI:
		case DO:
		case FR:
			// do some stuff
			break;
		case SA:
			// do some stuff
			break;
		case SO:
			// do some stuff
			break;
		default:
			// strange!
			// hier könnte auch ein AssertionError geworfen werden...
			break;
		}
	}

	public static void main(String[] args) {
		Wochentag[] values = Wochentag.values();
		// konstanten eines enum sind vom typ des enum (oder eine subklasse
		// dieses typs)
		for (Wochentag tag : values) {
			System.out.println(tag.name() + " " + tag.ordinal() + " -> "
					+ tag.getClass().getName());
		}
	}

}
