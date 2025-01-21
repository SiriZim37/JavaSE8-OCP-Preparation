package streams.wdh;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class B20_terminal_collect_v2 {

	/*
	 *  <R, A> R collect(Collector<? super T, A, R> collector);
	 */
	public static void main(String[] args) {
	
		Integer[] array = { 1,2,3,4,5};
		
		/*
		 * Aufgabe : Integer aus dem Array in einer List speichern
		 */
		
		/*
		 * für die collect-Version wird der Collector gesucht der
		 * folgende Logiken hat:
		 * 
		 * 	supplier (Erzeuden vom Zielcontainer)
		 *  accumulator (Speichern der Elemente im Zielcontainer)
		 *  combiner (Daten aus derm 2. Zielcontainer im 1. Zielcontainer speichern)
		 */
		 
		System.out.println("Bsp.1 ");
	
		Collector<Integer, ?, List<Integer>> c1 = Collectors.toList(); 
		
		List<Integer> list =  Arrays.stream(array)
					.collect(c1);
		System.out.println("list : " + list);
	}


	
}
