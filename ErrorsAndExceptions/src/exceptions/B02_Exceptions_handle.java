package exceptions;

import java.util.InputMismatchException;
import java.util.Scanner;

public class B02_Exceptions_handle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String temp = null; 
		System.out.println("Bitte geben zwei Zahlen ein : ");
		try {
			int a = scanner.nextInt();
			int b = scanner.nextInt(); // Throws:InputMismatchException - if the next token does not match the Integerregular expression, or is out of range
			scanner.close();
	//		int quotient  = divideWithhandle(a,b) ; 
			int quotient  = divide(a,b) ;
			System.out.println("quotient = " + quotient);
			// Der finally-Block wird nicht ausgeführt , wenn die JVM dursch System.exit(0); gestoppt wird.
			if(Math.random() >= 0.5) {
				System.exit(0);
				/*
				 *  wenn if -> true wird JVM gestoppt 
				 *  Ausgabe :   Bitte geben zwei Zahlen ein : 
				 *				7 2 
				 *				quotient = 3
				 */
			}
			
			System.out.println("Länge von temp = " + temp.length()); // java.lang.NullPointerException
		//}catch (Exception e) {
		//	e.printStackTrace();

			
		// Reihfolge der catch-Blöcke beachten. Von Sub.Exception zu Exception
		}catch (InputMismatchException  e) {	
			System.out.println("Bitte zwei Zahlen und nichts anders ");
		}catch (ArithmeticException e) {
			System.out.println("Arithmetisches problem! Bitte keine 0 als Divisor eingeben!");
		}
		catch (Exception e) {  // Unreachable catch block for InputMismatchException. It is already handled by the catch block for Exception
			e.printStackTrace();
			System.out.println("Allegeminer Fehler an Adress 0xAF468..."); 
		}		 
		finally {
			System.out.println("fianlly wird immer ausgefüht , egal ob Exception auftritt oder nicht");
			// auch im finall-Block kann eine Exception auftreten. Wenn diese nicht behandelt wird , wird an der Stelle abgebrochen.
			if(Math.random() >= 0.5) {
				throw new RuntimeException();
			}
			scanner.close();
		}
		
	
		/* Wenn es mehr als catch block for Exception Es wird nicht compliliert zb 
		*  ArithmeticException then  Exception  then InputMismatchException   
		*    // cf  :  Unreachable catch block for InputMismatchException. It is already handled by the catch block for Exception
		*    
		* , dann muss sortiert
		*		1 ArithmeticException
		*		2 InputMismatchException
		*		3 Exception
		*/
		// wenn man genau wissen 
	
		System.out.println("Servus");
		
	}

	public static  int divideWithhandle(int a , int b ) {
		try {
			return a / b ;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return 0 ;
	}
	
	public static  int divide(int a , int b ) {
		return a / b ;
	}
	
}
