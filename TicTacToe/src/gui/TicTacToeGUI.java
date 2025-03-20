package gui;

import java.awt.Font;


import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import tictactoe.Position;
import tictactoe.RandomTicTacTocAI;
import tictactoe.TicTacToe;
import tictactoe.TicTacToeAI;


public class TicTacToeGUI extends JFrame implements ActionListener {
	
	private class IndexedButton extends JButton {
		private Position gamePosition;

		public IndexedButton(int row, int column) {
			super();
			this.gamePosition = new Position(row, column);
		}
		
		public Position getGamePosition() {
			return gamePosition;
		}
	}
	
	private JButton[][] buttons;
	
	private TicTacToe game;
	private TicTacToeAI gameAI;
	
	/*
	 * Swing-Tutorial:
	 * 
	 * https://docs.oracle.com/javase/tutorial/uiswing/
	 */
	public TicTacToeGUI(TicTacToe game, TicTacToeAI gameAI) {
		super("TicTacToe");
		this.game = game;
		this.gameAI = gameAI;
		
		this.setSize(500, 500); // Größe setzen (Breite und Höhe)
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Beeenden des Programms beim Klick auf das Schließfeld
		this.setLocationRelativeTo(null); // Zentrieren des Fenster auf dem Bildschirm
		
		buttons = new JButton[3][3];
		JPanel panel = new JPanel(new GridLayout(3,3)); // Panel als Container zum Aufnehmen der 9 Button im Gitter-Layout
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				JButton button = new IndexedButton(i, j);
				button.setFont(new Font("Arial", Font.BOLD, 80));
				panel.add(button); // Hinzufügen des Buttons zum Panel
				buttons[i][j] = button;
				button.addActionListener(this);
			}
		}
		this.add(panel); // Panel dem JFrame hinzufügen
		this.setVisible(true); // JFrame sichtbar machen (Standard: nicht sichtbar)
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// System.out.println(e.getSource());
		IndexedButton button = (IndexedButton) e.getSource();
		
		// Welche Position in GUI der button hat
		Position playerPos = button.getGamePosition(); 
		
		// User-Zeichen im Model setzen
		// und die View aktualisieren
		game.setPlayerSign(playerPos);
		button.setText("x");

		// falls das Spiel vorbei ist: Endzustand zeigen
		if(game.isOver()) {
			onGameOver();
			return;
		}
		
		// KI-Zug durchführen
		// und die View aktualisieren
		Position aiPos = gameAI.getNextPosition(game);
		game.setAISign(aiPos);
		
		JButton aiButton = buttons[aiPos.row][aiPos.column];
		aiButton.setText("o");
		
		// falls das Spiel vorbei ist: Endzustand zeigen
		if(game.isOver()) {
			onGameOver();
		}
	}
	
	private void onGameOver() {
		JOptionPane.showMessageDialog(this, game.toString(), 
				"Spiel-Ergebnis", JOptionPane.PLAIN_MESSAGE);
		
		for (int i = 0; i < buttons.length; i++) {
			for (int j = 0; j < buttons[i].length; j++) {
				buttons[i][j].setEnabled(false);
//				buttons[i][j].removeActionListener(this);
			}
		}
	}
	

	public static void main(String[] args) {
		
		TicTacToe game = new TicTacToe();
		TicTacToeAI ai = new RandomTicTacTocAI();
		
		TicTacToeGUI tictactoe = new TicTacToeGUI(game, ai);
	}

	

}
