package aufgaben.a2;

import java.util.function.Predicate;

public class TestGenericsPlatzhaltenFunctional {

	public static void main(String[] args) {
		
		Predicate<Number> istPositiv = n -> n.doubleValue() > 0;
		Predicate<Integer> istGerade = x -> x%2==0;
		Predicate<String> istLeer = s -> s.isEmpty();
		
		Predicate<Number> p0;
		
		p0 = istPositiv; 	// muss kompilieren			
//		p0 = istGerade; 	// darf nicht kompilieren	
//		p0 = istLeer; 		// darf nicht kompilieren	
		
		p0.test(22); 		// muss kompilieren				
		
		Predicate<? super Integer> p1;
		
		p1 = istPositiv; 	// muss kompilieren			
		p1 = istGerade; 	// muss kompilieren		// Number ist a super class von Integer
//		p1 = istLeer; 		// darf nicht kompilieren  
		
		p1.test(22); 		// muss kompilieren
		
		Predicate<? extends Number> p2;

		p2 = istPositiv; 	// muss kompilieren
		p2 = istGerade; 	// muss kompilieren
//		p2 = istLeer; 		// darf nicht kompilieren
		
//		p2.test(22); 		// darf nicht kompilieren  

		
		Predicate<Double> pDub = (Double d) -> true;
		
		p2 = pDub;
	}

}
