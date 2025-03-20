package ocpexam;


interface IntegerBox {
    int apply(int x, int y);
}


public class InterfaceLambda {

	public static void main(String[] args) {
		
		
		  IntegerBox box1 = (x, y) -> x + y;
//	      IntegerBox box2 = (x) -> x * 2;		// cf 
	      
		  
	      
	        /*
			What is the key difference between the two lambda expressions in the code?
	
			Options: a) The first lambda expression (x, y) -> x + y adds two integers, while the second one (x) -> x * 2 multiplies a single integer by 2.
	
			b) The first lambda expression takes two parameters, while the second expression takes one.
	
			c) Both lambda expressions are functionally identical.
	
			d) The second lambda expression will throw an error because it requires two parameters, but only one is provided.
	
			Correct Answer: b) The first lambda expression takes two parameters, while the second expression takes one.

	         */
	}
}
