package aufgaben.lambdas;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Predicate;

public class LamdasUnPredicateTest {

	public static void main(String[] args) {

		
//		Predicate<String> stringTester = s -> s.length() > 3;
//		boolean laengerAlsDreiZeichen = stringTester.test("Hallo Welt"); // true
//		System.out.println(laengerAlsDreiZeichen);
		
		Random rnd = new Random(); 
		
		Integer[] arryInteger = new Integer[10];
		int min = -20 ;
		int max = 20 ;
		
		for(int i = 0 ; i < 10 ; i++) {
			arryInteger[i] =  rnd.nextInt(max-min+1)+min ;
		}
		
		Arrays.sort(arryInteger);
		
		System.out.print("10 Zahle : ");
		for( Integer v  : arryInteger) {
			System.out.print(" " +  v  ) ;
		}
		System.out.println();
		
		Predicate<Integer> positivePred = n -> n > 0   ;  // positive Wert 
		Predicate<Integer> negativePred = n -> n < 0   ;  // negative Wert
		Predicate<Integer> evenPred = n -> n%2 == 0 ;  //  gerade Zahl ( even num )
		Predicate<Integer> oddPred = n -> n%2 != 0 ;  //  ungerade Zahl ( odd num )
		Predicate<Integer> evenPositivPred = n -> n%2==0 && n > 0  ;  // gerade Zahl +   positive Wert
		
		// printIf( arryInteger , n -> n > 0  ) ; // ok
	
		
		System.out.print("1. Positive Werte :");
		printIf(arryInteger ,  positivePred );
		System.out.print("2. Negative Werte :");
		printIf(arryInteger ,  negativePred );
		System.out.print("3. Gerade Werte :");
		printIf(arryInteger ,  evenPred );
		System.out.print("4. Ungerade Werte :");
		printIf(arryInteger ,  oddPred );
		System.out.print("4. Gerade &  positive Werte :");
		printIf(arryInteger ,  evenPositivPred );
		
		
		

	}

	private static void printIf(Integer[]  array , Predicate<Integer> pred) {
		for( Integer v  : array) {
			 if (pred.test(v)) 
				 System.out.print(" " +  v  ) ;
		}
		System.out.println();
	}
	

}
