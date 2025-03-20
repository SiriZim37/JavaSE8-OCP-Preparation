package test1;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultBoundedRangeModel;

class AXX1 {
	final int a = 7  ;
	public AXX1(int a) {
//		this.a = a;		// The final field AXX1.a cannot be assigned
	}
	
	{
		System.out.println(a);
	}
	 
}

interface InterfaceZ {
	public void name();
}

interface InterfaceY extends InterfaceZ{
	
}



abstract class ab111{
	protected int count;
	protected abstract  Object testAB();
}

abstract class ab112 extends ab111 {
	
	abstract  protected Object testAB(Object list);
}

class AAA3 extends AXX1{
	protected final int size;
	
	public AAA3(int a) {
		super(a);
		this.size = a;
		

	}


}

enum DaysTest {
	T1(1) , T2(2) , T3(3);
	 DaysTest(int n){}
}



class AAA1{
	
	public final String sAAA(int n) { return "AAA1" ; } 
}

class AAA2 extends AAA1{

	protected String sAAA() throws FileNotFoundException { return "AAA2" ; } 

}


public final class MyApp  extends AAA1 { // cf : ab111
	

	public  String sAAA() throws FileNotFoundException { return "AAA3" ; } 
//	public String testAB() { return "AAAMain" ; }  
	
	
	public static void swing(int...b)  {
		try {
			System.out.println("A" + b[2]);
		}finally {
			System.out.println("C");
		}
	}
	
	private boolean bn = true;

	  public static void main(String[] args) throws Exception  {
		  
		  swing(0,0);

		  
		  AAA3 aa31 = new AAA3(5);
//		  aa31.size = 10;	// cf 
		  AAA3 aa32 = new AAA3(6);
		  
		  final MyApp ma = new MyApp();
//		  System.out.println(ma.testAB());
		  
    	AXX1 axx1 = new AXX1(5);
    	System.out.println(axx1.a);
    	AXX1 axx2 = new AXX1(10);
    	System.out.println(axx2.a);
    	
   
    	final AAA1 a1 = new MyApp();
    	a1.sAAA(5);
    	 
    	List<Integer> list = new ArrayList<Integer>();
    	list.add(5);
    	
    	String o = "-";
    	
    	final int nn = 10;
    	final long ll = 5;
    	final byte bb = 5;
    	final short ss = 5;
    	
    	switch (bb) {
    	
		case ss:
			o += "short" ; 
//		case nn :
			o += "int " ; 
//		case ll:
//			o += "long" ; 
		default : 
			
    	}
    	System.out.println(o); // rg : 
    							// However, because there is no break after the "red" case, 
    							//it falls through to the "yellow" case, and o += "g"; is executed, 
    							// making o equal to "-rg".
    	
    	
    	DaysTest input = DaysTest.T1;
    	System.out.println(input.values());
    	switch (input) {
		case T1:
			
		case T2:
		default:
			break;
		}
    	
    	try {
			throw new ClassCastException();
		} catch (IllegalArgumentException e) {
			throw new IllegalArgumentException();
		}catch (RuntimeException e) {
			throw new NullPointerException();
		}
	  	finally {
			throw new RuntimeException();
		} 
	
    	

	  }
	  
	  
  	




}