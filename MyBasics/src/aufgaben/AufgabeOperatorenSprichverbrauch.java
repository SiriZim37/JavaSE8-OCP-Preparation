package aufgaben;


import java.util.Scanner;

public class AufgabeOperatorenSprichverbrauch {
	

	/*
	  
	# Aufgabe 'Operatoren - Spriverbrauch'

	Am Montag hat Ute ihr Auto vollgetankt und den Tageskilometer-Zähler auf Null gesetzt.
	Am Freitag musste Ute wieder volltanken, es wurden 31 Liter. Vor dem erneuten Volltanken zeigte Tageskilometer-Zähler 780 Kilometer.
	Berechnen Sie den Spritverbrauch (wie viele Liter pro 100 Kilometer das Auto verbraucht) und geben Sie das Ergebnis aus.
	
	 */
	
	
	public static void main(String[] args) {
		v5();
		v4();
		v3();
		v2();
		v1();
		inpuData();
		
	}
		
	
	static void v5() {
		System.out.println("\n\n*** v5 ****");
		
		int literUsed =  31;
		int distanz =  780;  
		double verbrauchPer100KM =  100.0  * literUsed / distanz   ;  
		
		System.out.println("Volltanken = " + literUsed + " Liter" );
		System.out.println("Tageskilometer-Zähler = " + distanz + " Kilometer");
		System.out.printf("Spritverbrauch ist  %.2f Liter pro 100 Kilometer das Auto verbraucht" , verbrauchPer100KM  );	
	}
	
	static void v4() {
		System.out.println("\n\n*** v4 ****");
		
		int literUsed =  31;
		int distanz =  780;  
		double verbrauchPer100KM =  100.0  * literUsed / distanz   ;  
		
		String verbraucAlsText = String.format("%.2f",verbrauchPer100KM);	
		System.out.println("Volltanken = " + literUsed + " Liter" );
		System.out.println("Tageskilometer-Zähler = " + distanz + " Kilometer");
		System.out.printf("Verbrauch : " + verbraucAlsText   );	
	}
	

	static void v3() {
		System.out.println("\n\n*** v3 ****");		
		int literUsed =  31;
		int distanz =  780;  
		double verbrauchPer100KM =  100.0  * literUsed / distanz   ;  // ( Compiler wird wissen , dass double ist. )
		System.out.println("Volltanken = " + literUsed + " Liter" );
		System.out.println("Tageskilometer-Zähler = " + distanz + " Kilometer");
		System.out.printf("Spritverbrauch ist " + verbrauchPer100KM  + " Liter pro 100 Kilometer das Auto verbraucht");						
	}
		
	static void v2() {
		System.out.println("\n\n*** v2 ****");
		
		int literUsed =  31;
		int distanz =  780;  
		double verbrauchPer100KM = (double)literUsed / distanz  * 100  ; 			
		System.out.println("Volltanken = " + literUsed + " Liter" );
		System.out.println("Tageskilometer-Zähler = " + distanz + " Kilometer");
		System.out.printf("Spritverbrauch ist " + verbrauchPer100KM  + " Liter pro 100 Kilometer das Auto verbraucht");	
			
	}
	
	
	static void v1() {
		System.out.println("\n\n*** v1 ****");
		
		int literUsed =  31;
		double distanz =  780;  
		double verbrauchPer100KM = literUsed / distanz  * 100  ; 
	
		// When int durch int wird 32 bit mit 0 in CPU deswegen wird komische Ergebnis sehen. 
		// Sonst hat das Ergebnis den Typ des 'breitesten' Operatoren. (มิฉะนั้นผลลัพธ์จะเป็นประเภทของตัวดำเนินการที่ 'กว้างที่สุด')
			
		System.out.println("Volltanken = " + literUsed + " Liter" );
		System.out.println("Tageskilometer-Zähler = " + distanz + " Kilometer");
		System.out.printf("Spritverbrauch ist  %.2f Liter pro 100 Kilometer das Auto verbraucht" , verbrauchPer100KM  );	
			
	}
	
	static void inpuData() {
		System.out.println("\n\n*** inpuData ****");
		/*
		 *  console input data
		 */
			
		Scanner scanner = new Scanner(System.in);		
	    System.out.print("\n\nGeben Sie den Literverbrauch ein: ");
	    String sLiterUsed = scanner.next();
	    System.out.print("Geben Sie Tageskilometer-Zähler ein.: ");
	    String sDistance = scanner.next();
	    System.out.print("Geben Sie Kilometer pro Liter ein: ");
	    String sVerbrauchKM = scanner.next();
	       
	    double iLiterUsed =  Double.valueOf(sLiterUsed);
	    double iDistanz = Double.valueOf(sDistance); ;
	    double iVerbrauchKM=  Double.valueOf(sVerbrauchKM);  ;
	    double oResult = ( iLiterUsed / iDistanz ) * iVerbrauchKM ;
	    System.out.printf("Spritverbrauch ist %.2f Liter pro %.0f Kilometer das Auto verbraucht " , oResult , iVerbrauchKM );

	    scanner.close();
			
	}
		

}
