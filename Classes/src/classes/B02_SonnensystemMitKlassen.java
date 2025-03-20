package classes;

class Planet {
	/*
	 * Klasse als Code-Container.
	 * 
	 * Das sind statische Methoden (einfache Algorithmen), die
	 * thematisch etwas mit Planeten zu tun haben:
	 */
	static void printPlanet(String name, int x, int y) {
		System.out.println(name + ". Koordinaten: " + x + ", " + y);
	}
	
	static void printPlanet(Planet p) {
		System.out.println(p.name + ". Koordinaten: " + p.x + ", " + p.y);
	}
	
	static void bewegePlanet(Planet p, int newX, int newY) {
		p.x = newX;   
		p.y = newY;
	}
	
	/*
	 * Klasse als Schablone für Objekte.
	 * 
	 * Das sind Attribute (Felder, Instanzvariablen, Objektvariablen), die jedes Planet-Objekt haben wird:
	 */
	String name;
	int x;
	int y;
	
	
	
	/*
	 * Klasse als Schablone für Objekte.
	 * 
	 * Das ist eine Objekt-Methode (Instanz-Methode):!!!!!!!!!! 
	 */
	void bewegen(int newX, int newY) {
		x = newX; 
		this.y = newY;
	}
	
}

public class B02_SonnensystemMitKlassen {

	public static void main(String[] args) {
		
		Planet mars = new Planet();
		mars.name = "Mars";
		mars.x = 12;
		mars.y = 33;
		
 		Planet erde = new Planet();
 		erde.name = "Erde";
 		erde.x = 45;
 		erde.y = 67;
 		

 		Planet.printPlanet(mars.name, mars.x, mars.y);
 		Planet.printPlanet(mars); // fürs Aufrufen bequemere Möglichkeit. 
 									// Mars. Koordinaten: 12, 33
 		
 		Planet.bewegePlanet(mars, 333, 11);
 		Planet.printPlanet(mars); // Mars. Koordinaten: 333, 11
 		
 		mars.bewegen(-345, 987);
 		Planet.printPlanet(mars); // Mars. Koordinaten: -345, 987
 		Planet.printPlanet(erde);

 		
 		/*
 		 *  NOTE !
 		 *  
 		 *  Planet p  >>> p ist kein Object : Object ist Planet und er hat 2 Attribute int x , int y 
 		 *  operator new Planet();
 		 * 
 		 */
	}

}
