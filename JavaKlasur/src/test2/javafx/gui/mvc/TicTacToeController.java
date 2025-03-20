package test2.javafx.gui.mvc;


//Controller: Agiert als Vermittler zwischen Model und View, verarbeitet 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class TicTacToeController {
    private TicTacToeModel game;
    private RandomTicTacToeAI gameAI;
    private TicTacToeView view;
    private String player1Name;
    private String player2Name;
	
    public TicTacToeController(TicTacToeModel model, TicTacToeView view , RandomTicTacToeAI ai) {
        this.game = model;
        this.view = view;
        this.gameAI = ai;
        this.view.addStartButtonListener(new StartGameListener());

        for (int i = 0; i < model.getDim() ; i++) {
            for (int j = 0; j < model.getDim()  ; j++) {
                int row = i;
                int col = j;
                this.view.addBoardButtonListener(new BoardButtonListener(row, col), row, col);
            }
        }
    }

    private class StartGameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            player1Name = view.getPlayer1Name();
            player2Name = view.getPlayer2Name();
            view.enableBoardButtons();
            game.resetGame();
            view.setStatusLabel("Player: " + player1Name + " ist am Zug. Bitte die Position eingeben");
        }
    }

    private class BoardButtonListener implements ActionListener {
        private int row, col;

     // Welche Position in GUI der button hat
        public BoardButtonListener(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
        	 try {
        		 
                 Position playerPos = new Position(row, col);
               
                 // User-Zeichen im Model setzen
         		// und die View aktualisieren
                 game.setPlayerSign(playerPos);
             
                 view.updateButton(row, col, getDisplaySign(TicTacToeSign.PLAYER));
                 
                 if (game.isOver()) {
                     view.setStatusLabel(game.getStatusLabel());
                     view.disableBoardButtons();
                     return;
                 }

                // falls das Spiel vorbei ist: Endzustand zeigen
         		
                 // KI-Zug durchführen
         		// und die View aktualisieren
                 Position aiPos = gameAI.getNextPostion(game);
                 if (aiPos != null) {
                     game.setAISign(aiPos);
                     view.updateButton(aiPos.row, aiPos.column, getDisplaySign(TicTacToeSign.AI));
                 }
                 
             	// falls das Spiel vorbei ist: Endzustand zeigen
                 if (game.isOver()) {
                     view.setStatusLabel(game.getStatusLabel());
                     view.disableBoardButtons();
                 }
             } catch (Exception ex) {
                 ex.printStackTrace(); // Druckt die Stack-Trace für Fehlersuche
             }
           
        }
    }


	private static String getDisplaySign(TicTacToeSign sign) {
		switch(sign) {
			case NONE: return " "; 
			case PLAYER: return "X"; 
			case AI: return "O"; 
		}
		
		throw new IllegalAccessError("unsupported sign: " + sign);
	}
	
}
