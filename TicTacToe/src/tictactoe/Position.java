package tictactoe;

public class Position {
	
	/**
	 * Wenn die Zellen auf dem Spielfeld 3x3 durchnummeriert sind,
	 * berechnet die Methode aus dem Index die Feld-Koordinaten. 
	 * 
	 * @param index
	 * @return
	 */
	public static Position fromIndex(int index) {
		int row = (index-1) / 3;
		int col = (index-1) % 3;

		return new Position(row, col);
	}
	
	public final int row;
	public final int column;
	
	public Position(int row, int column) {
		this.row = row;
		this.column = column;
	}
}
