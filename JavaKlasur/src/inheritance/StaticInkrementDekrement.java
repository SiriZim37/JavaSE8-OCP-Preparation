package inheritance;

import javax.management.RuntimeErrorException;

import org.w3c.dom.ranges.RangeException;

class InkrementClass {
	static int max = 5 ;
	static {
		max++;
	}
}
public class StaticInkrementDekrement {
	static int att = 5 ;
	
	public static void main(String[] args) {
		
		System.out.println(att);
		System.out.println(InkrementClass.max);
		
		InkrementClass i ; 
		i = new InkrementClass();
		
		System.out.println(++InkrementClass.max);
	
		
	}
	
	static {
		att--;
	}

}
