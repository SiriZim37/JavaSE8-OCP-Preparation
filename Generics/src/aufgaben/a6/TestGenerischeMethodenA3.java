package aufgaben.a6;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TestGenerischeMethodenA3 {

	public static void main(String[] args) {
		Integer sum ;
		// ###### A3. sum
		Collection<Integer> collInt =  Arrays.asList(1, 2, 3, 4, 5);
		sum = sum(collInt);
		System.out.println(sum); 
		
		Collection<Number> collNum =  Arrays.asList(1, 2, 3, 4, 5);
		sum= sum(collNum);
		System.out.println(sum); 
		
		
		List<Integer> ListA =  Arrays.asList(1, 2, 3, 4, 5);
		Integer intSum = sum(collInt);
		System.out.println(intSum); 
		
		List<Number> ListB =  Arrays.asList(1, 2, 3, 4, 5);
		Number numSum = sum(collNum);
		System.out.println(numSum); 
		
		List<Short> listC =  Arrays.asList((short)1, (short)2, (short)3);
		sum(listC);

	}
	
	
	// ###### A3. sum
//	static <T extends Number> Integer sum(Collection<T> zahlen) {
//	    int sum = 0;
//	    
//	    for (T zahl : zahlen) {
//	        sum += zahl.intValue();	// Datenverlust möglich
//	    }
//	    
//	    return sum;
//	}
	
	
	static  Integer sum(Collection<? extends Number> zahlen) {
	    int sum = 0;
	    
	    for (Number zahl : zahlen) {
	        sum += zahl.intValue();	// Datenverlust möglich
	    }
	    
	    return sum;
	}
	
	/*Noch nicht generic Methode*/
	static  Integer sumInt(Collection<? extends Number> zahlen) {
	    int sum = 0;
	    
	    for (Number zahl : zahlen) {
	        sum += zahl.intValue();	// Datenverlust möglich
	    }
	    
	    return sum;
	}
}
