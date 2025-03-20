package test2.solution.tictactoe;

import java.util.Random;

public class RandomTicTacToeAI implements TicTacToeAI {

	
	@Override
	public Position getNextPostion(TicTacToeModel game) {
		
		if(!game.hasFreePosition()) {
			throw new IllegalArgumentException("Das Spielfeld hat keine freien Positionen");
		}
		
		Random rnd = new Random();
		
		while (true) {
			int row = rnd.nextInt(game.getDim());
			int column = rnd.nextInt(game.getDim());
			
			if( game.getSign(row, column) == TicTacToeSign.NONE ) {
				return new Position(row, column);
			}
		}

	}

}
