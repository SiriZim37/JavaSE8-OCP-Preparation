package func.aufgaben.consumers;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TestConsumerPutInteger {

	public static void main(String[] args) {
		
		// Lambdas 
		System.out.println("***Lambdas");
		StringBuilder sb = new StringBuilder();
		putIntegers( i -> sb.append(i).append(" ") );   // return void
		System.out.println(sb); 	// Zeile A
	     
	     	
		List<Integer> list = new ArrayList<>();
		putIntegers( i -> list.add(i) );		// return void
		System.out.println(list); // Zeile B

		
		putIntegers( System.out::print ); 	// Zeile C, optionale Aufgabe, 
											// die Zeile C kann entfernt werden
		
	
	}
	
	static void putIntegers(Consumer<Integer> consumer) {
		for(int i = 1 ; i<= 4 ; i ++) {
			consumer.accept(i);
		}
	}

}
