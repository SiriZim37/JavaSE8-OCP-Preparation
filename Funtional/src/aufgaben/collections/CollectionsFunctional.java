package aufgaben.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.BaseStream;
import java.util.stream.Stream;

import javax.sound.midi.SysexMessage;


public class CollectionsFunctional {

	public static void main(String[] args) {
	
		/*-----------------------------------------------------------------------------------
		 *  #A1 Iterable#forEach(Consumer)
		 */
		System.out.println("***1. Iterable#forEach(Consumer)");
		
		List<Integer> intList = Arrays.asList(5,2,3,-6,-7,42,0,77,3);
		
		Iterable<Integer> it = intList;
		
		Consumer<Integer> consumer = t -> System.out.println(t);	// Alternativ 1 
		consumer = i -> System.out.println(i);						// Alternativ 2 
		consumer = System.out::println;								// Alternativ 3
		it.forEach(consumer);
		
		
		List<Integer> list = new ArrayList<Integer>(intList);
		System.out.println("vorher list: " + list);
		
		/* -----------------------------------------------------------------------------------
		 * #A2 Collection#removeIf(Predicate)
		 * 
		 *  vorher :  [5, 2, 3, -6, -7, 42, 0, 77, 3]
		 *  nacher :  [2, -6, 42, 0]
		 *
		 */
		
		// mit Schleife
//		for (Integer n : list) {
//			if(n%2 == 1) {
//				list.remove(n);		// cf : Exception : ConcurrentModificationException --> Es muss mit removeIf
//			}
//		}
			
		System.out.println("\n***2. Collection#removeIf(Predicate)");
		
		Predicate<Integer> pred = n -> n%2 != 0 ; // ungerade Werte : Alternativ 1
		list.removeIf(pred);
		System.out.println("Gerade Werte : " + list);
		
		list.removeIf(n -> n%2 == 1);			  // ungerade Werte : Alternativ 2 
		System.out.println("Gerade Werte : " + list);
		
		
		list = new ArrayList<Integer>(intList);
		
		/*-----------------------------------------------------------------------------------
		 * #A3 List#replaceAll(UnaryOperator)
		 * 
		 *  vorher :  [5, 2, 3, -6, -7, 42, 0, 77, 3]
		 *  nacher :  [0, 2, 0, -6, 0, 42, 0, 0, 0]
		 *
		 */
		
		System.out.println("\n***3. List#replaceAll(UnaryOperator)");
		
		UnaryOperator<Integer> u1 = (Integer n) -> n % 2 != 0 ? 0 : n;
		list.replaceAll(u1);
		
		System.out.println("Ungeraden Werte durch 0 : " + list);
		
		
		list = new ArrayList<Integer>(intList);
		
		/*-----------------------------------------------------------------------------------
		 * #A4 List#sort(Comparator)
		 * 
		 *  vorher :  [5, 2, 3, -6, -7, 42, 0, 77, 3]
		 *  nacher :  [77, 42, 5, 3, 3, 2, 0, -6, -7]
		 *  
		 */
		System.out.println("\n***4. List#sort(Comparator)");
		
		Comparator<Integer> cmp1 = new Comparator<Integer>() {  			// Alternativ 1
			public int compare(Integer n1, Integer n2) {
				return n2 - n1 ;
			}
		};
		
		Comparator<Integer> cmp2 = (Integer i1 , Integer i2 )-> {			 // Alternativ 2
			return i2 - i1;    
		};
		

		
		list.sort(cmp1);
		
		System.out.println("Anonyme Klasse   : " + list);
			
		Comparator<Integer> cmp4 = (n1 , n2) -> n2 - n1;
		list.sort(cmp4);
		System.out.println("Lambda-Funktion  : " + list);
		
		list.sort((a, b) -> b.compareTo(a));
		System.out.println("Lambda-Funktion : " + list);
		
		
//		list.sort(Comparator::reverseOrder);  // cf : Incorrect as a method reference in this case
		list.sort(Comparator.reverseOrder());
		
		/*?????????????
			Comparator<Integer> cmp3 = (i1 , i2 )-> Integer.compare(i2, i1);   	 // Alternativ 4
			
			class MyUtil {
				
				static int reverseOrder(Integer i1, Integer i2) {
					return Integer.compare(i2, i1);
				}
			}
			
			Comparator<Integer> cmp5 = MyUtil::reverseOrder;
			list.sort(cmp5);
		*/
		System.out.println("Methodenreferenz : " + list);
		

		
		
		/*-----------------------------------------------------------------------------------
		 * #A5 List#sort(Comparator)
		 * 
		 *  vorher :   1 2 null 4 5 null 7 8 
		 *
		 */
		
		System.out.println("\n***5. Collection#stream()");
		
														
		class SumConsumer implements Consumer<Integer>{		// Variante  1 über eigenen Consumer
			int summe = 0 ;
			@Override
			public void accept(Integer n) {
				if( n != null) {
					summe += n ;
				}
			}
		}
		SumConsumer sumCom = new SumConsumer();
		list.forEach(sumCom);
			
		System.out.println("\nsumme über eigenen Consumer  = " + sumCom.summe);
		
			
		int sum2 =   list.stream()							// Variante  2 mit Stream
	                .filter(n -> n != null) 
	                .mapToInt(x -> x)
	                .sum(); 
		
		System.out.println("\nSumme der nicht-null : " + sum2);
		
		
		List<Integer> list2 = Arrays.asList(1, 2, null, 4, 5, null, 7, 8);
		
		list2.forEach(e -> System.out.print(e + " "));
		
		/*
		 * interface Stream<T> extends BaseStream<T, Stream<T>>
		 */
		int sum = list2.stream()							// Variante  3 mit Stream
	                  .filter(n -> n != null) 
	                  .mapToInt(Integer::intValue)
	                  .sum();
		System.out.println("\nSumme der nicht-null mit Stream : " + sum);

	}


}
