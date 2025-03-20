package aufgaben.geometrie.v4.interfaces;

import java.util.Random;

public class TestGeometrie {

	public static void main(String[] args) {
		Random random = new Random() ;
			
		int anzahl = 100 ;
		Figur[] arrFlaeche = new Figur[anzahl];
		for (int i = 0 ; i < anzahl  ; i++) {
			if(random.nextBoolean()) {
				 double val1 = (random.nextBoolean() ? 1 : -1) * (random.nextDouble() * 10);
				 double val2 = (random.nextBoolean() ? 1 : -1) * (random.nextDouble() * 10);
				arrFlaeche[i] = new Rechteck( val1 , val2);
			}else {
				 double val = (random.nextBoolean() ? 1 : -1) * (random.nextDouble() * 10);
				arrFlaeche[i] = new Kreis(val);
			}		
		}	
		printFlaecheArray(arrFlaeche);
		
		
		
	}
	
	static void printFlaecheArray(Figur[] arrFigur) {
		int i = 1 ; 
		for(Figur figur : arrFigur) {
			System.out.println(String.format("%d. %s Fläche = %.3f", i++, figur.toString() , figur.getFlaeche()));
		}	
	
		
	}
}
