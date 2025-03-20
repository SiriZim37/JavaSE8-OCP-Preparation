package aufgeben.javakurs;

public class JavaKursConsoleView {

	public static void print(JavaKurs kurs) {
		
		System.out.println("\n**** Java-Kurs");
		System.out.println("ID : " + kurs.getKursnummer());
		
		Dozent d = kurs.getDozent();
		System.out.println( d==null? "noch nicht zugewiesen" : d );
		
		int anzahlTeilnehmer = kurs.getAnzahlTeilnehmer();
		if(anzahlTeilnehmer == 0)
			System.out.println("Es gibt keine Teilnehmer im Kurs");
		else {		
			System.out.println("\nTeilnehmer :");
			
			String fmt = "|%4s|%8s|%5s|%n";  // breit 4 
			
			System.out.format(fmt,"Nr.","Name","ID");
			for(int i = 0 ; i < anzahlTeilnehmer ; i++) {
				Teilnehmer tn = kurs.getTeilnehmer(i);
				System.out.format(fmt ,i+1 , tn.getName() , tn.getID() );
			}
		}
	}
	
	
}
