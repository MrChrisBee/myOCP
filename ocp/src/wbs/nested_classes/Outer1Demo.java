package wbs.nested_classes;

public class Outer1Demo {

	public static void main(String[] args) {
		/*
		 * wir erzeugen eine instanz der klasse Outer1 und zwei
		 * mit dieser instanz verbundene instanzen der klasse Inner1
		 * und geben die string-repräsentation der beiden instanzen
		 * der inneren klasse aus.
		 */
		
		Outer1 outer1 = new Outer1();
		
		Outer1.Inner1 inner11 = outer1.new Inner1();
		Outer1.Inner1 inner12 = outer1.new Inner1();
		
		System.out.println(inner11);
		System.out.println(inner12);
	}

}
