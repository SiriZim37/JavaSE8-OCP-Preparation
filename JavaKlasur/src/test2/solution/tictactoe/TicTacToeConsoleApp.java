package test2.solution.tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

import test2.solution.tictactoe.TicTacToeModel;
import test2.solution.tictactoe.TicTacToeSign;

public class TicTacToeConsoleApp {

	/*
	 * Modell: Klassen aus dem Package 'toctactoe' (TicTacToe und TicTacToeSign)
	 * 
	 * Controller und View: TicTacToeConsoleApp
	 */
	public static void main(String[] args) {

		TicTacToeModel game = new TicTacToeModel();
		RandomTicTacToeAI ai = new RandomTicTacToeAI();
		

		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		/*
		 * todo: Exeptions Handling
		 */
		
		while(true) {
			// Spiel-Zustand zeigen
			TicTacToeConsoleView.printGame(game);
			
			// Player-Eingabe lesen und seinen Zug im Modell übernehmen
			/*
			 * 	Möglichkeiten :
			 * 		1. Benutzer gibt eine Zahl ein
			 * 			- Die Zahl ist nicht zw. 1 bis 9 ein    : Fehlermeldung , dann Vorgang wiederholen
			 * 			- Die Position ist frei 			   
			 * 			- Die Position ist belegt 			    : Fehlermeldung , dann Vorgang wiederholen
			 * 		2. Benutzer gibt keine Zahl ein 		    : Fehlermeldung , dann Vorgang wiederholen
			 * 
			 */
			int positionIndex = -1;

				while(true) {
	                 try {
	                	TicTacToeConsoleView.printPrompt(game);
	                    positionIndex = sc.nextInt(); // liest die Zahl 1 bis 9 
	                    if(positionIndex < 1 || positionIndex > 9) {
	                    	throw new OutOfRangeException("Die Zahl muss im Bereich 1 bis 9 belegt.");
	                    }
	                     // aus der Zahl 1 bis 9 werden Koordinaten auf dem Spielfeld berechnet
	                     Position playerpos = Position.fromIndex(positionIndex);
	                     game.setPlayerSign(playerpos.row, playerpos.column); // kein PostionOccupiedException wefen
	                     break ;
	                    
	                 } catch (InputMismatchException e) {
	                     sc.nextLine(); // Clear invalid input    
	                      TicTacToeConsoleView.printError("Es muss eine Zahl ein.");
					 }catch (OutOfRangeException e) {
						 System.out.println(e.getMessage());
					 }catch (PostionOccupiedException  e) {
						 TicTacToeConsoleView.printError("Die Position ist bereits belegt!");
					 }
	            
	             }
	             
	         
                 
				 // Spiel-Zustand überprüfen 
				 // (Spiel beenden wenn Player gewonnen hat oder unetschieden)  
			     if(game.isOver()) {
	                	break;
	             }
			     
			     // KI-Zug erzwingen (und im Modell übernehmen)
			     Position aiPos = ai.getNextPostion(game);  // von TicTacToeAI
			     game.setAISign(aiPos.row, aiPos.column);
				
				 
			     // Spiel-Zustand überprüfen 
				 // (Spiel beenden wenn Player gewonnen hat oder unetschieden)  
			     if(game.isOver()) {
	                	break;
	             }
			   
			}
		
		
		  TicTacToeConsoleView.printGame(game);
		  TicTacToeConsoleView.printResult(game);
		  sc.close();
	}

	

	
}
