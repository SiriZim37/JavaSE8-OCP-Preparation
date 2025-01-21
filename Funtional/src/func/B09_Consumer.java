package func;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;

public class B09_Consumer {

	/*
	 * interface Consumer<T>{
	 * 		void accept(T param);
	 * }
	 */
	
	
	public static void main(String[] args) {
		
		// annonyme Klasse 
		Consumer<String> c1 = new Consumer<String>() {
			public void accept(String s) {
				System.out.print(s.toUpperCase()+" ");
			}
		};
		
		generateStrings(3 , c1);
		
		// Lamda ausfühlich 
		Consumer<String> c2 = (String s ) ->{
			System.out.print(s.toUpperCase()+" ");
		};
		
		generateStrings(3 , c2);
		
		// Lamda ausfühlich 
		Consumer<String> c3 = s -> 		System.out.print(s.toUpperCase()+" ");
		
		generateStrings(3 , c3);
		
		/*
		 * Bsp. aus der Standard Bibliothek
		 */
		
		List<Integer> list = Arrays.asList(1,2,3,4,5);
		Consumer<Integer> c4 = (Integer x) -> System.out.println(x);
		list.forEach(c4);
	}
	
	static void generateStrings(int count , Consumer<String> c) {
		Random r = new Random();
		for(int i = 0 ; i < count ; i++) {
			String s = String.valueOf(r.nextInt(10));
			c.accept(s);
		}
		System.out.println();
	}
	

}
