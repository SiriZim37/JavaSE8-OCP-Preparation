package exceptions;

import java.sql.SQLException;

import javax.management.RuntimeErrorException;

public class B05_Exeptions_Extends {

	
	/*	try {
    		// Code, der eine Ausnahme auslösen kann
		} catch (ExceptionType1 e1) {
		    // Behandeln von ExceptionType1
		} catch (ExceptionType2 e2) {
		    // Behandeln von ExceptionType2
		} finally {
		    // Code, der immer ausgeführt wird, unabhängig davon, ob eine Ausnahme aufgetreten ist oder nicht
		}
	 */
	public static void main(String[] args) { // throws MyException 
		
//		throw new MyException(); // cf : 1*  No exception of type MyException can be thrown; an exception type must be a subclass of Throwable
	
		// try-finally ohne cathch ist möglich. 
		// Szenario : im finally-Block werden nach Exception Ressource geschlossen
	
		/*try {
			System.out.println("testException");
			testException();  //  // Es muss behandelt oder declariet werden  : throws MyException 
			System.out.println("testRuntimeException");
			testRuntimeException();
		} finally { 
			System.out.println("Servus");
		}*/
		
		// Alternative 1
		try {
			System.out.println("testException");
			testException();  // cf :  // Es muss behandelt oder declariet werden  : throws MyException 
							 //  cf : 	Unhandled exception type SQLException
			System.out.println("testRuntimeException");
			testRuntimeException();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		} catch (MyException e) { // testException() muss behaldelt oder deklariert
			e.printStackTrace();
		} 
		
		System.out.println("\n------ Alternative 1 -------");
		// Alternative 2 
		
		try {
			System.out.println("testException");
			testException();  //  // Es muss behandelt oder declariet werden  : throws MyException 
			System.out.println("testRuntimeException");
			testRuntimeException();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		System.out.println("\n------ Alternative 2 -------");
		// Alternative 3
		try {
			System.out.println("testException");
			testException();  //  // Es muss behandelt oder declariet werden  : throws MyException 
			System.out.println("testRuntimeException");
			testRuntimeException();
		} catch (MyException e) {
			System.out.println("MyException wurde geworfen => checked");
		} catch (MyRuntimeException e) {
			System.out.println("MyRuntimeException wurde geworfen => unchecked");
			System.out.println(e); // e return ->exceptions.MyRuntimeException: MyRuntimeException
		}  catch (Exception e) { 
			e.printStackTrace();
		} 
		
		
		System.out.println("\n------ Alternative 3 -------");
		// Alternative 4
		// Man kann catch-block in einem catch-Block screiben 
		
		try {
			System.out.println("testException");
			testException();  //  // Es muss behandelt oder declariet werden  : throws MyException 
			System.out.println("testRuntimeException");
			testRuntimeException();
		} // Seit Java 7 
		catch (MyException | MyRuntimeException e) { 
			System.out.println(e);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		System.out.println("Servus");
	}
	
	public static void testException() throws MyException, SQLException {
		if(Math.random() >= 0.5) {
			throw new MyException("MyException"); // Unhandled exception type MyException
												  // Es muss behandelt oder declariet werden  : throws MyException 
		}
		if(Math.random() >=0.5) {
			throw new SQLException("DB-Fehler"); // Unhandled exception type SQLException
													// Es muss behandelt oder declariet werden  : throws SQLException 
		}
	}
	
	public static void testRuntimeException() {
		if(Math.random() >= 0.5) {
			throw new MyRuntimeException("MyRuntimeException");
			
		}
	
	}
}

//class MyException{   1*   No exception of type MyException can be thrown; an exception type must be a subclass of Throwable
//
//}


//Subclass von Exception , also  checked !!! 
class MyException extends Exception{
	
	MyException(String msg ) {
		super(msg);
	}
}

// Subclass von RuntimeException , also nicht checked!!! 
class MyRuntimeException extends RuntimeException{
	
	MyRuntimeException(String msg ) {
		super(msg);
	}
}