package aufgaben.autos;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;


public class TestCollectionsAutos {

	public static void main(String[] args) {
	
		//###### A2.
		VW 	vw 	= new VW ("Golf" , 1990);
		BMW bmw = new BMW("Z4", 2000);
		
		System.out.println(vw);
		System.out.println(bmw);
		
		//###### A3.
		VW 	vw1 = new VW ("Golf" , 1990);
		VW 	vw2 = new VW ("Polo"  , 2021);
		VW 	vw3 = new VW ("Golf"  , 2024);
			
		
		// ###### A4.
		/*
		 * Beim Sortieren sollen die Objekte erst 
		 * nach dem Modell und dann nach dem Baujahr verglichen werden 
		 */
		/*
		 * HashSet 	: used hashCode 
		 * TreeSet & PriorityQueue 	: used compareTo  
		 */
		
		//LinkedList
		System.out.println("\nLinkedList...");
		LinkedList<VW> vwlist =  new LinkedList<>(Arrays.asList(vw1, vw2, vw3));
		printForm(vwlist);
		
		// HashSet
		System.out.println("\nHashSet...");
		Set<VW> vwHashSet =  new HashSet<>(vwlist);
		
		vwHashSet.add( new VW ("Polo"  , 2021)); // Test auf doppelte Elemente
		printForm(vwHashSet);
	
		
		// TreeSet 
		// Ohne CompareTo : es wird ClassCastException
		System.out.println("\nTreeSet...");
	
		Set<VW> vwTreeSet =  new TreeSet<>(vwlist);		
		System.out.println("vwTreeSet.size() = " + vwTreeSet.size());
		printForm(vwTreeSet);
	
		// PriorityQueue 
		// Ohne CompareTo : es wird ClassCastException
		System.out.println("\nPriorityQueue...");
		Queue<VW> vwQueue =  new PriorityQueue<>(vwlist);
		printForm(vwQueue);			// Es wird nicht sortiert. 
		
		System.out.println("\n--- Queue lerren : ");
		while (!vwQueue.isEmpty()) {
	        System.out.println(vwQueue.remove());  
	    }
		// ------------------------------------------------------------------------------
		
		//###### A6.
		/*
		 * HashSet 	: used hashCode 
		 * TreeSet & PriorityQueue 	: used compareTo  
		 */
		BMW bmw1 = new BMW("Z4", 2000);
		BMW bmw2 = new BMW("Z2", 2021);
		System.out.println("\n" + bmw1); // BMW Z4, Baujahr 2000
		
		//ArrayList
		System.out.println("\nArrayList...");
		List<BMW> bmwList = new ArrayList<BMW>(Arrays.asList(bmw1, bmw2));
		printForm(bmwList);
		
		//HashSet
		System.out.println("\nHashSet...");
		HashSet<BMW> bmwHashSet = new HashSet<BMW>(bmwList);
		
		bmwHashSet.add(new BMW("Z4", 2000)) ; // Test auf doppelt 
		printForm(bmwHashSet);
		
		//TreeSet
		System.out.println("\nTreeSet...");
		TreeSet<BMW> bmwTreeSet = new TreeSet<BMW>(bmwList);
		bmwTreeSet.add(new BMW("Z4", 2000)) ; // Test auf doppelt 
		bmwTreeSet.add(new BMW("Z2", 2023)) ; // Test auf Sortiert
		printForm(bmwTreeSet);
		
		//ArrayDeque
		System.out.println("\nArrayDeque...");
		Queue<BMW> bmwDeque = new ArrayDeque<BMW>(bmwList);
		printForm(bmwDeque);	  
		
		//###### A7.
		// bm1 =  BMW. Modell: i7 M70, Baujahr 2024
		bmw1.setBauJahr(3333);
		System.out.println("\nbmw1.hashCode() = " + bmw1.hashCode());
		boolean resultContain = bmwHashSet.contains(bmw1);
		System.out.println("\nHashSet contains(bmw1) :" +  resultContain); 	// true
		
		
		//###### A8.
		
		//bmw1.setBaujahr(2020);	 // bm1 = BMW. Modell: i7 M70, Baujahr 2020
		resultContain = bmwHashSet.contains(bmw1);
		System.out.println("\nbmw1.hashCode() von Baujahr(2020) =" + bmw1.hashCode());
		System.out.println("\nHashSet contains(bmw1) :" +  resultContain); // false :  der HashSet verwendet den Hashcode
	
		
		//###### A9.
		VW vw4 = new VW("Polo", 2200);
		vwlist.add(vw4);
		
		//###### A10.
		// int binarySearch(List<? extends Comparable<? super T>> list, T key) {
		int index = Collections.binarySearch(vwlist, vw4);
		System.out.println("\nCollections.binarySearch nach (Polo, Baujahr 2200)) = "+ index); // 3
		
		index = Collections.binarySearch(vwlist, new VW ("Golf"  , 2024));
		System.out.println("\nCollections.binarySearch nach (Polo, Baujahr 2200)) = "+ index); //  -2
	
		//###### A11.
		System.out.println("Collections.sort : ");
		Collections.sort(vwlist);
		printForm(vwlist);
		
		
		//###### A12.
		Comparator<VW> cmpReverse = Comparator.comparing(VW::getModell)
										.thenComparing(VW::getBaujahr)
										.reversed();
		
		System.out.println("Collections.sort (Umkehrreihenfolge): ");
		Collections.sort(vwlist , cmpReverse );
		printForm(vwlist);
		
		//###### A13.
		index = Collections.binarySearch(vwlist, vw4);
		System.out.println("\nCollections.binarySearch nach (Polo, Baujahr 2200)) = "+ index); // -5
		
		//###### A14.
		index = Collections.binarySearch(vwlist, new VW("Polo",3300));
		System.out.println("\nCollections.binarySearch nach (Polo, Baujahr 3300)) = "+ index); // -5
	}
	

	//###### A5.                   
	static<T> void print(Collection<T> c) {
		System.out.println("\n*** "+ c.getClass());
		int index = 1; 
		for (T v : c) {
			System.out.println(index++ + ". " + v);
		}
	}
	
	static void printForm(Collection<? extends Auto> coll) {
		System.out.println("\n*** "+ coll.getClass());
		int index = 1; 
		for (Auto a : coll) {
			System.out.format("|%2d|%5s|%7s|%5d|%n" , index++ , a.getHersteller() , a.getModell() ,  a.getBaujahr() );
		}
	}

}
