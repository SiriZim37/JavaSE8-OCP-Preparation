package func.aufgaben.lambdas;

import java.util.function.Consumer;

/*
 	interface Consumer<T> {
		void accept(T t);
	}
 */
public class TestLambdasConsumerA1 {

	public static void main(String[] args) {
		
		class C1 implements Consumer<Integer> {
			@Override
			public void accept(Integer t) {
				System.out.println(t);
			}
		}
	
		Consumer<Integer> c1 = new C1();
		c1.accept(12);	
		
		 // c2: Anonyme Klasse
		Consumer<Integer> c2 = new Consumer<Integer>() {
			public void accept(Integer n) {
				System.out.println(n);
			}
		};
		c2.accept(12);	
		
		// c3: Lambda ausführlich 
		Consumer<Integer> c3 = (Integer n) -> {
            System.out.println(n);
        };
		c3.accept(12);

		// c4: Lambda kompakt
		Consumer<Integer> c4 = n -> System.out.println(n);
		c4.accept(12);

	}

}
