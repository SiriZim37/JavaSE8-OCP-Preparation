package aufgaben.lambdas.v2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

class Sum implements IntOperation{
	public int execute(int x , int y ) {
		return x + y ;
	}
}

class Max implements IntOperation{	
	public int execute(int x , int y ) {
		return Math.max(x, y);
	}
}


public class LambdasTest {

	public static void main(String[] args) {
		
		System.out.println("*****A1 ");
		// #A1
		
		// Kann Summe bilden
		IntOperation op1 = new Sum();
		System.out.println( op1.execute(2, 3)); // 5
				
		// hier eine Lambda zum Bilden der Summe
		IntOperation op2 = ( x , y ) -> x + y; 
		System.out.println(op2.execute(2, 3)); // 5
		
		// Kann den größeren Wert ermitteln
		IntOperation op3 = new Max(); 
		System.out.println( op3.execute(-6, 17) ); // 17
		
		// hier eine Lambda um den größeren Wert zu ermitteln
		IntOperation op4 = (x,y) -> Math.max(x, y); 
		System.out.println( op4.execute(-6, 17) ); // 17
		
		System.out.println("\n*****A2 ");
		//#A2
		
		ArrayList<String> strList = new ArrayList<>();
		strList.add("ABCDE");
		strList.add("aBcDfD");
		strList.add("baFG");
		strList.add("abc");
		strList.add("abcDefghij");	
		System.out.println("Original : " + strList);
		
		Comparator<String> cmp = ( s1 , s2 ) ->  Integer.compare(s1.length(), s2.length()); 
		Collections.sort(strList, cmp);
		System.out.println(strList);
		
		// Reverse 
		Comparator<String> cmp2 = ( s1 , s2 ) -> cmp.compare(s2, s1) ; 
		Collections.sort(strList, cmp2);
		System.out.println(strList.toString());
		
		
		System.out.println("\n*****A3 ");
		// #A3
		Random rnd = new Random();
		List<Integer> list1 = new ArrayList<>();
		list1.add(rnd.nextInt(20)+(-10));
		list1.add(rnd.nextInt(20)+(-10));
		list1.add(rnd.nextInt(20)+(-10));
		
		System.out.println("list1 : " + list1);
		
		List<Integer> list2 = new ArrayList<>();
		list2.add(rnd.nextInt(20)+(-10));
		list2.add(rnd.nextInt(20)+(-10));
		list2.add(rnd.nextInt(20)+(-10));
		System.out.println("list2 : " + list2);
		
		ListCombiner combiner = ( n1 , n2 ) -> {
			List<Integer> list = new ArrayList<>();
			list.addAll(n1);
			list.addAll(n2);
			return list;
		};
		List<Integer> list3 = combiner.combine(list1, list2);
		//list3 hat alle Elemente aus list1 und list2
		System.out.println("list3 : " + list3);

		System.out.println("\n*****A4 ");
		//#A4		
		List<CPU>  cpus = Arrays.asList( 
							new CPU(8, "Intel"),
							new CPU(12, "Apple"),
							new CPU(16, "ARM"),
							new CPU(4, "Qualcomm"),
							new CPU(6, "AMD") 
						  ) ; 
		System.out.println("4.1. ");
		for (CPU cpu : cpus) {
			System.out.println(cpu);
		}
		
		System.out.println("\n4.2. Consumer mit forEach: ");
		
//		cpus.forEach(consumer); // cf : Es kann nicht kompiliert weil jeder Elemente muss seine Parameter haben. (CPU cpu)
		
		Consumer<CPU> consumer = cpu -> {
			System.out.println( cpu.getHersteller() + ":"+ cpu.getAnzahlKerne() );
		};
		cpus.forEach(consumer);
		
		System.out.println("\n4.3. Lambda Expression direkt in forEach");
		
		cpus.forEach(cpu -> System.out.println( cpu.getHersteller() + ":"+ cpu.getAnzahlKerne() ));
		
	}

}
