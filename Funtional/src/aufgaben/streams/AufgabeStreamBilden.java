package aufgaben.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class AufgabeStreamBilden {

	public static void main(String[] args) {

		a1();
		a2();
		a3();
		a4();
		a5_1();
		a5_2();
		a5_3();
	}
	
	static void a1() {
		System.out.println("*** A1.");
		List<Integer> list1 = Arrays.asList( 1, 2, 3 );
		List<Integer> list2 = Arrays.asList( 55, 77 );
		
		// A
		List<List<Integer>> list3 = Arrays.asList(list1, list2);
		for(List<Integer> e : list3) {
		    System.out.println("size = " + e.size() + ". elements = " + e);
		}
		
		System.out.println("B1. Stream");
		//B 
		list3.stream().forEach(e -> System.out.println("size = " + e.size() + ". elements = " + e));
		
		split();
	}


	static void a2() {

		System.out.println("\n*** A2. Stream limit");
		
		Stream.generate(Test::nextInt).limit(99).forEach(System.out::println);
		
		split();
	}
	
	static void a3() {
		System.out.println("\n*** A3. ");
		for (int i = 100; i >= 1; i--) {
		    System.out.println( i );
		}
		
		System.out.println("\nB3. Stream.iterate");
		
		UnaryOperator<Integer> unaryOperator = i -> i - 1; 
		Stream.iterate(100, unaryOperator).limit(100).forEach(System.out::println);   
	
		split();
	}
	
	static void a4() {
		System.out.println("\n*** A4.");
		
		String[] a1 = { "a", "b" };
	    String[] a2 = { "c", "d" };
	    
	    // A
	    String[][] a3 = { a1, a2 };
	    for (String[] arr : a3) {
	        for (String s : arr) {
	            System.out.println(s);
	        }
	    }
	    
	    System.out.println("\nB4. Stream.concat");
		
		// B Stream
		Stream.concat(Arrays.stream(a1), Arrays.stream(a2)).forEach(System.out::println); 
		
		split();
	}
	
	static void a5_1() {
		//Variante 1 
		System.out.println("\n*** A5.1 ");
		//A
		Collection<String> coll = new ArrayList<>();
		coll.add("/a");
		coll.add("/a/b");
		coll.add("/a/b/c");
		coll.add("/a/b/c/d");
		for(String s : coll) {
			System.out.println(s);
		}
		
		System.out.println("\nB5. Stream aus dem Collection");
		// B
		coll.stream().forEach(System.out::println);
		
		split();
	}
	
	static void a5_2() {
		//Variante 1 
		System.out.println("\n*** A5.2 ");
		//A
		Collection<String> coll = new ArrayList<>();
		coll.add("/a");
		coll.add("/a/b");
		coll.add("/a/b/c");
		coll.add("/a/b/c/d");
		for(String s : coll) {
			System.out.println(s);
		}
		
		System.out.println("\nB5. Stream mit 'of'");
		// B
		Stream.of("/a","/a/b","/a/b/c","/a/b/c/d").forEach(System.out::println);

		split();
	}
	
	static void a5_3() {
		//Variante 3 
		System.out.println("\n*** A5.3 ");
		//A
		Collection<String> coll = new ArrayList<>();
		coll.add("/a");
		coll.add("/a/b");
		coll.add("/a/b/c");
		coll.add("/a/b/c/d");
		for(String s : coll) {
			System.out.println(s);
		}
		
		System.out.println("\nB5. Stream mit iterate (UnaryOperator)");
	
		// B
		UnaryOperator<String> op = s -> {
			int nextChar = s.charAt(s.length()-1)+1;
			return s + "/" + (char)nextChar;
		};
		Stream.iterate("/a", op).limit(4).forEach(System.out::println);
		
		split();
	}
	
	static void split() {
		System.out.println("-----------------------------------------------------------");
	}
}
