package oca;

import java.util.ArrayList;
import java.util.List;

public class ExceptionErrorArayTest {

	public static void main(String[] args) {
		
		//************ 1. 
		List<Integer> list = new ArrayList<>();
		try {
			
			while (true) {
				list.add(10);
			}
			
		} catch (RuntimeException e) {
			System.out.println("RuntimeException " + e.getMessage());
		}catch (Exception e) {
			System.out.println("Exception " + e.getMessage());
		}catch (Error e) {
			System.out.println("Error " + e.getMessage());		//*** Error Java heap space ***//
		}
		catch (Throwable e) {
			System.out.println("Throwable " + e.getMessage());
		}
		finally {
			System.out.println("finally");
		}
		System.out.println("end");

		
		//************ 2.
		
		try {
			recursiveMethod(); //*** java.lang.StackOverflowError ***/
			
		} catch (StackOverflowError e) {
			System.out.println( e);	
		}
	}
	public static void recursiveMethod() {
		recursiveMethod();
	}
}
