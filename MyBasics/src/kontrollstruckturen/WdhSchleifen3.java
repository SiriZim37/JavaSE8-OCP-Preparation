package kontrollstruckturen;

public class WdhSchleifen3 {

	public static void main(String[] args) {

		// ungerade Werte zw. 1 bis 10 ausgeben
		int zahl = 0;
		do {
			zahl++; // inkrementieren
			if(zahl%2==0) {
				continue;
			}
			System.out.print(zahl + " ");
			
		} while(zahl < 10);
		System.out.println();

		// ungerade Werte zw. 1 bis 10 ausgeben
		zahl = 0;
		do {
			if(zahl%2==0) {
				continue;
			}
			System.out.print(zahl + " ");
			
		} while(++zahl < 10); // inkrementieren
		System.out.println();
		
		
	}

}
