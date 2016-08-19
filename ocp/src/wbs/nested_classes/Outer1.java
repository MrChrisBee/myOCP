package wbs.nested_classes;

public class Outer1 {
	
	private int n = 11;
	
	// member-klasse (inner class)
	class Inner1 {
		
		private int n = 12;

		// eine instanz einer member-klasse kann auf alle member der äusseren
		// klasse zugreifen, auch dann, wenn sie private sind
		
		// Outer1.this ist eine referenz auf die instanz der äusseren klasse,
		// mit der die instanz der inneren klasse verbunden ist
		@Override
		public String toString() {
			return getClass().getName() + "," + n + "," + Outer1.this.n;
		}
		
	}
	
	public Inner1 m1() {
		return new Inner1();
	}
	
	// m2() liefert einen compiler-fehler, weil statische methoden
	// keinen objekt-bezug haben, eine instanz einer memberklasse aber
	// immer mit einer instanz der äusseren klasse verbunden sein muss.
	
//	public static Inner1 m2() {
//		return new Inner1();
//	}
}
