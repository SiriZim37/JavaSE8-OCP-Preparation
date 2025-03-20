package aufgaben.lotto;

import java.util.Arrays;

public class LottoSpiel {
	 
	private int anzahlKugel;
	private int anzahlKugelGesamt;
	private int[] zahlen;
	
	public LottoSpiel( int anzahlKugel , int anzahlKugelGesamt) {
		this.anzahlKugel = anzahlKugel;
		this.anzahlKugelGesamt = anzahlKugelGesamt;
		zahlen = new int[anzahlKugel];
	}
	
	public void ziehen() {
		
		zahlen = ArrayUtils.createRandomUniqueArray(anzahlKugel, 1 , anzahlKugelGesamt);
		Arrays.sort(zahlen);

	}
	
	public String toString() {
		String text = "Spiel " + anzahlKugel + " aus " + anzahlKugelGesamt + ". ";
		
		if(zahlen==null) {
			text += "Es gab noch keine Ziehung";
		} else {
			text += Arrays.toString(zahlen);
		}
		
		return text;
		
	}
	
	
	
	public int vergleichen(LottoTipp tipp) {
		int tippLen = tipp.getZahlen().length;
		int spielLen = zahlen.length;
		int matches = 0 ;
		for (int i = 0; i <  tippLen ; i++) {
	         for (int j = 0; j < spielLen ; j++) {
	             if (tipp.getZahlen()[i] == zahlen[j]) {
	                 matches++;
	                 // Set index j value 0 to avoid counting it again
	                 zahlen[j] = 0;
	                 break;
	             }
	         }
	     }
		int res = calculatePrize(matches);	
//		System.out.format("%d richtige: %d Euro\n", matches , res);
		return res ;
	}

	public int calculatePrize(int matches) {
		int[] prizeMaster = {0, 1, 10, 100, 1000, 10000, 100000};
		return matches < prizeMaster.length ? prizeMaster[matches] : 0;
		
	}
	
	
	/*
	 * Gewinn berechnen: 
	 * 
	 *  0 richtige: 0 Euro			10 hoch -1      0.1
	 *  1 richtige: 1 Euro			10 hoch 0		1
	 *  2 richtige: 10 Euro			10 hoch 1		10
	 *  3 richtige: 100 Euro		10 hoch 2		100
	 *  4 richtige: 1000 Euro		10 hoch 3		1000
	 *  usw...
	 */
	public int vergleichenVonDozent(LottoTipp tipp) {
		
		int[] arr1 = zahlen;
		int[] arr2 = tipp.getZahlen();
		
		int anzahlRichtige = 0;
		
		for (int i = 0; i < arr1.length; i++) {
			int value = arr1[i];
			
			for (int j = 0; j < arr2.length; j++) {
				if(value == arr2[j]) {
					anzahlRichtige++;
					break;
				}
			}
		}
		
//		System.out.println("anzahl richtige: " + anzahlRichtige);
		
		return (int)Math.pow(10, anzahlRichtige-1);
	}
	
	
}
