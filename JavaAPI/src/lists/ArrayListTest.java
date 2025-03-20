package lists;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import aufgaben.stringbuilderapi.StringBuilderAPI;

public class ArrayListTest {

	public static void main(String[] args) {

		String[] strArr = { "Fred" , "Betty" , "Will" , "Barney"}; 
		System.out.println(strArr );
		System.out.println(Arrays.toString(strArr) );
		

		// Eine ArrayList ist ein Mitglied des Collections Framework in Java.
		// Es ist eine dynamicsche , geodnete Liste , , die beliebig erweitert werden kann.
		ArrayList<String> strList = new ArrayList<String>();
		int anzahl = strList.size();
		System.out.println("anzahl = " +  anzahl);
		strList.add("Betty");
		strList.add("Barney");
		strList.add("Wilma");
		strList.add("Fred");
		System.out.println("anzahl = " + strList.size() );
		System.out.println("strList = " + strList);

		strList.add("Pebbles");
		strList.add("Bambam");
		strList.add("Bambam");	// duplicate erlaubt
		System.out.println("anzahl = " + strList.size() );
		System.out.println("strList = " + strList);

		//		strList.clear(); // entfernt alle Elemente der ArrayList
		System.out.println("anzahl = " + strList.size() );
		System.out.println("strList = " + strList);
		
//		strList.remove(6); // ok : but  java.lang.IndexOutOfBoundsException: Index 6 out of bounds for length 6
		strList.remove(5); 
		System.out.println("anzahl = " + strList.size() );
		System.out.println("strList = " + strList);
		
		strList.remove("Pebbles");
		System.out.println("anzahl = " + strList.size() );
		System.out.println("strList = " + strList);
		
		if(strList.isEmpty()) {
			System.out.println("List ist leer");
		}
		int index = strList.indexOf("Fred");
		System.out.println("index = " + index);

		boolean contains = strList.contains("Betty");
		System.out.println("contains = " + contains);
		
		index = 1;
		System.out.println("Element and index 1 = " + strList.get(index));
		
		System.out.println("********************");		
//		for(String name : strList) {
//			System.out.println(name);
//		} // ok 
		strList.forEach(list->System.out.println(list));
		System.out.println("****** sortiert ********");		
		strList.sort(null);
		strList.sort(Comparator.naturalOrder());
		strList.forEach(list->System.out.println(list));
		
		
		strList.add("Bambam");  // Duplikate erlaubt
		System.out.println("Index Test");
		for(String str : strList){
			System.out.print(strList.indexOf(str) + " ");  // 0 1 2 3 4 0  
		}
	}

}
