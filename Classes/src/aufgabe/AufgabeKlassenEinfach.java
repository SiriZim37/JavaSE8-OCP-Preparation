package aufgabe;

class Land{
	
	private String name;
	private int einwohnerzahl;
	
	// Konstruktor
	public Land(String name , int einwohnerzahl) {
		this.name = name;
		this.einwohnerzahl = einwohnerzahl;
	}
	 // Methode print
	public void print() {
		System.out.println("Land: " + this.name + ", Einwohnerzahl: " + this.einwohnerzahl + " Mio.");
	}
}

class Planet{
	
	private String name; 
	private long entfernungZurSonne;
	
	// Konstruktor
	public Planet(String name , long entfern) {
		this.name = name;
		this.entfernungZurSonne = entfern;
	}
	
	 // Methode print
	public void print() {
		    double entfernungInMio = this.entfernungZurSonne / 1_000_000.0 ;		    
	        System.out.println("Planet: " + this.name + ", Entfernung zur Sonne: " + entfernungInMio + " Mio. Km");
	    }
	
	 // Methode bewegen
	public void bewegen(long entfernung  ) {
		this.entfernungZurSonne += entfernung;
	}
}



public class AufgabeKlassenEinfach {

	public static void main(String[] args) {
		
		
		// A1
		Land brasilien = new Land("Brasilien", 211);
		Land deutschland = new Land("Deutschland", 83);
		
		brasilien.print();
		deutschland.print();

		System.out.println();
		
		// A2
		Planet erde   = new Planet("Erde", 147_000_000L); //147 Mio. Km 
		Planet neptun = new Planet("Neptun", 4_500_000_000L); // 4500 Mio. Km	
		erde.print();
		neptun.print();
		
		System.out.println();
		 // Bewege die Planeten
		erde.bewegen(30_500L); // 30.500 Km
		neptun.bewegen(-90_500_000L); // -90.500.000 Km
		
		// Drucke die neuen Entfernungen
		erde.print();
		neptun.print();
		
	}

}
