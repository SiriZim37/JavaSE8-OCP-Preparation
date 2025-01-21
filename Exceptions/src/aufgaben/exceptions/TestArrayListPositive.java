package aufgaben.exceptions;

import java.util.Arrays;
import java.util.Scanner;

public class TestArrayListPositive {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		ArrayListPositive list = new ArrayListPositive();	
		
		// Test 
//		list.add(0); 
		list.add(null);
//		list.add(-5); 
	
//		list.add(0, 0); 
//		list.add(0, null); 
//		list.add(0, -5);
	
//		list.set(0, 0);
//		list.set(0, null);
//		list.set(0, -5);
		
//		list.addAll(Arrays.asList(0, null, -2));
//		list.addAll(Arrays.asList(null, 5, 10));
//		list.addAll(Arrays.asList(-1, null, -2));
//
//		list.addAll(0, Arrays.asList(0, -10));
//		list.addAll(0, Arrays.asList(null, -7));
//		list.addAll(0, Arrays.asList(-5, 5));
		
		
		
		try {
			ArrayListPositive list2 = new ArrayListPositive();	
		    Integer value = readUserInput(); 
		    System.out.println("Einagebe: " + value);
		    list2.add(value); 
		} catch (NullArgumentException e) {
		    System.out.println("Bitte geben Sie einen gültigen Wert ein (keine Null).");
		} catch (NotPostivieArgumentException e) {
		    System.out.println("Bitte geben Sie einen positiven Wert ein."); 
		}
		
		
		// Test Console 
		System.out.println();
		while (true) {
            System.out.print("Geben Sie bitte eine positive Zahl ein (oder 'x' zum Beenden): ");

            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("x")) { 
            	break; 
            }
            
            try {
            	Integer value = Integer.valueOf(input); 
                list.add(value); 
                System.out.println("Wert erfolgreich hinzugefügt: " + value);
            } catch (NullArgumentException e) {
                System.out.println("Bitte geben Sie einen gültigen Wert ein (keine Null).");
            } catch (NotPostivieArgumentException e) {
                System.out.println("Bitte geben Sie einen positiven Wert ein.");
            } catch (NumberFormatException e) {
                System.out.println("Ungültige Eingabe! Bitte geben Sie eine gültige Zahl ein.");
            }
        }

        scanner.close();
        System.out.println("Programm beendet.");
		
	}
	
	private static Integer readUserInput() {
	     return  0; 
	}

}
