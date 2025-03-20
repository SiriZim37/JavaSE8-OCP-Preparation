package test2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {

	static char[][] board = new char[3][3];
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.println("*********** TIC TAC TOE **************");
		System.out.println("Bitte geben Sie Positionsnummer wie im Beispiel gezeigt ein");
		board = new char[][] {
			        {'1', '2', '3'},
			        {'4', '5', '6'},
			        {'7', '8', '9'}
			    };
		showBoard();
		board =  new char[3][3];
		 		
		System.out.print("Geben Sie den Namen von Spieler 1 (X) : ");
	    String player1 = sc.nextLine();
	    System.out.print("Geben Sie den Namen von Spieler 2 (O) : ");
	    String player2 = sc.nextLine();
		
	    boolean isPlayer1Turn = true;
		while (true) {	
			showBoard();
	        String currentPlayer = isPlayer1Turn ? player1 : player2;
	        int position;
	        while (true) {
	        	System.out.println("Player: " + currentPlayer + " ist am Zug. Bitte die Position eingeben ");
	        	try {
	        		  position = sc.nextInt();
		        	  if( position >= 0  &&  position <=9 ) {
		        		  break;
		        	  }else {
		        		  System.out.println("Bitte geben Sie die position 1-9 ein");
		        	  }
				} catch (InputMismatchException e) {
					 System.out.println("Bitte geben Sie die position 1-9 ein");
					 sc.next();
				}
	  		}
	       
	        boolean isSuccess = setPosition(position, isPlayer1Turn);
	        if (isSuccess) {
                if (checkWinner(isPlayer1Turn)) {
                    showBoard();
                    System.out.println("Herzlichen Glückwunsch, " + currentPlayer + "! Sie haben gewonnen!");
                    break;
                }
                if (checkSlotEmpty()) {
                    showBoard();
                    System.out.println("Das Spiel endet unentschieden!");
                    break;
                }
                isPlayer1Turn = !isPlayer1Turn;
            } else {
                System.out.println("Ungültige Position oder bereits besetzt! Versuchen Sie es erneut.");
            }
        }  
		sc.close();
	}
	
	private static boolean checkSlotEmpty() {
		for(int x = 0 ; x < board.length ; x ++) {
			for( int y = 0 ; y < board[x].length ; y++) {
				 if (board[x][y] != 'X' && board[x][y] != 'O') {
					return false;
				}
			}
		}
		return true;
	}
	
	private static boolean checkWinner( boolean isP1) {

		char symbol = isP1? 'X':'O';
		// check all row s
		// [0][0]  [0][1]  [0][2] , 
		// [1][0]  [1][1]  [1][2] ,  
		// [2][0]  [2][1]  [2][2]
	    for (int i = 0; i < 3; i++) {
	        if (board[i][0] != ' ' && board[i][0] == symbol  && board[i][0] == board[i][1] && board[i][1] == board[i][2] ) {
	            return true;
	        }
	    }
	    
	    // check all : columns
		// [0][0] [1][0] [2][0] , 
	    // [0][1] [1][1] [2][1] , 
	    // [0][2] [1][2] [2][2] 
	    for (int i = 0; i < 3; i++) {
	        if (board[0][i] != ' ' && board[0][i]== symbol  && board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
	            return true;
	        }
	    }
	    
	    // check   anti- & diagonal
	    // [0][0]  [1][1] [2][2]                  			
	    // [2][0] [1][1] [2][0]     			 		   
	   
	    if ((board[0][0] != ' ' && board[0][0] == symbol && board[0][0] == board[1][1] && board[1][1] == board[2][2]) ||
	            (board[0][2] != ' '  && board[0][2]  == symbol  && board[0][2] == board[1][1] && board[1][1] == board[2][0])) {
	            return true;
	        }
		return false;
		
	}
	
	

	private static boolean setPosition( int position, boolean isP1) {

	    char x = 'X', o = 'O';
	    int row, col;

	    row = (position - 1) / 3;
	    col = (position - 1) % 3;
	    if (board[row][col] != x && board[row][col] != o) {
	    	board[row][col] = isP1 ? x : o;
	    	  return true;
	    } else {
	        return false;
	    }
	  
	}

	private static void showBoard() {
		
		String fmt = "|%1s|%1s|%1s|"; 
		for(char[] x : board) {		
			char[] chIndex = new char[3];
			int i = 0 ;
			for(char y : x) {
				chIndex[i++] = y;
			}
			System.out.format(fmt , chIndex[0] , chIndex[1] , chIndex[2]);
			System.out.println();
		}
			
	}

}
