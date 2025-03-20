package aufgaben.lotto;

import java.util.Arrays;
import java.util.Random;

public class LottoTipp {
	
	private int anzahlKugel;
	private int anzahlKugelGesamt;
	private  int[] zahlen;
	
	public LottoTipp(int anzahlKugel , int anzahlKugelGesamt ) {
		this.anzahlKugel = anzahlKugel;
		this.anzahlKugelGesamt = anzahlKugelGesamt;
		zahlen = new int[anzahlKugel];
	}

	public void abgeben() {   
		zahlen = ArrayUtils.createRandomUniqueArray(anzahlKugel, 1 , anzahlKugelGesamt);
		Arrays.sort(zahlen);
		
	}
	
	public String toString() {
		String text = "Tipp " + anzahlKugel + " aus " + anzahlKugelGesamt + ". ";
		
		if(zahlen==null) {
			text += "Noch nicht abgegeben";
		} else {
			text += Arrays.toString(zahlen);
		}
		
		return text;
	}
	
	public int[] getZahlen() {
		if(zahlen == null)
			return null;
	    return Arrays.copyOf(zahlen, zahlen.length);  // clone objekt zu schutzen !! bleib geschutzt
	 }
}
