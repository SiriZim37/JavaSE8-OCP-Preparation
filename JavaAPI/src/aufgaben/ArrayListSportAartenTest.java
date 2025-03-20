package aufgaben;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ArrayListSportAartenTest {

	public static void main(String... args) {


				
		// A2
		Sportart[] arraySportarten = {  new Sportart("Ringen" , true)   , 
										new Sportart("Gewichteben" , true)   , 
										new Sportart("Schwimmen" , true )   , 
										new Sportart("Faustball" , false )   , 
										new Sportart("Schach" , false )  
									} ;
		
		// Konvertieren Sie das Array in eine List
		List<Sportart> sportartenList = Arrays.asList(arraySportarten); 
		
		// 2 Alternative 
//		List<Sportart> sportartenList = new ArrayList<>(); 
		
		
		ArrayList<Sportart> sportartenListe = new ArrayList<>(sportartenList);
		Collections.sort(sportartenListe);
		sportartenListe.forEach(System.out::println);
		
		// A3
		Sportart suchSportart = new Sportart("Ringen", true);
		boolean isEqual = sportartenListe.contains(sportartenListe.get(0));
		System.out.println("\nisEqual : " + isEqual);
		boolean such = sportartenListe.contains(suchSportart);
		int indexSuch = sportartenListe.indexOf(such);
		System.out.println("Such nach Ringen index  : " + indexSuch); //  -1 weil es andere Objekte und nicht in Liste
		System.out.println("Such nach Ringen : " + such); // false before Überladen (Überschreiben)
	
		//A4
	    sportartenListe.removeIf(s -> s.isOlmpisch());
		System.out.println("\n--Remove Liste , die nicht Olympisch--");
		sportartenListe.forEach(System.out::println);
		
		// A5
		//  Suchen Sie mit `Collections.binarySearch` nach einer Sportart Ihrer Wahl.
		suchSportart = new Sportart("Schach", false);
	    Comparator<Sportart> comparator = Comparator.comparing(Sportart::getName);
	    int index = Collections.binarySearch(sportartenListe, suchSportart, comparator);
	    System.out.println("\nIndex of Schach ist : " + ( index<0 ? "Not found" : index) ); 

	    
//	    suchSportart = new Sportart("Handball", false); //  -3 
//	    suchSportart = new Sportart("V0lleyball", false); //  -3 
	    suchSportart = new Sportart("Faustball", false); //  0
	    
	    // Alternative sort
	    sportartenListe.sort(Comparator.naturalOrder());
	    index = Collections.binarySearch(sportartenListe, suchSportart );
	    System.out.println("\nIndex of Handball ist (Comparator.naturalOrder())  : " + index); 
	    
	    
	    index = Collections.binarySearch(sportartenListe, suchSportart);
		comparator = Comparator.comparing(Sportart::getName);
	    index = Collections.binarySearch(sportartenListe, suchSportart , comparator);
	    System.out.println("\nIndex of Handball ist (Comparator.comparing(Sportart::getName)): " + index); 
	}

}


