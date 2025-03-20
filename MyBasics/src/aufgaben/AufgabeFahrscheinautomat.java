package aufgaben;

import java.text.NumberFormat;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class AufgabeFahrscheinautomat {

	public static void main(String[] args) {
		while(true) {
			System.out.println("*****************************");
			System.out.println("Bitte wählen Sie eine Preisstufe aus. (K, A, B, C oder D)");
			Scanner sc = new Scanner(System.in);
			String preisstufe = sc.next();
			double fahrpreis;
			switch(preisstufe) {
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
					System.out.println("Bitte geben Sie eine gültige Preisstufe ein.  (K, A, B, C oder D)");
					fahrpreis = 0;
					continue;
					
			}
			// System.out.println("Sie haben die Preisstufe " + preisstufe + " gewählt. Bitte zahlen den Fahrpreis von " + String.format("%.2f", fahrpreis) + " €.");
			NumberFormat nf = NumberFormat.getCurrencyInstance();
			System.out.println("Sie haben die Preisstufe " + preisstufe + " gewählt. Bitte zahlen den Fahrpreis von " + nf.format(fahrpreis));
			double restgeld = fahrpreis;
			double einwurf;
			Double[] muenzen = {0.1, 0.2, 0.5, 1., 2.};
			Double[] scheine = {5., 10., 20.};
			while (true) {
				do {
					einwurf = sc.nextDouble();
				} while (Arrays.binarySearch(muenzen, einwurf) < 0 && Arrays.binarySearch(scheine, einwurf) < 0);
				restgeld -= einwurf;
				if (restgeld <= 0.01) {
					System.out.println("Vielen Dank für Ihre Zahlung.");
					break;
				} else {
					System.out.println("Noch zu zahlen: " + nf.format(restgeld));
				}
			} 
			
			if (restgeld < -0.01) {
				restgeld = restgeld * -1;
				restgeld = -restgeld;
				restgeld = Math.abs(restgeld);
				System.out.println("Sie bekommen " + nf.format(restgeld) + " zurück.");
			}
			
			Arrays.sort(muenzen,Comparator.reverseOrder());
			
			while (restgeld > 0.01) {
				for (double muenze : muenzen) {
					if (restgeld + 0.01 >= muenze) {
						System.out.println(nf.format(muenze));
						restgeld -= muenze;
						break;
					}
				}			
			}
			System.out.println("Servus und Gute Fahrt!");
			
		}
	}
}

