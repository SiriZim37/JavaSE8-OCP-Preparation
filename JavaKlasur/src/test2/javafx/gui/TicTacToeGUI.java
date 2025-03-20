package test2.javafx.gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TicTacToeGUI extends JFrame {

    private JButton[][] boardBtn;
    private JButton buttonXO ;
    private JButton startButton;
    private JLabel statusLabel;
    private JTextField player1Field;
    private JTextField player2Field;
    private boolean isPlayer1Turn = true;
    private String player1Name = "Anna";
    private String player2Name = "Bobby";

    public TicTacToeGUI() {
        super("Tic Tac Toe");
        this.setSize(500, 500); // Größe setzen (Breite und Höhe)
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Beeenden des Programms beim Klick auf das Schließfeld
        this.setLocationRelativeTo(null); // Zentrieren des Fenster auf dem Bildschirm

        JPanel playerSetupPanel = new JPanel();
        playerSetupPanel.setLayout(new BoxLayout(playerSetupPanel, BoxLayout.Y_AXIS));
        JLabel welcomeLabel = new JLabel("Willkommen bei Tic Tac Toe!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerSetupPanel.add(welcomeLabel);

        // Label enter name
        JPanel namePanel = new JPanel(new GridLayout(2, 2));
        JLabel player1Label = new JLabel("Player 1 Name (X) : ");
        player1Field = new JTextField("Anna");
        JLabel player2Label = new JLabel("Player 2 Name (O) : ");
        player2Field = new JTextField("Bobby");
        namePanel.add(player1Label);
        namePanel.add(player1Field);
        namePanel.add(player2Label);
        namePanel.add(player2Field);
        playerSetupPanel.add(namePanel);

        // Start game btn
        startButton = new JButton("Spiel beginnen");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(e -> startGame());
        playerSetupPanel.add(startButton);
        this.add(playerSetupPanel, BorderLayout.NORTH);

        
        boardBtn = new JButton[3][3]; // 
        JPanel panel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
            	buttonXO = new JButton();
            	buttonXO.setFont(new Font("Arial", Font.BOLD, 80));
            	buttonXO.setEnabled(false); // After start will enable button
                panel.add(buttonXO); // // Hinzufügen des Buttons zum Panel
                boardBtn[i][j] = buttonXO;
                buttonXO.addActionListener(e -> setPositionWithBot(e));
            }
        }

        this.add(panel); // Panel dem JFrame hinzufügen
        this.setVisible(true); // JFrame sichtbar machen (Standard: nicht sichtbar)
        statusLabel = new JLabel(""); 
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        this.add(statusLabel, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    private void setPosition(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        if (button.getText().equals("")) {
            if (isPlayer1Turn) {
                button.setText("X");
                String p1 = "Player: " + player2Name + " ist am Zug. Bitte die Position eingeben";
                statusLabel.setText(p1);
            } else {
                button.setText("O");
                String p1 = "Player: " + player1Name + " ist am Zug. Bitte die Position eingeben";
                statusLabel.setText(p1);
            }

            if (checkWinner()) {
                String whoWin = isPlayer1Turn ? player1Name : player2Name;
                String winner = "Herzlichen Glückwunsch, " + whoWin + "! Sie haben gewonnen!";
                statusLabel.setText(winner);
                disableAllButtons(); // Disable all buttons after a win
            } else if (checkSlotEmpty()) {
                statusLabel.setText("Unentschieden! Das Spiel ist vorbei.");
            }
         
            isPlayer1Turn = !isPlayer1Turn;
        }
    }
    
    
    private void setPositionWithBot(ActionEvent e) {
    	setPosition(e); 
    	if (!isPlayer1Turn) { // Bot's turn
            statusLabel.setText("Player: AI ist am Zug");

            if (checkWinner()) {
                statusLabel.setText("Herzlichen Glückwunsch, AI hat gewonnen!");
                disableAllButtons();
            } else if (checkSlotEmpty()) {
                statusLabel.setText("Unentschieden! Das Spiel ist vorbei.");
            }else if (setBotPosition()) {
	           	 String p1 = "Player: " + player1Name + " ist am Zug. Bitte die Position eingeben";
	             statusLabel.setText(p1);
	        	 isPlayer1Turn = true;
            }
        }
    }
 
    private boolean setBotPosition() {
    	Random rdn = new Random();
    	String x = "X", o = "O";
    	boolean succes = false;
    	while (true) {
        	int position = rdn.nextInt(9);
    	    int row, col;
    	    System.err.println(position + " position ");
    	    row = (position) / 3;
    	    col = (position) % 3;
    	    if (boardBtn[row][col].getText().equals("")) {
    	    	boardBtn[row][col].setText(isPlayer1Turn ? x : o);
    	    	succes = true;
    	    	break;
    	    }
		}
    	return succes;
	}
    
    private boolean setSmartBotPosition() { // SmartBot
    	Random rdn = new Random();
    	String x = "X", o = "O";
    	boolean succes = false;
    	while (true) {
        	int position = rdn.nextInt(9);
    	    int row, col;
    	    System.err.println(position + " position ");
    	    row = (position) / 3;
    	    col = (position) % 3;
    	    if (boardBtn[row][col].getText().equals("")) {
    	    	boardBtn[row][col].setText(isPlayer1Turn ? x : o);
    	    	succes = true;
    	    	break;
    	    }
		}
    	return succes;
	}
    
    
    private boolean checkWinner() {
        String symbol = isPlayer1Turn ? "X" : "O";

        // Check rows and columns
        for (int i = 0; i < 3; i++) {
        	//rows
            if (boardBtn[i][0].getText().equals(symbol) && boardBtn[i][1].getText().equals(symbol) && boardBtn[i][2].getText().equals(symbol)) {
                return true;
            }
            //columns
            if (boardBtn[0][i].getText().equals(symbol) && boardBtn[1][i].getText().equals(symbol) && boardBtn[2][i].getText().equals(symbol)) {
                return true;
            }
        }

        // Check anti- & diagonals
        if ( (boardBtn[0][0].getText().equals(symbol) && boardBtn[1][1].getText().equals(symbol) && boardBtn[2][2].getText().equals(symbol) ) 
        		|| boardBtn[0][2].getText().equals(symbol) && boardBtn[1][1].getText().equals(symbol) && boardBtn[2][0].getText().equals(symbol)) {
            return true;
        }


        return false;
    }

    private boolean checkSlotEmpty() {
        for (int x = 0; x < boardBtn.length; x++) {
            for (int y = 0; y < boardBtn[x].length; y++) {
                if (boardBtn[x][y].getText().equals("")) {
                    return false;
                }
            }
        }
        return true;
    }



    private void startGame() {
        player1Name = player1Field.getText().trim();
        player2Name = player2Field.getText().trim();
        enableAllButtons();
        statusLabel.setText("Player: " + player1Name + " ist am Zug. Bitte die Position eingeben");
        isPlayer1Turn = true;
    }

    private void disableAllButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardBtn[i][j].setEnabled(false);
            }
        }
    }
    private void enableAllButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardBtn[i][j].setEnabled(true);
                boardBtn[i][j].setText("");
            }
        }
    }

    public static void main(String[] args) {
        new TicTacToeGUI();
    }
}
