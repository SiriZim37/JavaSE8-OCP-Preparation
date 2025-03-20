package exceptions.wdh;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import javax.sound.midi.Patch;

public class B04_einigeStandardExceptions {

	public static void main(String[] args) {
		/*
		 * ------------------------------------------
		 * 	Exceptions, die Java-Operatoren werfen : 
		 * ------------------------------------------
		 * Die sind RuntimeException
		 */

		/*
		 * NullPointerException
		 */
		try {
			String s = null; 
			
			System.out.println(s.toUpperCase());
		}catch (NullPointerException e) {
			System.out.println(e);
		}
		
		try {
			int[] a = null;; 
			System.out.println(a[2]);
		}catch (NullPointerException e) {
			System.out.println(e);
		}
		
		/*
		 * ClassCastException
		 */
		try {
			
			Object object = 12;
			String s2 = (String)object;
			
		} catch (ClassCastException e) {
			System.out.println(e);
		}

		/*
		 * ArrayIndexOutOfBoundsException
		 */
		try {
			int[] arr = { 1 , 2 };
			System.out.println(arr[2]);
			
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		}
		
		/*
		 * ArithmeticException
		 */
		try {
			System.out.println(5/0);
		} catch (ArithmeticException e) {
			System.out.println(e);
		}
		
		// Achtung! bei Gleitkomma(floating)-Ergebnis gibt es keine ArithmeticException
		System.out.println(5./0);	// Infinity
		System.out.println(5./0.0);	//Infinity
		
		/*
		 * ------------------------------------------
		 * 	Weitere Exception , die Methoden der Standardbivliothek
		 *  oder selbstdefinierte Methoden werfen können
		 * ------------------------------------------
		 * 
		 */
		
		
		/*
		 * IllegalArgumentException
		 */
		try {
			Scanner sc = new Scanner(System.in);
			sc.close();
			sc.next();
		} catch (Exception e) {
			System.out.println(e); // IllegalStateException: Scanner closed
		}
		
		try {
			Thread t = new Thread();
			t.setPriority(11); // Wirft IllegalArgumentException, da der Wert außerhalb des gültigen Bereichs 1-10 liegt
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		}
		
		
		
		/*
		 * NumberFormatException (extends IllegealArgumentException)
		 */
		try {
			String text = "abc";
			int number = Integer.parseInt(text); // Wirft NumberFormatException
		} catch (NumberFormatException e) {
			System.out.println(e);	// NumberFormatException: For input string: "abc"
		}
		
		try {
			Integer.valueOf("moin");
		} catch (NumberFormatException e) {
			System.out.println(e);	// NumberFormatException: For input string: "moin"
		}
		
		
		/*
		 * UnsupportedOperationException
		 */
		try {
			List<String> list = Arrays.asList("A", "B", "C");
			list.add("D"); // Wirft UnsupportedOperationException
		} catch (UnsupportedOperationException e) {
			System.out.println(e);
		}
		
	

		/*
		 * nicht alle parsenden Methode werfen eine IllegalArgumentException
		 */
		try {
			LocalDate date = LocalDate.parse("moin");
		} catch (Exception e) {
			System.out.println("Exception beim Parsen "+e);

		}
		
		try {
			throw new IOException();	// checked Exception (Check Exceptions selbst)
		} catch (IOException e) {
			System.out.println("IOException");
		}
		
		
	}

}
