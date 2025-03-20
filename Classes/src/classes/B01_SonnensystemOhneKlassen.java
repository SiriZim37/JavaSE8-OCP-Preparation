package classes;

public class B01_SonnensystemOhneKlassen {

	/*
	 * Planet Mars
	 */
	static String name1 = "Mars";
	static int x1 = 12;
	static int y1 = -3;
	
	/*
	 * Planet Erde
	 */
	static String name2 = "Erde";
	static int x2 = 45;
	static int y2 = 67;
	
	/*
	 * weitere Planeten ähnlich formulieren...
	 */
	
	
	/*
	 * Nachteile der Lösung:
	 * 
	 * 		- Eigenschaften eines virtuellen Planeten sind lose Variablen,
	 *        die nur im Kopf des Entwicklers eine Einheit bilden
	 *        
	 *      - Universelle Algorithmen für Planeten können nicht wirklich schön realisiert werden
	 *      
	 *      ...
	 */
	public static void main(String[] args) {

		printPlanet(name1, x1, y1); // Mars. Koordinaten: 12, -3
		
		printPlanet(name2, x2, y1); // Bug hier! zweite Koordinate ist falsch
		
		bewegePlanet("Mars", 333, 11);
		
		printPlanet(name1, x1, y1); // Mars. Koordinaten: 333, 11
		
		bewegePlanet("Erde", -25, -300);
		
		printPlanet(name2, x2, y2); // Mars. Koordinaten: 45, 67
	}
	
	static void printPlanet(String name, int x, int y) {
		System.out.println(name + ". Koordinaten: " + x + ", " + y);
	}
	
	/*
	 * Bitte so nicht programmieren!
	 */
	static void bewegePlanet(String name, int newX, int newY) {
		
		switch(name) {
			case "Mars":
				x1 = newX;
				y1 = newY;
				break;
			case "Erde":
				x2 = newX;
				y2 = newY;
				break;
			//...ähnlich für weitere Planeten
		}
		
	}

}
