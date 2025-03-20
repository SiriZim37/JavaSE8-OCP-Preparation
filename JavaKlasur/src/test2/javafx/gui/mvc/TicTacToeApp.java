package test2.javafx.gui.mvc;

public class TicTacToeApp {
	
    public static void main(String[] args) {
        TicTacToeModel model = new TicTacToeModel();
        RandomTicTacToeAI ai = new RandomTicTacToeAI();
        TicTacToeView view = new TicTacToeView();
        new TicTacToeController(model, view , ai);
    }
}
