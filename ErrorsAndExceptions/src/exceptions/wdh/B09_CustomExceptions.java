package exceptions.wdh;

class MyExceptionA {} // <- kein Exception-Klasse!

class MyExceptionB extends RuntimeException {}	// unchecked Exception

class MyExceptionC extends Exception {} // checked Exception

class MyExceptionD extends MyExceptionC {} 

public class B09_CustomExceptions {


	

	public static void main(String[] args) {

		
		if(args == null) {
			throw new MyExceptionB() ; // unchecked
		}
		
//		throw new MyExceptionC(); 	//  cf : unbeachtete checked Exception
		
	}

	/*
	 * MyExceptionA ist keine Exception
	 */
	static void ma() // throws MyExceptionA  // 1. cf :
	{
//		throw new MyExceptionA(); // 2. cf 
		
//		try {
//			
//		} catch (MyExceptionA e) {	// 3. cf 
//
//		}
		
	}
	
	static void ma2()  throws MyExceptionC  // 
	{
		
//		try {
//			throw new Exception("");
//		}catch (MyExceptionC e) {	
//
//		}catch (MyExceptionD e) { // Unreachable catch block for MyExceptionD. It is already handled by the catch block for MyExceptionC
//			
//		}
	
	}
	
	static void ma3()  throws Exception
	{
	
		try {
			throw new Exception();
		}catch (MyExceptionD e) {	

		}

	
	}
}
