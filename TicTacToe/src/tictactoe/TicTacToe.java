package tictactoe;

public class TicTacToe {
	
	private static final int dim = 3;

	private TicTacToeSign[][] field; 
	
	public TicTacToe() {
		field = new TicTacToeSign[dim][dim];
		
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[i].length; j++) {
				field[i][j] = TicTacToeSign.NONE;
			}
		}
	}
	
	public int getDim() {
		return dim;
	}
	
	public boolean isOver() {
		return isPlayerWinner() 
				|| isAIWinner() 
				|| isDraw();
	}
	
	public boolean hasFreePosition() {
		for (int i = 0; i < getDim(); i++) {
			for (int j = 0; j < getDim(); j++) {
				if(getSign(i, j) == TicTacToeSign.NONE) {
					return true;
				}
			}
		}
		
		return false;
	}
	
	private boolean isSignWinner(TicTacToeSign sign) {
		// Zeilen überprüfen
		for (int row = 0; row < dim; row++) {
			// Spalten der Zeile row überprüfen
			int countSign = 0;
			for (int col = 0; col < dim; col++) {
				if (field[row][col] == sign) {
					countSign++;
				}
			}
			if (countSign==dim) {
				return true;
			}
		}
		
		//Spalten überprüfen
		for (int col=0; col < dim; col++) {
			// Zeilen der Spalte col überprüfen
			int countSign = 0;
			for (int row=0; row < dim; row++) {
				if(field[row][col] == sign) {
					countSign++;
				}
			}
			if (countSign==dim) {
				return true;
			}
		}
		
		// Diagonale 1 überprüfen
		int countSign = 0;
		for (int i = 0; i < dim; i++) {
			if (field[i][i] == sign) {
				countSign++;
			}
		}
		if (countSign==dim) {
			return true;
		}
		
		// Diagonale 2 überprüfen
		countSign = 0;
		for (int row = 0, col=dim-1; row < dim; row++, col--) {
			if (field[row][col] == sign) {
				countSign++;
			}
		}
		return countSign==dim;
	}
	
	public boolean isPlayerWinner() {
		return isSignWinner(TicTacToeSign.PLAYER);
	}
	
	public boolean isAIWinner() {
		return isSignWinner(TicTacToeSign.AI);
	}
	
	public boolean isDraw() {
		if(isAIWinner() || isPlayerWinner()) {
			return false;
		}
		
		for (int row = 0; row < dim; row++) {
			for (int col = 0; col < dim; col++) {
				if(field[row][col] == TicTacToeSign.NONE) {
					return false;
				}
			}
		}
		
		return true;
	}
	
	public TicTacToeSign getSign(int row, int column) {
		return field[row][column];
	}
	
	public void setPlayerSign(Position pos) {
		setPlayerSign(pos.row, pos.column);
	}
	
	public void setPlayerSign(int row, int column) {
		setSign(row, column, TicTacToeSign.PLAYER);
	}
	
	public void setAISign(Position pos) {
		setAISign(pos.row, pos.column);
	}
	
	public void setAISign(int row, int column) {
		setSign(row, column, TicTacToeSign.AI);
	}
	
	private void setSign(int row, int column, TicTacToeSign sign) {
		if (field[row][column]!=TicTacToeSign.NONE) {
			throw new PositionOccupiedException("Die Position " + row + ", " + column + " ist bereits belegt");
		}
		
		field[row][column] = sign;
	}
	
	@Override
	public String toString() {
		String text = "Tic Tac Toe. ";
		
		if(isOver()) {
			text += "Das Spiel ist vorbei. ";
			
			if(isDraw()) {
				text += "Unentschieden";
			} else if(isPlayerWinner()) {
				text += "Player hat gewonnen.";
			} else {
				text += "Player hat verloren.";
			}
			
		} else {
			text += "Das Spiel läuft. ";
			
//			if(player ist am zug) {
//				text += "Player ist am Zug.";
//			} else {
//				text += "KI ist am Zug.";
//			}
		}
		
		return text;
	}
	
}
