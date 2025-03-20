package aufgeben.javakurs;



/* Test WDH 
*Mitarbeiten klass mussen expliziten Konstruktor haben 
*Es kompiliert nicht!! 
*
*	class Mitarbeiten extends Person{ 
*
*	}
*	
*/
class Mitarbeiten extends Person{
	public Mitarbeiten(String id , String name) {
		super(id, name);
	}
}


public class VererbungDozentTeilnehmer {

	
	public static void main(String[] args) {
		
		JavaKurs java1 = new JavaKurs("JAVA123");		
		JavaKursConsoleView.print(java1);
				
		Dozent d3 = new Dozent("Stephan","D103");
		java1.setDozent(d3);
		JavaKursConsoleView.print(java1);
		
	
		java1.addTeilnehmer(new Teilnehmer("Babara", "T101"));
		java1.addTeilnehmer(new Teilnehmer("Caty", "T102"));
		JavaKursConsoleView.print(java1);
		
		
		java1.addTeilnehmer(new Teilnehmer("Delv", "T103"));
		java1.addTeilnehmer(new Teilnehmer("Farry", "T104"));
		java1.addTeilnehmer(new Teilnehmer("Timmo", "T105"));
		JavaKursConsoleView.print(java1);
		
		java1.addTeilnehmer(new Teilnehmer("Wix", "T106"));
		
	


	}

}
