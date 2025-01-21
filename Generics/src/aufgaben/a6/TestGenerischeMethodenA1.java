package aufgaben.a6;


import java.util.Date;
import java.util.Random;


public class TestGenerischeMethodenA1 {

	public static void main(String[] args) {
		
		// ###### A1. `getRandom`
		
		String s = getRandom("abc", "def"); 			// getRandom liefert zufällig entweder "abc" oder "def"
		System.out.println(s);
		
		Integer i = getRandom(14, 12);
		System.out.println(i); 							// entweder 14 oder 12
		
		Date d = getRandom(new Date(), new Date(0));  	// java.util.Date
		System.out.println(d);
		
		Object obj = getRandom("hallo", 22);    		// String und Integer sind Unterklassen von Object)
		System.out.println(obj); 						// entweder hallo oder 22
		
		//String erg = getRandom("hallo", 22); 			// hier soll ein Compilerfehler entstehen
	
		
	}
		
	static <T> T getRandom(T a, T  b){
		Random rnd = new Random();
		return rnd.nextBoolean()? a : b ;
	}
	
}
