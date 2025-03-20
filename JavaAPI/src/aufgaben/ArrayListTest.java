package aufgaben;

import java.util.*;

public class ArrayListTest {

	public static void main(String[] args) {
	
		Random rnd = new Random();
		int min = -100;
		int max = 100;
	
		// A1 
		// Erzeugen Sie eine `ArrayList` mit 20 zufälligen Integer aus dem Bereich [-100 ... 100]. 
		// Geben Sie die Elemente der Liste durchnummeriert untereinander aus.
		System.out.println("#A1");
		ArrayList<Integer> intList = new ArrayList<>();
		int i = 0 ;
		while(i++<20) {
			intList.add(rnd.nextInt(max-min+1)+min);
		}
		intList.sort(Comparator.naturalOrder());
		System.out.println(intList);
		
        int counter = 1;
        // test matrix 4X4
        for (int x = 0; x <= 4; x++) {
            for (int y = 0; y < 4; y++) {
                if (counter <= intList.size()) {
                    System.out.print(counter + ". " + intList.get(counter - 1) + "\t");
                    counter++;
                }
            }
            System.out.println();
        }
      
        System.out.println();
        split();
		
        
        // A2  
        // Erzeugen Sie eine `ArrayList` mit folgenden Strings: "mo", "di", "mi", "do", "fr". 
        //Geben Sie die Elemente der Liste mit der foreach-Schleife aus.
        System.out.println("#A2");
		
        List<String> strList  = new ArrayList<String>();  //  List<String> Poliemorphie
		strList.add("mo");
		strList.add("di");
		strList.add("mi");
		strList.add("do");
		strList.add("fr");
	 
        for (String day : strList) {
            System.out.print(day + " ");
        }
        System.out.println();
        // or 
        System.out.print("Foreach : ");
        strList.forEach(day -> System.out.print(day + " "));
   	 	System.out.println("\n");
   	    split();
   	    
   	    
        // A3  
   	    //Erzeugen Sie eine `ArrayList` mit folgenden Werten: 10, 20, 30, 40, 50, 60, 70, 80. 
   	    //Geben Sie jedes zweite Element der Liste aus.
        System.out.println("#A3.1");
        intList.clear();
       
        int startInt = 10;
        while (startInt <= 80) {
            intList.add(startInt);
            startInt += 10;
        }
        
        System.out.println(intList); // 10, 20, 30, 40, 50, 60, 70, 80
      
        for( int j = 0 ; j <  intList.size() ; j+=2) {
        	System.out.print(intList.get(j) + " ");
        }
   	 	System.out.println("\n");
   	 
	   	   System.out.println("#A3.2 von Dozent");
	   	   Integer[] intArr = {10, 20, 30, 40, 50, 60, 70, 80};
	   	   List<Integer> intInteger = Arrays.asList(intArr); 
	   	   for( int j = 0 ; j < intInteger.size() ; j++) {
	   		   if(j%2==0)
	   			   System.out.print(intInteger.get(j) + " ");
	   	   }
	   	System.out.println("\n");
   	    split();
        
   	    // A4 
   	    //Erzeugen Sie eine `ArrayList` mit folgenden Werten: 10, 20, 30, 40, 50, 60, 70, 80. 
   	    //Geben Sie die Elemete der Liste rückwärts aus.
        System.out.println("#A4");
 
        System.out.print(intList);
        System.out.println();
        for(int x = intList.size()-1 ; x >= 0 ; x--) {
        	System.out.print(intList.get(x) + " ");
        }
        
   	 	System.out.println("\n");
   	    split();
   	  
   	  
        // A5   
   	    // Erzeugen Sie eine `ArrayList` mit 20 zufälligen Integer aus dem Bereich [-100 ... 100]. 
   	    //Sortieren Sie die Liste und geben Sie sie aus.
   	    //> Tipp: zum sortieren können Sie die Methode `sort` aus der Klasse `java.util.Collections`verwenden. 
   	    /*
   	     *  list.sort(Comparator.naturalOrder());
   	     */
        System.out.println("#A5");  
        intList.clear();
         i = 0 ;
		 while(i++<20) {
			intList.add(rnd.nextInt(max-min+1)+min);
		 }
		 //Alternative vor Java 8
		 Collections.sort(intList); 
		 System.out.print("ASC sort :");
		 intList.forEach( l -> System.out.print(" " + l));
		 System.out.println();
		 intList.sort(Comparator.reverseOrder());  // reverse witll sort desc 
		 System.out.print("DESC sort :");
		 intList.forEach( l -> System.out.print(" " + l));
		 
		 System.out.println("\n");
		 split();
		  
	    // A6 . 
		//Erzeugen Sie eine `ArrayList` mit 10 zufälligen Integer aus dem Bereich [10 ... 15]. 
		//Suchen Sie mit `indexOf` nach dem Wert 12.
	    System.out.println("#A6");
	    intList.clear();
	    i = 0 ;
	    for(; i<= 10 ; i++) {
	    	intList.add(rnd.nextInt((15-10+1)+10));
	    }
	    System.out.println(intList);
	    int index = intList.indexOf(12);
	    System.out.println("index wert 12 : " + index);
	    
	    System.out.println("\n");
	    split();  
	    
	    // A7 .
	    //Erzeugen Sie eine `ArrayList` mit 10 zufälligen Integer aus dem Bereich [0 ... 50]. 
	    //Suchen Sie mit `Collections.binarySearch` nach dem Wert 12.
	    System.out.println("#A7");
	    intList.clear();
	    
	    int searchValue = 12;
		for(int x = 0 ; x < 10 ; x++) {
			 intList.add(rnd.nextInt(50)+1);
		}
		Collections.sort(intList);
		intList.forEach( l-> System.out.print( l + " "));
		System.out.println();
		// Die Methode Collections.binarySearch wird verwendet, 
		// um die Position eines Elements in einer sortierten Liste zu finden.
		int result = Collections.binarySearch(intList, searchValue);
	    System.out.println("Collections.binarySearch nach dem Wert " + searchValue + " : " + result);
		 
	    System.out.println("\n");
	    split();
	    
	    
	    // A8 . 
	    //Erzeugen Sie eine `ArrayList` mit 10 zufälligen Integer aus dem Bereich [0 ... 50]. 
	    //Entfernen Sie mit `remove(int)` die ungeraden Werte.
	    System.out.println("#A8");
	    intList.clear();
	    for(int x = 0 ; x < 10 ; x++) {
			 intList.add(rnd.nextInt(50)+1);
		}
	    System.out.println(intList);
	    // Rückwert schleife
		for (int x = intList.size() - 1 ; x >= 0  ; x-- ) {
			if(intList.get(x)%2!=0)
				intList.remove(x);
		}
		System.out.println("Remove ungerede Werte : " + intList);
		
		System.out.println("\n");
		split(); 
		 
		 
		// A9 .
		//Erzeugen Sie eine `ArrayList` mit 10 zufälligen Integer aus dem Bereich [0 ... 50]. 
		//Entfernen Sie mit `removeIf(Predicate)` die ungeraden Werte. Verwenden Sie bei der Lösung eine Lambda Funktion.
		System.out.println("#A9");
		intList.clear();
	    for(int x = 0 ; x < 10 ; x++) {
			 intList.add(rnd.nextInt(50)+1);
		}
	    System.out.println(intList);
		intList.removeIf(n -> n%2 == 1 );  // ungeraden Werte.
		System.out.println("Remove ungerede Werte mit removeIf : " + intList);
		
		System.out.println("\n");
		split();
	    
		// A10 .
		//Erzeugen Sie eine `ArrayList` mit 10 zufälligen Integer aus dem Bereich [0 ... 50]. 
		//Ersetzen Sie in einer Schleife mit der Methode `set` alle ungeraden Werte durch 0.
		System.out.println("#A10");
		intList.clear();
	    for(int x = 0 ; x < 10 ; x++) {
			 intList.add(rnd.nextInt(50)+1);
		}
	    System.out.println(intList);
	    for(int x = 0 ; x < intList.size() ; x++) {
	    	if(intList.get(x)%2==1)
	    	  intList.set(x, 0);
	    }
	    System.out.println(intList);
		
	    System.out.println("\n");
	    split();
	    
	    
		// A11 
	    //Erstellen Sie folgende Liste mit Strings: mo, fr, di, fr, mi, fr, do, fr.
	   // Verwenden Sie bitte die Methode 'boolean remove(Object)' solange, bis es kein String "fr" mehr gibt.
		System.out.println("#A11");
		strList.clear();

	     String[] strArry = {"mo", "fr", "di", "fr", "mi", "fr", "do", "fr"};
	   
	     // Arrys.asList erzeugt eine ArrayList, die mit dem Array eng verknüpft ist (connected by the hip)
	     // Daraus ergibt sich, dass man in der entstandenen ArrayList keine Elemente hinzufügen oder löschen kann. 
	     // Man kann nur Elemente ersetzen.
	     
	     strList = Arrays.asList(strArry); //  java.lang.UnsupportedOperationException: remove
	     strList = new ArrayList<>(Arrays.asList(strArry)); // No Exception mehr
	     System.out.println(strList);
	     String strRemove = "fr";
	     // test with IF 
	     strList.removeIf(tag-> tag.equals("fr"));
	     System.out.println("List after removing 'fr' with removeIf : " + strList);
	    
	     // Alternative 1 
//	     for(int j  = strList.size() - 1 ; j >=0 ; j-- ) {
//	    	 if(strList.get(j).equals(strRemove)) {
//	    		 strList.remove(j);
//	    	 }
//	     }
	     // Alternative 2 
	     while (strList.remove(strRemove)) {}
	     
	     
	     System.out.println("List after removing 'fr': " + strList);
	     
		 System.out.println("\n");
		 split();
		  
	
		 // A12 .
		 intList.clear();
	
		  int[] a1 = { 1, 2, 3};
		  int[] a2 = { -7, -5 };
		  int[] a3 = { 101, 202, 303 };
		  
		  System.out.println("#A12  ");
		  
		  List<int[]> intListArr = new ArrayList<>() ;
		  intListArr.add(a1);
		  intListArr.add(a2);
		  intListArr.add(a3);

		  intListArr.forEach(list->System.out.println(Arrays.toString(list))); 
		  for (int[] list : intListArr) {
			  for (int n : list) {
				 System.out.printf("%5d", n);
			  }	
			  System.out.println();
		  }
			

	}

	static void split() {
		System.out.println("----------------------------------------------------");
	}

	
}
