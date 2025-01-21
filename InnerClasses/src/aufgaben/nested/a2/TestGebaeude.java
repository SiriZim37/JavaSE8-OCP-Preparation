package aufgaben.nested.a2;


public class TestGebaeude {
	
	public static void main(String[] args) {
		
		
		try {
			Gebaeude g1 = new Gebaeude("Hauptstr" , 45 , 3 , 10   );
		
			Gebaeude.Raum r1 = g1.getRaum(0, 2);
            System.out.println(r1);  
            
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
		

		try {
			System.out.println("\ntest 1 : ");
			Gebaeude g2 = new Gebaeude("Hauptstr" , 45 , 0 , 0   );
		
			Gebaeude.Raum r2 = g2.getRaum(0, 5);
            System.out.println(r2);  
            
        } catch (IllegalArgumentException e) { 
            System.out.println(e.getMessage()); // Ein Gebäude muss mindestens 1 Stockwerk haben..
        }
		
		try {
			System.out.println("\ntest 2 : ");
			Gebaeude g3 = new Gebaeude("Hauptstr" , 45 , 3 , 10   );
		
			Gebaeude.Raum r3 = g3.getRaum(10, 5);
            System.out.println(r3);  
            
        } catch (IllegalArgumentException e) { 
            System.out.println(e.getMessage()); // Ungültige Stockwerksnummer: 10
            									// Bitte geben Sie Stockwerksnummer zwischen 0 und 2 ein.
        }
		
		try {
			System.out.println("\ntest 2 : ");
			Gebaeude g3 = new Gebaeude("Hauptstr" , 45 , 3 , 10   );
		
			Gebaeude.Raum r3 = g3.getRaum(1, 15);
            System.out.println(r3);  
            
        } catch (IllegalArgumentException e) { 
            System.out.println(e.getMessage()); // Ungültige Stockwerksnummer: 10
            									// Bitte geben Sie Stockwerksnummer zwischen 0 und 2 ein.
        }
		
		
		try {
			System.out.println("\ntest 3 : ");
			 GebaeudeVerschachteln g1 = new GebaeudeVerschachteln("Hauptstr", 45, 3, 10);
			 GebaeudeVerschachteln.Stockwerk.Raum r1 = g1.getRaum(0, 2);
	         System.out.println(r1);   
            
        } catch (IllegalArgumentException e) { 
            System.out.println(e.getMessage()); // Ungültige Stockwerksnummer: 10
            									// Bitte geben Sie Stockwerksnummer zwischen 0 und 2 ein.
        }
		
	}

}
