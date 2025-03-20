package test2.solution.tictactoe;

public class TestRandomTicTacToeAI {

	public static void main(String[] args) {

		TicTacToeModel game = new TicTacToeModel();
		
		RandomTicTacToeAI ai = new RandomTicTacToeAI();
		
		for( int i = 1 ; i <= 9 ; i++) {
			Position pos = ai .getNextPostion(game);
			game.setAISign(pos.row , pos.column);
			
			System.out.println("****" + i + " . ");
			TicTacToeConsoleView.printGame(game);
		}
		
		System.out.println("\nKeine Platz mehr.");
		try {
			ai.getNextPostion(game);
		} catch (IllegalArgumentException e) {
			System.out.println("Test OK : Notwendig exception wurde geworfen.");
			System.out.println("Fehlemeldung der Exception : " + e.getMessage());
		}
		
		

	}

}
