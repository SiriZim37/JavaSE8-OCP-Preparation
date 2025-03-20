package aufgaben;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class ArrayListErweitertTest {

	public static void main(String[] args) {
	
		// A1 
		System.out.println("#A1");
		//Erzeugen Sie eine `ArrayList` mit folgenden Strings: "mo", "di", "mi", "do", "fr". 
		//Verwenden Sie einen `Iterator` um die Elemente der Liste mit der while-Schleife auszugeben.
		String[] arrWeekDay = new String[]{"mo", "di", "mi", "do", "fr"};
		ArrayList<String> wochentage = new ArrayList<>(Arrays.asList(arrWeekDay));
		
		Iterator<String> it = wochentage.iterator();

		while(it.hasNext()) {
			System.out.print(it.next()+" ");
		}
		
		System.out.println("\n");
		
		// A2
		System.out.println("#A2");
		//Erzeugen Sie eine `ArrayList` mit 10 zufälligen Integer aus dem Bereich [0 ... 50]. 
		//Entfernen Sie mit `removeIf` die ungeraden Werte.

		Random rnd = new Random();
		ArrayList<Integer> intList = new ArrayList<>();
		int x = 0 ;
		while(x++<10) {
			intList.add(rnd.nextInt(51));
		}
		intList.forEach(list -> System.out.print(list+" "));
		Predicate<Integer> predUngerade = n->n%2 == 1 ;
		intList.removeIf(predUngerade);

		System.out.println();
		intList.forEach(list -> System.out.print(list+" "));
		System.out.println("\n");
		
		// A3 
		System.out.println("#A3");
		//Erzeugen Sie eine `ArrayList` mit 10 zufälligen Integer aus dem Bereich [0 ... 50]. 
		//Ersetzen Sie mit der Methode `replaceAll` alle ungeraden Werte durch 0.
		intList.clear();
		 x = 0 ;
		while(x++<10) {
			intList.add(rnd.nextInt(51));
		}
		intList.forEach(list -> System.out.print(list+" "));
		System.out.println();
		
		// replaceAll ist UnaryOperator
		UnaryOperator<Integer> uop = n -> n % 2 == 1 ? 0 : n;
		intList.replaceAll(uop);
		intList.forEach(list -> System.out.print(list+" "));
		System.out.println("\n");
		
		//A4
		System.out.println("#A4");
		//Erzeugen Sie eine `ArrayList` mit 10 zufälligen Integer aus dem Bereich [0 ... 50]. 
		//Verwenden Sie eine Methode `toArray` um ein Array mit den Elementen der Liste zu erhalten.
		intList.clear();
		 x = 0 ;
		while(x++<10) {
			intList.add(rnd.nextInt(51));
		}
		Integer[] list = intList.toArray(new Integer[0]);
		System.out.println(Arrays.toString(list));
		System.out.println("\n");
		
		
		// A5. Optional
		System.out.println("#A5");
		// Erzeugen Sie ein Integer-Array. Überlegen Sie sich mindestens zwei Möglichkteiten, 
		// eine ArrayList mit den Elementen des Arrays zu erstellen. 

	
		Integer[] arrayInteger = new Integer[10];
		for(int i = 0 ; i< 10 ; i++) {
			arrayInteger[i] = rnd.nextInt(51) ;
		}
		// 1. Variante , connected bx the hip , Liste kann nicht in der Grüße verändert werden ( Kein Hinzufügen oder Löschen)
		// Methode 1: Verwenden von Arrays.asList() und Erstellen einer ArrayList
		List<Integer> list1 = new ArrayList<>();
		list1 =	Arrays.asList(arrayInteger);
		intList.forEach( n -> System.out.print( n + " "));
		 
        System.out.println();
        //2. Variante m compy-Konstruktor , ArrayList kann in derGröße verändert werden
        // Methode 2: Manuelles Hinzufügen der Array-Elemente zur ArrayList
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(arrayInteger));
        for (Integer num : arrayInteger) {
            list2.add(num);
        }
        list2.forEach( n -> System.out.print( n + " "));
        System.out.println("\n");
        
        
        //A6
        System.out.println("#A6");
        //Erzeugen Sie eine ArrayList mit "montag", "di", "mittw.", "freitagabend", "samstag". 
        // Verwenden Sie bitte die Methode `sort(Comparator)` der Klasse `ArrayList` , 
        // um die Liste nach der Länge der Strings zu sortieren.
        
        wochentage.clear();
        String[] arryStr = {"montag", "di", "mittw.", "freitagabend", "samstag"};
        wochentage = new ArrayList<String>(Arrays.asList(arryStr));
        
        Comparator<String> compLaenge = (s1,s2)-> s1.length() - s2.length() ; 
        compLaenge =  (s1,s2)-> s1.length() == s2.length()?  s1.compareTo(s2) : s1.length() - s2.length() ; 
        wochentage.sort(compLaenge);
        wochentage.forEach( n -> System.out.print( n + " "));
        //oder 
        System.out.println();
        wochentage.sort(Comparator.comparing(String::length));
        wochentage.forEach( n -> System.out.print( n + " "));
        
	}


}
