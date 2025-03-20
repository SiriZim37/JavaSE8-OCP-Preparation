package test2.solution.tictactoe;

public class Position {
	
	public int column;
	public int row;

	public Position(int row, int col) {
		this.row = row;
		this.column = col;
	}

	public static Position fromIndex(int positionIndex) {
		 int row = (positionIndex - 1) / 3;
	        int col = (positionIndex - 1) % 3;
		return new Position(row, col);
	}
	


}
