package aufgabe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AufgabeTaschenrechner {

	public static void main(String[] args) {
		
		
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Willkommen zum Taschenrechner!");
		do {
			String operator;
			do {
			    System.out.println("Bitte wählen Sie eine Operation. Wenn Sie das Programm beenden möchten, geben Sie bitte 'q' oder 'Q' ein :");
			    System.out.println("+ : Addition");
			    System.out.println("- : Subtraktion");
			    System.out.println("* : Multiplikation");
			    System.out.println("/ : Division");
			    System.out.println("^ : Power");
			    System.out.println("! : Fakultät");
		       
			    operator = scanner.next();
			    if(isOperator(operator))
			    	break;
			}while(true);
		    
			
		    double ergebnis = 0;
		    if(operator.equalsIgnoreCase("q")) {
		    	System.out.println("Programm wird beendet...");
				break;
		    }else if(operator.equals("!")) {
		    	 // Fakultät berechnen
		     	 int operand;
		    	 while (true) {
		    	    System.out.println("Bitte geben Sie den Operanden für die Fakultät ein:");      
		            try {
		            	operand = scanner.nextInt();          
		                break; 
		            } catch (InputMismatchException e) {
		                System.out.println("Ungültige Eingabe! Bitte geben Sie eine Zahl ein");
		                scanner.next();  // Clear invalid input from scanner
		            }
		        }
		    	 
                ergebnis = berechneFakultaet(operand);                
                System.out.println("Ergebnis der Fakultät: " + ergebnis);
   	
		    }else {
		    	double zahl1;
		    	double zahl2;
		    	
		    	
		        while (true) {
		        	 System.out.println("Bitte geben Sie die erste Zahl ein:");
		            try {
		                zahl1 = scanner.nextDouble(); 
		                break; 
		            } catch (InputMismatchException e) {
		                System.out.println("Ungültige Eingabe! Bitte geben Sie eine Zahl ein");
		                scanner.next();  // Clear invalid input from scanner
		            }
		        }
		    	
		        while (true) {
		        	System.out.println("Bitte geben Sie die zweite Zahl ein:");
		            try {
					    zahl2 = scanner.nextDouble();	
		                break; 
		            } catch (InputMismatchException e) {
		                System.out.println("Ungültige Eingabe! Bitte geben Sie eine Zahl ein");
		                scanner.next();  // Clear invalid input from scanner
		            }
		        }		
		  	    
		        switch (operator) {
				case "+":
					ergebnis =  zahl1 + zahl2;
					break;
				case "-":
					ergebnis = zahl1 - zahl2;
					break;
				case "*":	
					ergebnis = zahl1 * zahl2;
					break;
				case "/":	
					 if (zahl2 == 0) {
	                     System.out.println("Fehler: Division durch 0.");
	                 }else {
	                	 ergebnis = zahl1 / zahl2;
	                 }
					 break;
				case "^":	
					ergebnis = Math.pow(zahl1, zahl2);
					break;
				default:
					System.out.println("Ungültige Eingabe. Bitte wählen Sie eine der angegebenen Optionen.");
					break;
				}
		        
		        System.out.println("Ergebnis: " + zahl1 + " " + operator + " " + zahl2 + " = " + ergebnis);
		    }
		    
		  
		    while(true) {		      		    	 
		    	System.out.println("Geben Sie bitte  'q' oder 'Q' zum Beenden oder 'n' oder 'N' zum Fortfahren");    
		    	operator = scanner.next(); 
		    	if(operator.equalsIgnoreCase("n") || operator.equalsIgnoreCase("q"))
		    		break;
		    }
	        
		    if(operator.equalsIgnoreCase("q")) {
				System.out.println("Programm wird beendet...");
				break;
			}
		    
		    
		}while(true);


	}

    
    // Recursive Methode zur Berechnung der Fakultät
    public static long berechneFakultaet(int n) {
		if(n<0) 
			return -1;  // negative Werte werden nicht akzeptieren.
				
		if(n==1||n==0)
			return 1;
    	
    	if (n == 0) {
            return 1;
        }

        return n * berechneFakultaet(n - 1);
    }
	
    static boolean isOperator(String s ) {
    	switch (s) {
        case "+": case "-": case "*":case "/": case "^": case "!":
        case "q": case "Q":
        	return true;
        default:
            System.out.println("Ungültige Eingabe. Bitte wählen Sie eine der angegebenen Optionen (+, -, *, /, !, ^) oder 'q' oder 'n'.");
            return false;
    	}
    }
    


}
