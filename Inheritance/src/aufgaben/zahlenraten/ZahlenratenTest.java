package aufgaben.zahlenraten;

import java.util.Random;

public class ZahlenratenTest {

	public static void main(String[] args) {
		// A1
		Random random = new Random();
		int x = random.nextInt(10) + 1;
		System.out.println("x = " + x);
		
		// A2
		IntOperation op1 = new Multiply(2);
	    int result1 = op1.execute(x); // result1 ist 2 * x
	    System.out.println("result1 = " + result1);
	    
	    // A3
	    IntOperation op2 = new Multiply(5);
	    int result2 = op2.execute(result1);
	    System.out.println("result2 = " + result2);
	    
	    // A4
	    IntOperation op3 = new Divide(x);
	    int result3 = op3.execute(result2);
	    System.out.println("result3 = " + result3);
	    
	    // A5
	    IntOperation op4 = new Subtract(7);
	    int result4 = op4.execute(result3);
	    System.out.println("result4 = " + result4);
	    
	    // A7
	    IntOperation[] ops = {
	    	    new Add(5), // addiert 5
	    	    new ChangeSign(), // ändert das Vorzeichen
	    	    new Multiply(2), // mit 2 multiplizieren
	    	    new Subtract(3)  // 3 subtrahieren
	    	};
	    
	    x = 2;

	    System.out.println("vorher: x = " + x);
	    
	    for(IntOperation op : ops) {
	    	x = op.execute(x);
	    }
	    
	    System.out.println("nachher: x = " + x);
	    
	    // A8
	    IntOperation op = new Add(5)
				.andThen( new ChangeSign() )
				.andThen( new Multiply(2) )
				.andThen( new Subtract(3) );

		int result8 = op.execute(2); // result ist -17
		
		System.out.println("result8 = " + result8);
	    
	    
	}

}
