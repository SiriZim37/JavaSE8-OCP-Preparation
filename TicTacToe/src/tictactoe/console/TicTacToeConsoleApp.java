package tictactoe.console;

import java.util.InputMismatchException;
import java.util.Scanner;

import tictactoe.OutOfRangeException;
import tictactoe.Position;
import tictactoe.PositionOccupiedException;
import tictactoe.RandomTicTacTocAI;
import tictactoe.TicTacToe;
import tictactoe.TicTacToeAI;

public class TicTacToeConsoleApp {

	/*
	 * Modell: Klassen aus dem Package 'toctactoe' (TicTacToe, TicTacToeSign...)
	 * 
	 * Controller: TicTacToeConsoleApp
	 * View: TicTacToeConsoleView
	 */
	public static void main(String[] args) {

		TicTacToe game = new TicTacToe();
		TicTacToeAI gameAI = new RandomTicTacTocAI();
		
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		
		/*
		 * todo: Exeptions Handling
		 */
		while(true) {
			// Spiel-Zustand zeigen
			TicTacToeConcoleView.printGame(game);
			
			/*
			 *  Player-Eingabe lesen und seinen Zug im Modell übernehmen
			 *  
			 *  Möglichkeiten:
			 *  	- Benutzer gibt eine Zahl ein
			 *  		- die Zahl ist nicht zw. 1 bis 9		: Fehlermeldung 1, dann Vorgang wiederholen
			 *  		- die Zahl ist zw. 1 bis 9
			 *    			- Die Position ist frei				: OK
			 *  			- Die Position ist belegt			: Fehlermeldung 2, dann Vorgang wiederholen
			 *      - Benutzer gibt keine Zahl ein 				: Fehlermeldung 3, dann Vorgang wiederholen
			 */
			
			while(true) { // solange wiederholen, bis die Player-Eingabe OK ist.
				try {
					TicTacToeConcoleView.printPrompt();
					int positionIndex = sc.nextInt(); // kann InputMismatchException werfen
					
					if(positionIndex<1 || positionIndex>9) {
						throw new OutOfRangeException("Die Zahl muss im Bereich 1 bis 9 liegen!");
					}
					
					// aus der Zahl 1 bis 9 werden Koordinaten auf dem Spielfeld berechnet
					Position playerPos = Position.fromIndex(positionIndex);
					game.setPlayerSign(playerPos); // kann PositionOccupiedException werfen
			
					break; // Player-Eingabe war ok
					
				} catch (InputMismatchException e) {
					sc.nextLine(); // Input aus dem Console-Buffer entfernen
					TicTacToeConcoleView.printError("Es muss eine Zahl sein!"); 
				} catch (OutOfRangeException e) {
					System.out.println(e.getMessage());
				} catch (PositionOccupiedException e) {
					TicTacToeConcoleView.printError("Die Position ist bereits belegt!");
				}
			}
			
			// Spiel-Zustand überprüfen 
			// (Spiel beenden wenn es vorbei ist)
			if(game.isOver()) {
				break;
			}
			
			// KI-Zug erzwingen (und im Modell übernehmen)
			Position aiPos = gameAI.getNextPosition(game);
			game.setAISign(aiPos);
		
			// Spiel-Zustand überprüfen  
			// (Spiel beenden wenn es vorbei ist)
			if(game.isOver()) {
				break;
			}
		}

		TicTacToeConcoleView.printGame(game);
		TicTacToeConcoleView.printResult(game);
	}
	
}
