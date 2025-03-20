package aufgaben.lambdas.v2.solution;

import java.util.*;

interface ListCombiner {
	List<Integer> combine(List<Integer> list1, List<Integer> list2);   
}

public class AufgabeLambdasA3 {

	public static void main(String[] args) {
		List<Integer> list1 = new ArrayList<>();
		// 2-3 Integer zur list1 hinzufügen...
		list1.add(1);
		list1.add(2);
		list1.add(3);
		System.out.println("list1: " + list1);
		
		List<Integer> list2 = new ArrayList<>();
		// 2-3 Integer zur list2 hinzufügen...
		list2.add(40);
		list2.add(50);
		System.out.println("list2: " + list2);
		
		// hier die Lambda-Funktion
		ListCombiner combiner = (listA, listB) -> { 
			List<Integer> result = new ArrayList<>(listA);
			result.addAll(listB);
			return result;
		}; 
		
		List<Integer> list3 = combiner.combine(list1, list2);
		//list3 hat alle Elemente aus list1 und list2
		System.out.println("list3: " + list3);

		/*
		 * Klasse, die aus der Zeile mit Lambda gebildet werden kann:
		 * 
		 * class Blabla implements ListCombiner {
		 * 		public List<Integer> combine(List<Integer> listA, List<Integer> listB) {
		 * 			List<Integer> result = new ArrayList<>(listA);
		 * 			result.addAll(listB);
		 * 			return result;
		 * 		}
		 * }
		 */
	}

}
