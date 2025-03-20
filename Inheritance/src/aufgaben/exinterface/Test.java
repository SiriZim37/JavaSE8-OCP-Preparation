package aufgaben.exinterface;

import java.util.Random;

/* Aufgabe : 
 * 1. Implementieren Sie die Methode kleinstensElement der KLasse NuetzlicheFunktionen
 * 
 * 2. Leiten Sie von der Klasse Integer eine Klasse VInteger ab, die das Interface 
 *    vergeichbar implimentiert
 *    
 * 3. Schreiben Sie ein kleines Testprogramm, das zunächst ein Array mit VIntegerObjekten erzeugt und initailisiert
 *    anschließend die Funktion kleinstesElement mit diesem Array aufruft und 
 *    den Wert des ermittelten kleinsten Elements auf den Bildschrim ausgibt.
 */

interface Vergleichbar {
	/*
	 * vergl. das aufgerufene Objekt mit dem als Parameter uebergebenen Objekt;
	 * liefert : 
	 * -1 falls das aufgeruf. Objekt kleiner ist als das Paramobjekt,
	 *  0 falss beide Objekte gleich gross sind, 
	 *  1 falls das aufgerufene Objekt groesser ist als das Parameterobjekt.
	 * 
	 */
	 int vergleichInteger(Vergleichbar obj);
	
}

class NuetzlicheFunktionen{
	
	/*liefert ein "kleinstens" (auf der basis der Vergleichbar-Implementierung!)
	 *  Elelment des parameter-Arrays
	 *  Actung : man kann davon ausgehen, dass das Parameter-Array
	 *  mindestens 1 Element enthält.
	 * 
	 */
	public static Vergleichbar kleinstesElement(Vergleichbar[] elemente) {
		Vergleichbar kleinste  = elemente[0];
		for(Vergleichbar elm : elemente) {
			if(elm.vergleichInteger(kleinste) < 0 ) {
				kleinste = elm;
			}
		}
		return kleinste;
		
	}
}


class VInterger extends Integer implements Vergleichbar {

	protected VInterger(int w) {
		super(w);
	}

	@Override
	public int vergleichInteger(Vergleichbar obj) {
		VInterger obj1 = (VInterger) obj;	
		int v = this.getWert() < obj1.getWert() ? -1 : (this.getWert() > obj1.getWert() ? 1 : 0);
	    return v ; 
	}
	
}

class Integer  {
	protected int wert;
	
	protected Integer (int w) {
		this.wert = w;
	}

	public int getWert() {
		return this.wert;
	}
}



public class Test {

	public static void main(String[] args) {

		int min = -10;
		int max = 10;
		Random rnd = new Random();
		
		VInterger[] arrV1 = {
				new VInterger(rnd.nextInt(max-min+1)+min)  ,
				new VInterger(rnd.nextInt(max-min+1)+min)  ,
				new VInterger(rnd.nextInt(max-min+1)+min)  ,
				new VInterger(rnd.nextInt(max-min+1)+min)  ,
				new VInterger(rnd.nextInt(max-min+1)+min)  ,
		};

		System.out.println("Array of VInteger:");
	    
		for (VInterger v : arrV1) {
	            System.out.print(v.getWert() + " ");
	    
	    }
		
		
		 VInterger kleinste = (VInterger) NuetzlicheFunktionen.kleinstesElement(arrV1);
	     System.out.println("\nKleinste Element: " + kleinste.getWert());
	

	}

}
