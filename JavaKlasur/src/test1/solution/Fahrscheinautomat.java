package test1.solution;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Fahrscheinautomat {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		System.out.println("Bitte wählen Sie wie folgt eine Tarifzone aus. ( K, A, B, C oder D)");

		String preisStufe = sc.next();
		double fahrpreis;
		switch (preisStufe) {
			case "K":
				fahrpreis = 1.4;
				break;
			case "A":
				fahrpreis = 2.3;
				break;
			case "B":
				fahrpreis = 4.7;
				break;
			case "C":
				fahrpreis = 9.6;
				break;
			case "D":
				fahrpreis = 11.4;
				break;
			default:
				System.out.println("Bitte geben Sie eine gültige Preistufe ein. ( K, A, B, C oder D)");
				fahrpreis = 0 ;
				break;
		}
		
//		System.out.println("Sie haben Preisstufe " + preisStufe + " gewählt. Bitte zahlen den Fahrpreis von " + String.format("%.2f", fahrpreis)  + "€");
		
		NumberFormat nf = NumberFormat.getCurrencyInstance();
		System.out.println("Sie haben Preisstufe " + preisStufe + " gewählt. Bitte zahlen den Fahrpreis von " 
											+ NumberFormat.getCurrencyInstance().format(fahrpreis));
		
	
		
		double restgeld = fahrpreis;
		double einwurf;
		Double[] muenzen = { 0.1 , 0.2, 0.5, 1.0 , 2.0 };
		Double[] scheine = { 5. ,10. , 20.};
		while(true) {
			do {
				einwurf = sc.nextDouble();
			}while(Arrays.binarySearch(muenzen , einwurf)  <  0 && Arrays.binarySearch(scheine  , einwurf) < 0);
			
			restgeld -= einwurf;
			if(restgeld <= 0.01) {
				System.out.println("Vielen Dank für Ihre Zahlung");
				break;
			}else {
				System.out.println("Noch zu zahlen : " + nf.format(restgeld));
			}
		}
		
		if( restgeld < -0.01 ) { // set 0.01 weil problem mit double
			restgeld = restgeld * -1;
			restgeld = -restgeld;
			restgeld = Math.abs(restgeld);
			System.out.println("Sie bekommem  " + nf.format(restgeld) + "zurück");
		}
		
		Arrays.sort(muenzen,Comparator.reverseOrder());
		while (restgeld >  0.01) {
			 for (double mueze : muenzen) {
		            while (restgeld+0.01 >= mueze) {
		                restgeld -= mueze;
		                System.out.printf("%.2f €\n", mueze); 
		            }
		    }
		}
		
		
//	        for (Muenze muenze : Muenze.getValuesSort()) {
//	            int mCent = muenze.getMuenze();
//	            while (rest >= mCent) {
//	                rest -= mCent;
//	                System.out.printf("%.2f €\n", mCent / 100.0); 
//	            }
//	        }
	        
			
		
		
		sc.close();
		
	}

}
