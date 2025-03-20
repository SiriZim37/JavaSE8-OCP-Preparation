package aufgaben.calculation;

import java.util.Scanner;

public class Taschenrechner {

	private final TaschenrechnerViewModel viewModel  = new TaschenrechnerViewModel();
	private final Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {
	
		new Taschenrechner().run();
		
	}
	
	public void run() {

		System.out.println("Willkommen zum Taschenrechner!");
		while(true) {
			String operator = viewModel.getOperation(scanner);
			
			if(operator.equalsIgnoreCase("q")) {
				System.out.println("Programm wird beendet...");
				break;
			}
			// define classes
			viewModel.setOpertaion(operator);

			// start to collect all operands
		    double[] operands =	viewModel.collectOperator(scanner , operator);

		    // execute through Polymorphism
		    double result =  viewModel.executeOperation(operands);
				
		    showResult(operator , result , operands);
			
			if(!isContinue()) {
				break;
			}
		}
	}
	

	private  void showResult(String operator , double result , double... values) {
		try {
			if(operator.equals("!")) {
				 System.out.println("Ergebnis der Fakultät ( "+ values[0]   + " )" + " = " + (int)result);
			}else {
				System.out.println("Ergebnis: " + values[0] + " " + operator + " " + values[1] + " = " + result);
			}
			
		 }catch (ArithmeticException e) {
             System.out.println("Fehler: " + e.getMessage());
         }
	}
	
	private  boolean isContinue() {
		while(true) {
			
			System.out.println("Geben Sie bitte  'q' oder 'Q' zum Beenden oder 'n' oder 'N' zum Fortfahren");    
			String input = scanner.next(); 
	    	if(input.equalsIgnoreCase("q")) {
	    		System.out.println("Programm wird beendet...");
	    		return false;
	    	}else if(input.equalsIgnoreCase("n")) {
	    		return true;
	    	}
		}

	}
	
}
