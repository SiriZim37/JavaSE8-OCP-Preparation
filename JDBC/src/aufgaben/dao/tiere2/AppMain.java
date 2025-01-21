package aufgaben.dao.tiere2;

import java.util.List;
import java.util.Scanner;

public class AppMain {
	
	enum AppAction{
		EXIT("Beenden"), 
		PRINT_ALL_ANIMALS("Alle Tiere zeigen") ,
		CREATE_ANIMAL("ein Tier erzeugen") , 
		DELETE_ANIMAL("Ein Tier löschen.");
		
		private String displayText;
		
		private AppAction(String displayText) {
			this.displayText = displayText;
		}
		
		@Override
		public String toString() {
			return displayText;
		}
	}
	
	public static void main(String[] args) {
		
		TierDao tierDAO = TierDao.getInstance(); 

		while (true) {
			printMenu();
			
			AppAction userChoice = readUserChoice();

			switch (userChoice) {
				case EXIT:
					// alle Tiere zeigen
					System.out.println("Programm wird beendet.");
					return; // Exit the main method
				case PRINT_ALL_ANIMALS:
					// neues Tiere speichern
					printAllAninmals(tierDAO);
					break;
				case CREATE_ANIMAL:
					// ein Tier erzeugen
					createAninmal(tierDAO);
					break;
				case DELETE_ANIMAL:
					// ein Tier löschen
					deleteAnimal(tierDAO);
					break;
				default:
					throw new UnsupportedOperationException("Unbehandelte AppAction: " + userChoice);
	//				break;		// compiler fail : unreadable code
			}
		}
		
	}

	private static void printAllAninmals(TierDao dao) {
		List<Tier> alleTiere = dao.getAllTiere();
		
		System.out.println("\n***Alle Tiere: ");

		if(alleTiere.isEmpty()) {
			System.out.println("Es gibt keine Tiere");
		}
		
		
		System.out.println("| ID|      Name|       Art| Geburtsjahr|");
		String fmt = "|%3s|%10s|%10s|%12s|%n";
		
		for (Tier t : alleTiere) {
			System.out.printf(fmt, t.getId() , t.getName() , t.getArt() , t.getGeburtsjahr());
		}
		
	}
	private static void deleteAnimal(TierDao dao) {
		
		// User nach Tier-ID fragen
		System.out.println("Tier löschen");
		System.out.println("Bitte die id vom Tier eingeben");
		int id = readUserInt();
		
		if(!dao.deleteOnId(id)) { // Datenverwaltung(DELETE)
			System.out.println("Es gibt kein Tier mit der id=" + id);
		}else {
			System.out.println("Das Tier wurde entfernt");
		}
	}
	
	private static void createAninmal(TierDao dao) {	
		// User nach Daten für das neue Tier fragen
		
		 System.out.println("ID: " );
		 int id = readUserInt();
		
		 System.out.println("Name: " );
		 String name = readUserString();
	
		 System.out.println("Art: " );
		 String art = readUserString();
			 
		 System.out.println("Geburtsjahr: " );
		 int geburtsjahr = readUserInt();
		
		 		 
		 Tier t = new Tier(id, name, art, geburtsjahr);
		 dao.add(t);  // Datenverwaltung(CREATE)
		 System.out.println("Das Tier gespeichert");
	}

	
	private static void printMenu() {
		System.out.println("\n***Bitte eine Option auswählen:");		
		for (AppAction a : AppAction.values()) {
			System.out.println(a.ordinal() + " = " + a);
		}		
		System.out.print("Ihre Wahl: ");
	}
	
	private static AppAction readUserChoice() {
		String line = new Scanner(System.in).nextLine();
		int value = Integer.parseInt(line);
		return AppAction.values()[value];
	}
	
	private static String readUserString() {
		return new Scanner(System.in).nextLine();
	}
	
	private static int readUserInt() {
		String line = new Scanner(System.in).nextLine();
		return Integer.parseInt(line);
	}
	

}
