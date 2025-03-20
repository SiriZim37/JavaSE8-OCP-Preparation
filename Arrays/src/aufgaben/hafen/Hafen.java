package aufgaben.hafen;

import java.util.Arrays;

public class Hafen {

	private Schiff[] schiffeArr;
	private int anzahlSchiffe;
	private static final int defaultMaxAnzahl = 100;  //  Maximale Anzahl Schiffe am hafen


	Hafen(){
	    this(defaultMaxAnzahl);
	}
	  
	Hafen(int max){
	      schiffeArr = new Schiff[max];
	      anzahlSchiffe = 0 ; // eigentlich auch nicht nötig. 0 ist auch so der default-init-Wer
	}
	  
	Schiff get(int index) {
		
		return schiffeArr[index];
	}
	
	public void schiffHinzufuegen(Schiff schiff) {
		if(anzahlSchiffe < schiffeArr.length ) {
			schiffeArr[anzahlSchiffe] = schiff;
			anzahlSchiffe++;
		}else {
			System.out.println("Schiff [" + schiff.getName() + "] kann nicht ankern. Der Hafen ist voll!");
		}
	}
	
	public void schiffVerlassen(String schiffName) {
		for(int i = 0 ; i < anzahlSchiffe ; i++) {
			if( (schiffeArr[i].getName().isEmpty() && 
					schiffeArr[i].getName().equals(schiffName) )
				|| schiffeArr[i].getName().equals(schiffName)) {
				schiffVerlassen(i);
				System.out.println("Schiff [" + schiffeArr[i].getName() + "] hat den Hafen verlassen.");
				break; // Es kann nur ein Schiff verlassen
			}
		} 
		// Wenn der Name des Schiffes empty ist , wird nur ein index entwerfen.
		
	}
	

	public int getAnzahlSchiff() {
		return anzahlSchiffe;
	}
	
	public int getFreierPlaetze() {
		return schiffeArr.length - anzahlSchiffe;
	}
	
	public void anzeigeSchiffeAmBootssteg() {
		
		 System.out.println(Arrays.toString(schiffeArr));
	}
	
	public String toString() {
		return "Hafen (Schiffe: " + getAnzahlSchiff() +" . Freie Plätze: " + getFreierPlaetze() + ")";
		
	}
	
	
    private void schiffVerlassen(int index) {
        for (int i = index; i < anzahlSchiffe - 1; i++) {
            schiffeArr[i] = schiffeArr[i + 1];
        }
        schiffeArr[anzahlSchiffe - 1] = null;
        anzahlSchiffe--;
    }

}
