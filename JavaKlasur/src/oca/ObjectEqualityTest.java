package oca;

public class ObjectEqualityTest {

	public static void main(String[] args) {
		  Integer x = new Integer(10);
	      Integer y = new Integer(10);
	      System.out.println(x == y);				// false
	      System.out.println(x.equals(y));			// true
	      
	      
	      Integer x2 = new Integer(10);
	      Integer y2 = 10;
	      System.out.println(x2 == y2);				// false	
	      System.out.println(x2.equals(y2));		// true	
	      
	      Long x3 = 128l;
	      Long y3 = 128l;
	      System.out.println(x3 == y3);				// false	
	      System.out.println(x3.equals(y3));		// true	
	      
	      
	      Long x4 = 127l;
	      Long y4 = 127l;
	      System.out.println(x4 == y4);				// true	
	      System.out.println(x4.equals(y4));		// true	
	}

}
