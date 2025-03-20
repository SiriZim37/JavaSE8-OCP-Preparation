package test2.javafx.gui.mvc;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import test2.solution.tictactoe.TicTacToeSign;

public class TicTacToeView extends JFrame {
    private JButton[][] boardBtn;
    private JButton startButton;
    private JLabel statusLabel;
    private JTextField player1Field;
    private JTextField player2Field;

    public TicTacToeView() {
        super("Tic Tac Toe");
        this.setSize(500, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        JPanel playerSetupPanel = new JPanel();
        playerSetupPanel.setLayout(new BoxLayout(playerSetupPanel, BoxLayout.Y_AXIS));
        JLabel welcomeLabel = new JLabel("Willkommen bei Tic Tac Toe!");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 20));
        welcomeLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerSetupPanel.add(welcomeLabel);

        JPanel namePanel = new JPanel(new GridLayout(2, 2));
        JLabel player1Label = new JLabel("Player 1 Name (X) : ");
        player1Field = new JTextField("Anna");
        JLabel player2Label = new JLabel("Player 2 Name (O) : ");
        player2Field = new JTextField("AI");
        namePanel.add(player1Label);
        namePanel.add(player1Field);
        namePanel.add(player2Label);
        namePanel.add(player2Field);
        playerSetupPanel.add(namePanel);

        startButton = new JButton("Spiel beginnen");
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playerSetupPanel.add(startButton);
        this.add(playerSetupPanel, BorderLayout.NORTH);

        boardBtn = new JButton[3][3];
        JPanel panel = new JPanel(new GridLayout(3, 3));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardBtn[i][j] = new JButton();
                boardBtn[i][j].setFont(new Font("Arial", Font.BOLD, 80));
                boardBtn[i][j].setEnabled(false);
                panel.add(boardBtn[i][j]);
            }
        }
        this.add(panel);

        statusLabel = new JLabel("");
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        this.add(statusLabel, BorderLayout.SOUTH);

        this.setVisible(true);
    }


    public void addStartButtonListener(ActionListener listener) {
		startButton.addActionListener(listener);
	}

    public void addBoardButtonListener(ActionListener listener, int row, int col) {
    	JButton button = boardBtn[row][col];
        button.addActionListener(listener);
    }

    public void enableBoardButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardBtn[i][j].setEnabled(true);
                boardBtn[i][j].setText("");
            }
        }
    }

    public void disableBoardButtons() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardBtn[i][j].setEnabled(false);
            }
        }
    }

    public void updateButton(int row, int col, String symbol) {
        boardBtn[row][col].setText(symbol);
    }

    public String getPlayer1Name() {
        return player1Field.getText().trim();
    }

    public String getPlayer2Name() {
        return player2Field.getText().trim();
    }

    public void setStatusLabel(String text) {
        statusLabel.setText(text);
    }
    
}