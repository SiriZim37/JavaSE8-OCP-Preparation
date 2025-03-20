package aufgaben;

import javax.swing.JOptionPane;

public class ExceptionsDialog {

	public static void main(String[] args) {
		 
	   boolean validInput = false;
	   int number = 0;
	   while (!validInput) {
		     String eingabeInt = JOptionPane.showInputDialog(null, "Bitte eine Zahl eingeben:", "Zahleneingabe", JOptionPane.QUESTION_MESSAGE);
	         if (eingabeInt == null) {
	             JOptionPane.showMessageDialog(null, "Eingabe abgebrochen.", "Abbruch", JOptionPane.WARNING_MESSAGE);
	             break;
	         }
	         try{
	        	 //int number = (Integer)(Object)input;  // compiler ok but Exception : java.lang.ClassCastException            
	            
	        	 number = Integer.parseInt(eingabeInt);  // // Umwandung  parseInt
	        	 validInput = true;
	         } catch (NumberFormatException e) {	     
	        	 // Ausnahmebehandlung
	 	         JOptionPane.showMessageDialog(null, "Ungültige Eingabe. Bitte eine gültige Zahl eingeben.", "Fehler", JOptionPane.ERROR_MESSAGE);
	 	     }
	     }
	   
	   
	     JOptionPane.showMessageDialog(null, "Sie haben die Zahl " + number + " eingegeben.", "Eingabe erfolgreich", JOptionPane.INFORMATION_MESSAGE);
	        
	   
	}

}
