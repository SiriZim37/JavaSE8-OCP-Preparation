package test2.solution.tictactoe;


public class TestTicTacToeMethoden {

	public static void main(String[] args) {
		testIsPlayerWinner();
		testIsAIWinner();
		testIsDraw();
	}

	static void testIsDraw() {
		System.out.println("\n*** Test isDraw");
		TicTacToeModel game = new TicTacToeModel();
		
		boolean result = game.isDraw();
		System.out.println("1. expected: false, actual: " + result);
		
		System.out.println("AI hat gewonnen");
		game.setAISign(1, 0);
		game.setAISign(1, 1);
		game.setAISign(1, 2);
		
		result = game.isDraw();
		System.out.println("2. expected: false, actual: " + result);
		
		System.out.println("keiner hat noch gewonnen, es gibt freie Plätze");
		game = new TicTacToeModel();
		game.setPlayerSign(0, 0);
		game.setPlayerSign(0, 2);
		game.setPlayerSign(1, 0);
		game.setPlayerSign(1, 1);
		game.setPlayerSign(2, 1);
		game.setAISign(0, 1);
		game.setAISign(1, 2);
		game.setAISign(2, 0);
		
		result = game.isDraw();
		System.out.println("3. expected: false, actual: " + result);
		
		System.out.println("unentschieden");
		
		game.setAISign(2, 2);
		
		result = game.isDraw();
		System.out.println("4. expected: true, actual: " + result);
	}
	
	static void testIsAIWinner() {
		System.out.println("\n*** Test isAIWinner");
		TicTacToeModel game = new TicTacToeModel();
		
		boolean result = game.isAIWinner();
		System.out.println("1. expected: false, actual: " + result);
		
		System.out.println("Zeile 1 gefüllt");
		game.setAISign(1, 0);
		game.setAISign(1, 1);
		game.setAISign(1, 2);
		
		result = game.isAIWinner();
		System.out.println("2. expected: true, actual: " + result);
		
		// todo: weitere tests...
	}
	
	static void testIsPlayerWinner() {
		System.out.println("\n*** Test isPlayerWinner");
		TicTacToeModel game = new TicTacToeModel();
		
		boolean result = game.isPlayerWinner();
		System.out.println("1. expected: false, actual: " + result);

		System.out.println("Zeile 1 gefüllt");
		game.setPlayerSign(1, 0);
		game.setPlayerSign(1, 1);
		game.setPlayerSign(1, 2);
		
		result = game.isPlayerWinner();
		System.out.println("2. expected: true, actual: " + result);
		
		System.out.println("Spalte 2 gefüllt");
		game = new TicTacToeModel();
		
		game.setPlayerSign(0, 2);
		game.setPlayerSign(1, 2);
		game.setPlayerSign(2, 2);
		
		result = game.isPlayerWinner();
		System.out.println("3. expected: true, actual: " + result);
		
		System.out.println("Diagonale 1 gefüllt");
		game = new TicTacToeModel();
		
		game.setPlayerSign(0, 0);
		game.setPlayerSign(1, 1);
		game.setPlayerSign(2, 2);
		
		result = game.isPlayerWinner();
		System.out.println("4. expected: true, actual: " + result);
		
		System.out.println("Diagonale 5 gefüllt");
		game = new TicTacToeModel();
		
		game.setPlayerSign(0, 2);
		game.setPlayerSign(1, 1);
		game.setPlayerSign(2, 0);
		
		result = game.isPlayerWinner();
		System.out.println("5. expected: true, actual: " + result);
	}
}
