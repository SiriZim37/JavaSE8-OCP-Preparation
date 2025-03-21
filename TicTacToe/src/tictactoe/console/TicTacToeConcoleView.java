package tictactoe.console;

import tictactoe.TicTacToe;
import tictactoe.TicTacToeSign;

public class TicTacToeConcoleView {
	private static char getDisplaySign(TicTacToeSign sign) {
		switch(sign) {
			case NONE: return ' '; 
			case PLAYER: return 'X'; 
			case AI: return 'O'; 
		}
		
		throw new IllegalAccessError("unsupported sign: " + sign);
	}
	
	/*
		Spielfeld	Positionsnummer
		
		|O| |X|		|1|2|3|
		| |X| |		|4|5|6|
		|O| | |		|7|8|9|
				
	 */
	public static void printGame(TicTacToe game) {
		
		System.out.println("Spielfeld Positionsnummer");
		
		int positionIndex = 1;
		
		for (int row = 0; row < game.getDim(); row++) {
			
			// Spielfeld
			for (int col = 0; col < game.getDim(); col++) {
				TicTacToeSign sign = game.getSign(row, col);
				char viewChar = getDisplaySign(sign);
				System.out.print("|" + viewChar);
			}
			System.out.print("|");
			
			System.out.print("   ");
			
			// Positionsnummer
			for (int col = 0; col < game.getDim(); col++) {
				System.out.print("|" + positionIndex++ );
			}
			
			System.out.println("|");
		}
	}
	
	public static void printPrompt() {
		System.out.println("Sie sind am Zug. Bitte die Position eingeben: ");		
	}
	
	public static void printResult(TicTacToe game) {
		System.out.println(game);		
	}
	public static void printError(String error) {
		System.out.println(error);		
	}
}
