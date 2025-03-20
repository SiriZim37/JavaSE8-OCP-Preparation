package aufgeben.javakurs;


//Klasse JavaKurs
public class JavaKurs{
	private static final int maxAnzahlTeilnehmer = 5 ;
	private String kursnummer;	
	private Dozent dozent ; 
	private Teilnehmer teilnehmerArr[] = new Teilnehmer[maxAnzahlTeilnehmer];
	private int nextTeilnehmerIndex = 0 ;	

	public JavaKurs(String kursnummer) {
		this.kursnummer = kursnummer;
	}
	 
	public String getKursnummer() {
		return kursnummer;
	}	
	
	void setDozent(Dozent dozent) {
		this.dozent = new Dozent(dozent.getName(), dozent.getID())  ;
	}
	
	Dozent getDozent() {
		return dozent;		
	}
	
	void addTeilnehmer(Teilnehmer newTeilnehemer) {
		if(isVoll()) {
			throw new IllegalStateException("Alle Plätze sind schon belegt");
		}
		teilnehmerArr[nextTeilnehmerIndex++] = newTeilnehemer;
	}
	
	Teilnehmer getTeilnehmer(int index) {
		return teilnehmerArr[index];
	}
	
	int getAnzahlTeilnehmer() {
		return nextTeilnehmerIndex;
	}
	
	
	boolean isVoll() {
		
		if(nextTeilnehmerIndex < maxAnzahlTeilnehmer)
			return false;
		return true;
	}
	
	public String toString() {
		return "\nJavaKurs Nr : " + getKursnummer() ;
	}
}
