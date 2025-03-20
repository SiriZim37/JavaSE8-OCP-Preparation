package test;

import tictactoe.Position;
import tictactoe.RandomTicTacTocAI;
import tictactoe.TicTacToe;
import tictactoe.console.TicTacToeConcoleView;

public class TestRandomTicTacTocAI {

	public static void main(String[] args) {

		TicTacToe game = new TicTacToe();
		
		RandomTicTacTocAI ai = new RandomTicTacTocAI();
		
		for(int i=1; i<=9; i++) {
			Position pos = ai.getNextPosition(game);
			game.setAISign(pos.row, pos.column);
			
			System.out.println("*** " + i + ". ");
			TicTacToeConcoleView.printGame(game);
		}
		
		System.out.println("\nKein Platz mehr:");
		try {
			ai.getNextPosition(game);
		} catch(IllegalArgumentException e) {
			System.out.println("Test OK: die notwendige Exception wurde geworfen");
			System.out.println("Fehlemeldung der Exception: " + e.getMessage());
		}
	}

}
