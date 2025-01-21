package aufgaben.autos;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;


public class AufgabeCollectionsAutos {

	public static void main(String[] args) {
		
		VW vw1 = new VW("Golf", 1990);
		System.out.println(vw1); // VW. Modell: Golf, Baujahr 1990
		VW vw2 = new VW("Polo", 2021);
		VW vw3 = new VW("Golf", 2024);
		
		/*
		 * A4
		 * 
		 * 
		 */
		
		/*
		 * HashSet 	: used hashCode 
		 * TreeSet & PriorityQueue 	: used compareTo  
		 */
		
		// LinkedList
		List<VW> listVW = new LinkedList<>();
		listVW.add(vw1);
		listVW.add(vw2);
		listVW.add(vw3);
		
		print(listVW);
		
		// HashSet
		Set<VW> hashSetVW = new HashSet<>();
		hashSetVW.addAll(listVW);
		
		hashSetVW.add(new VW("Polo", 2021)); // Test auf doppelte Elemente
		print(hashSetVW);
		
		// TreeSet
		Set<VW> treeSetVW = new TreeSet<>(listVW);
		
		treeSetVW.add(new VW("Polo", 2021));
		print(treeSetVW);
		
		// PriorityQueue
		Queue<VW> queueVW = new PriorityQueue<>(listVW);
		print(queueVW);
		
		System.out.println("--- Queue leeren: ");
		while(!queueVW.isEmpty()) {
			System.out.println(queueVW.remove());
		}

		/*
		 * A6
		 */
		
		BMW bmw1 = new BMW("Z4", 2000);
		BMW bmw2 = new BMW("Z2", 2021);
		System.out.println(bmw1); // BMW. Modell: Z4, Baujahr 2000

		// ArrayList
		List<BMW> listBMW = new ArrayList<>();
		listBMW.add(bmw1);
		listBMW.add(bmw2);
		 
		print(listBMW);
		
		// HashSet
		Set<BMW> hashSetBMW = new HashSet<>(listBMW);
		
		hashSetBMW.add(new BMW("Z4", 2000)); // Test auf doppelte
		print(hashSetBMW);
		
		// TreeSet
		Set<BMW> treeSetBMW = new TreeSet<>(listBMW);
		
		treeSetBMW.add(new BMW("Z4", 2000)); // Test auf doppelte
		//treeSetBMW.add(new BMW("Z2", 2017)); // ok: Test auf Sortieren bei gleichen Modellen
		print(treeSetBMW);
		
		// ArrayDeque
		Deque<BMW> dequeBmw = new ArrayDeque<>(listBMW);
		
		print(dequeBmw);
		
		/*
		 * A7
		 */
		System.out.println("\n---------------------");
		System.out.println("----------A7----------");
		System.out.println("----------------------");
		print(hashSetBMW);
		
		System.out.println("bmw1.hashCode() =" + bmw1.hashCode());
		System.out.println("hashSetBWM.contains(bmw1) : " + hashSetBMW.contains(bmw1)); // true
		
		/*
		 * A8
		 */
		System.out.println("\n---------------------");
		System.out.println("----------A8----------");
		System.out.println("----------------------");
		
		bmw1.setBauJahr(3333);	// Ändert auch den hashcode des Objektes! 
		print(hashSetBMW);
		
		System.out.println("bmw1.hashCode() =" + bmw1.hashCode());
		System.out.println("hashSetBWM.contains(bmw1) : "
						+ hashSetBMW.contains(bmw1)); // false : das Element kann nicht mehr 
		/*
		 * A9
		 */
		System.out.println("\n---------------------");
		System.out.println("-------A9 , A10-------");
		System.out.println("----------------------");
		listVW.add(new VW("Polo", 2200));
		
		print(listVW);
		/*
		 * A10
		 */
		// int binarySearch(List<? extends Comparable<? super T>> list, T key) {
		
		// falsch : binarySearch braucht eine sortierte Liste
		int index = Collections.binarySearch(listVW, new VW("Polo", 2200));
		System.out.println("\nindex of Polo 2200 = "+ index); 			//	 3 (zufällig richtig)
		
		// falsch : binarySearch braucht eine sortierte Liste
		index = Collections.binarySearch(listVW, new VW("Golf", 2024));
		System.out.println("index of Golf 2024 = "+ index); 			//	 -2 (Es wird noch nicht Sortiert! falsch  )
		
		/*
		 * A11
		 */
		System.out.println("\n---------------------");
		System.out.println("----------A11---------");
		System.out.println("----------------------");
		System.out.println("Collections.sort : ");
		Collections.sort(listVW);
		print(listVW);
		
		
		// richtig : binarySearch braucht eine sortierte Liste
		index = Collections.binarySearch(listVW, new VW("Polo", 2200));
		System.out.println("\nindex of Polo 2200 = "+ index); 			// indewx :  3 
		
		// richtig : binarySearch braucht eine sortierte Liste
		index = Collections.binarySearch(listVW, new VW("Golf", 2024));
		System.out.println("index of Golf 2024 = "+ index); 			// indewx :  1
		
		
		/*
		 * A12 , A13
		 */
		System.out.println("\n---------------------");
		System.out.println("-------A12 , A13-------");
		System.out.println("----------------------");
		System.out.println("\nCollections.sort (Umkehrreihenfolge): ");
		
		Comparator<VW> cmpReverse = Comparator.comparing(VW::getModell)
									.thenComparing(VW::getBaujahr)
									.reversed();
		Collections.sort(listVW , cmpReverse );
		print(listVW);
		
		Collections.sort(listVW , Comparator.reverseOrder() );
		print(listVW);
		
		// falsch : binarySearch braucht eine sortierte Liste
		//			denselben Comparator für die Vergleiche benutzen ,
		//			der beim Sortieren verwendet wurde
		index = Collections.binarySearch(listVW, new VW("Polo", 2200));
		System.out.println("\nindex of Polo 2200 = "+ index); 			//  indewx : -5
		
		
		// richtig : überladene binarySearch einsetzen , die 
		//			und muss denselben Comparator für die Vergleiche benutzen
		index = Collections.binarySearch(listVW, new VW("Polo", 2200) , Comparator.reverseOrder());
		System.out.println("\nindex of Polo 2200 = "+ index); 			//  indewx : 0

		
		/*
		 * A14
		 */
		System.out.println("***suche nach  Polo 3300");
		VW key = new VW("Polo",3300);
		Comparator<VW> cmp = Comparator.reverseOrder();
		index = Collections.binarySearch(listVW, key , cmp);
		System.out.println("\nCollections.binarySearch nach (Polo, Baujahr 3300)) = "+ index); // -1
		
		
	} // end of main

	static void print(Collection<? extends Auto> coll) {
		System.out.println("\n*** " + coll.getClass().getSimpleName());
		
		int i = 0;
		for(Auto a : coll) {
			System.out.format("|%2d|%5s|%5s|%5d|%n", i++, 
					a.getHersteller(), a.getModell(), a.getBaujahr());
		}
	}
}
