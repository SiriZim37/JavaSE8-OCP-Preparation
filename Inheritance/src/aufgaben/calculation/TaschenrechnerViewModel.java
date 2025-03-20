package aufgaben.calculation;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TaschenrechnerViewModel {
	
	private Operation operation;
	
	public void setOpertaion(String operator) {
		switch(operator) {
			case "+" : 
				this.operation = new Addition();
				break;
			case "-" : 
				this.operation = new Subtraction();
				break;
			case "/" :
				this.operation = new Division();
				break;
			case "*" : 
				this.operation = new Multiplication();
				break;
			case "!" :
				this.operation = new Factorial();
				break;
			default:
				throw new IllegalArgumentException("Invalid operation ." + operator);
		}
	}
	
	
	public String getOperation(Scanner scanner) {
		while(true) {
			System.out.println("Bitte wählen Sie eine Operation. Wenn Sie das Programm beenden möchten, geben Sie bitte 'q' oder 'Q' ein :");
			System.out.println("+ : Addition");
			System.out.println("- : Subtraktion");
			System.out.println("* : Multiplikation");
			System.out.println("/ : Division");
			System.out.println("^ : Power");
			System.out.println("! : Fakultät");
			
			 String operator = scanner.next();
			 
			if(operator.equalsIgnoreCase("q")|| isOperator(operator)  ) {
				return operator;
			}else {
				 System.out.println("\nUngültige Eingabe. Bitte wählen Sie eine der angegebenen Optionen (+, -, *, /, !, ^) oder 'q' oder 'n'.");
			} 
		}
	}
	


	
	
	public static boolean isOperator(String s ) {
	    	switch (s) {
	        case "+": case "-": case "*":case "/": case "^": case "!":
	        	return true;
	        default:
	            return false;
	    	}
	}
	
	
	public double[] collectOperator(Scanner scan ,  String opearator) {
		
		if(opearator.equals("!")) {
			int num  =  (int) getOperand(scan ,  true );
			return new double[] {num};
		}else {
			double num1  =  getOperand(scan ,  false );		
			double num2  =  getOperand(scan ,  false );
			while(true) {
				if(opearator.equals("/") && num2 == 0 ) {
					System.out.println("Fehler: Division durch 0.");
					num2 = getOperand(scan ,  false );
				}else
					break;
				
			}
			return new double[] {num1 ,num2};
		}
	}
	
	public double getOperand(Scanner scan , boolean isFactorial ) {
		
		while (true) {
			if(isFactorial)
				System.out.println("Bitte geben Sie den Operanden für die Fakultät ein:"); 
		    else  
			    System.out.println("Bitte geben Sie die Zahl ein:");

			try {
				
				return scan.nextInt();   
				
	        } catch (InputMismatchException e) {
	            System.out.println("Ungültige Eingabe! Bitte geben Sie die Zahl ein");
	            scan.next();  // Clear invalid input from scanner
	        }	
		}
	}
	
	public double executeOperation(double... values) {
		if(operation == null) {
			 throw new IllegalStateException("Operation not set");
		}
		return operation.execute(values);
	}
	
}
