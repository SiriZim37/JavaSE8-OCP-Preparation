package aufgaben.geometrie.v3.polymophie;

import java.util.Random;

public class PolymophieGeomatrie {

	public static void main(String[] args) {
	
		
		Rechteck r1 = new Rechteck(5,-5);
		System.out.println(r1);
		
		Kreise k1 = new Kreise(15);
		System.out.println(k1);
		
		//Aufruf der Instanz-methoden : early binding (Entscheidung zur Laufzeit)

		System.out.println(r1.getFlaeche());
		System.out.println(k1.getFlaeche());
		
		
		System.out.println("\n----- RANDOM 100 ---\n");
		Figur[] arrFigur = new Figur[100];
		int min = -100;
		int max = 100;
		
		Random rnd = new Random();
		for(int i = 0 ; i < arrFigur.length ; i++) {
			int x =  rnd.nextInt(max-min+1)+min;
			int y =  rnd.nextInt(max-min+1)+min;
			if(rnd.nextBoolean()) {
				arrFigur[i] = new Rechteck( rnd.nextInt(max-min+1)+min,
											rnd.nextInt(max-min+1)+min, x,y );
			}else {
				arrFigur[i] = new Kreise( rnd.nextInt(max-min+1)+min,x,y );	
			}
		}
		
		
		printgetFlaecheArray(arrFigur);

	}
	

	static void printgetFlaecheArray(Figur[] param) {
		 for (Figur figur : param) {
			 System.out.println(String.format("%s\tFläche = %.3f", figur.toString() , figur.getFlaeche()));	
		 }
	}
	
	/*
	 * 
	 * Lösunf ohne Polymorphisum. Bitte so nicht programmieren.
	 * 
	 */
//	static void computerAndPrintOhnePolymorphisum(Object[] array) {
//		
//		for(int i = 0 ; i< array.lenght ; i++) {
//			if(obj instanceof Kreis) {
//				Kreise k = (Kreis)obj;
//				System.out.println("Fläche:" + k.getFlaeche());
//			}else if(obj instanceof Rechteck) {
//				Rechteck r = (Rechteck)obj;
//				System.out.println(" Fläsche: " + r.getFlaeche());
//			}
//			// wenn weitere Figuren-Typen definiert werden ,
//			// müssen hier weitere Zweige hinzufügte werden.
//			
//		}
//	}

}
