package test1;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

interface Geld {
    int getWert();

    static boolean isValid(double amount, Geld[] geldArray) {
        int amountInCents = (int) Math.round(amount * 100);
        for (Geld geld : geldArray) {
            if (geld.getWert() == amountInCents) {
                return true;
            }
        }
        return false;
    }
}

enum Tarif{
	K(1.40) , A(2.30) , B(4.70) ,C(9.60) , D(11.40) ;

	double preis ;
	Tarif(double preis) {
		this.preis = preis;
	}

	public double getPreis() {
	      return preis;
	}
	
	@Override
	public String toString() {
		return  String.format("%s : %.2f €", this.name(), getPreis()); 
	}
}

enum Muenze implements Geld{
	ZEHN_CENT(10), ZWANZIG_CENT(20),FUENFZIG_CENT(50), EINS_EURO(100),  ZWEI_EURO(200);


	int wert;
	Muenze(int wert) {
		this.wert = wert;
	}
	
	public int getWert() {
		return wert;
	}
	
	public static boolean isValid(double amount) {
        return Geld.isValid(amount, Muenze.values());
    }
	
	public static Muenze[] getValuesSort() {
	    Muenze[] muenzen = Muenze.values();
	    Arrays.sort(muenzen, Comparator.naturalOrder());
	    Arrays.sort(muenzen, Comparator.reverseOrder());
	    return muenzen;
	}

}


enum Schein implements Geld {
	
    FÜNF_EURO(500), ZEHN_EURO(1000), ZWANZIG_EURO(2000);
   
	private int wert;
    Schein(int wert) {
        this.wert = wert;
    }

    public int getWert() {
        return wert;
    }

    public static boolean isValid(double amount) {
        return Geld.isValid(amount, Schein.values());
    }
}

public class Fahrscheinautomaten {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);

		 // Select Tarif
        Tarif selectedTarif = selectTarif(sc);

        // Process payment
        double einWurfGeld = zahlungsVorgang(sc, selectedTarif);
        
        // return change 
        double diff = einWurfGeld - selectedTarif.getPreis();
        
        System.out.printf("Zahlen %.2f € \n", einWurfGeld);
	 	System.out.println("Vielen Dank für Ihre Bazahlung.");
	 	System.out.printf("Sie bekommen %.2f € zurück.\n", diff);
	   
		
		zuruckGeld(diff);

		System.out.println("Vielen Dank");
		sc.close();

	}

	static void zuruckGeld(double diff) {
		 int rest = (int) Math.round(diff * 100);
	        for (Muenze muenze : Muenze.getValuesSort()) {
	            while (rest >= muenze.getWert()) {
	            	rest -= muenze.getWert();
	                System.out.printf("%.2f €\n", muenze.getWert() / 100.0);
	            }
	        }
    }
	

	 private static double zahlungsVorgang(Scanner sc, Tarif selectedTarif) {
		 double gesamt = 0.0;
		 double requiredAmount = selectedTarif.getPreis();

		    while (gesamt < requiredAmount) {
		        System.out.printf("Bitte zahlen Sie %.2f €.\n", requiredAmount - gesamt);
		        System.out.print("Eingabe: ");
		        try {
		            double eingabe = Double.parseDouble(sc.nextLine());

		            if (eingabe <= 0) {
		                System.out.println("Der Betrag muss positiv sein.");
		            } else if (eingabe > 20) {
		                System.out.println("Bitte werfen Sie nur Scheine bis zu 20 € oder gültige Münzen ein.");
		            } else if (Schein.isValid(eingabe) || Muenze.isValid(eingabe)) {
		            	gesamt += eingabe;
		            } else {
		                System.out.println("Ungültiges Geld. Bitte geben Sie gültige Scheine oder Münzen ein.");
		            }
		        } catch (NumberFormatException e) {
		            System.out.println("Ungültige Eingabe. Bitte geben Sie einen gültigen Betrag ein.");
		        }
		    }

		    return gesamt;
	}
	 
	private static Tarif selectTarif(Scanner sc) {
	     	Tarif selectedTarif = null;
	     	boolean isValidZone = false;
			String stufe = "";
			while (!isValidZone) {
				
				System.out.println("Bitte wählen Sie wie folgt eine Tarifzone");
				// TarifZone
				for(Tarif t : Tarif.values()) {
					System.out.println(t);
				}
				try {
					stufe = sc.nextLine();
					selectedTarif = Tarif.valueOf(stufe.toUpperCase());			
					isValidZone = true;
				} catch (IllegalArgumentException e) {
					System.out.println("Ungültige Eingabe. Bitte wählen Sie eine Tarifzone");
				}
			}
			System.out.println("Sie haben Preisstufe " + stufe + " gewählt");
			
	    return selectedTarif;
	}
	

	
}
