package wbs.string_processing;

public class C8 {
	public static void main(String[] args) {
		int n = 100;
		double x = Math.PI;
		System.out.printf(">%1$(7d< %n", n); 
		// ( sollte nur auf negative Argumente Einfluss haben >    100<
		System.out.printf(">%0,7d< %n", n); // >0000100<
		System.out.printf(">%+-7d< %n", n); 
		// >100    < "-" zeigt das Vorzeichen immer also >+100   <
		System.out.printf(">%2$b + %1$5d< %n", n, false); 
		// >false + 100<  mist %1$5d gilt nur für den 2. Teil also >false +   100<  
		System.out.printf(">%s + %S< %n", n + 1, "test");// >101 + TEST<
		System.out.printf("%e%n", x);		//3,1415e0
		System.out.printf("%f%n", x);		//3,141592
		System.out.printf("%8.4f%n", x);	//  3,1415
		System.out.printf("%-8.4f%n", x);	//3,1415  
		System.out.printf("%08.4f%n", x);	//003,1415
	}
}