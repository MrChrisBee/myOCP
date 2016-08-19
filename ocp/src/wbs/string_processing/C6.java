package wbs.string_processing;

public class C6 {
	public static void main(String[] args) {
		System.out.printf("%d%n", 1);
		System.out.printf("%f%n", 1.0f);
		System.out.printf("%f%n", 2.0);
		System.out.printf("%b%n", new Object());
	//	System.out.printf(" %b%n", null);		//Zeile 5
		System.out.printf("%b%n", "FaLSe");		//false ist ein boolean "irgendetwas sogar FaLSe" ist ein String und der   
		System.out.printf("%b%n", 0);			//ist bei einer %b Ausgabe, wie alles außer false und null, true 
		System.out.printf("%b%n", "");
		System.out.printf("%b%n", false);
	//	System.out.printf("%s%n", null);		
	}
}