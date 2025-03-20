package ocpexam;

import java.util.function.Function;
import java.util.function.Supplier;

public class Immutable {

	
	public static void main(String[] args) {
		
		
		String text ="Test";
		String res1="";
		String res2="";
		
		Supplier<String> s1 = text::toUpperCase; 
		Supplier<String> s2 = text::toUpperCase; 
		s1.get();
		s2.get();
		System.out.println( res1 + "=" + res2);
		
		
				
	}
}
