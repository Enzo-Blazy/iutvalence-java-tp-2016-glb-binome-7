package fr.iutvalence.blazyramos.connectfour;

import java.util.Scanner;

/*
 * Authors: Cyril Ramos, Enzo Blazy	
 */
public class Game 
{
	private Player player1;
	
	private Player player2;
	
	private Board board;

	
	public Game() {
		player1 = new Player("Momo", Piece.PIECE1);
		player2 = new Player("Toto", Piece.PIECE2);
		board = new Board();

	}

	public void start() {
		Scanner scanner = new Scanner(System.in);

		System.out.printf("New game: %s vs. %s\n",player1.name(), player2.name()) ;
		Player player = player1;

		for (int i = 0; i < 999; i++) {
			//while (!victory()) 
			// Algo :
			/* 1 = Afficher la board*/
			board.print();
			/* 2= Joueur courant identifié par sa piece*/
			System.out.println("Choose a column number:");
			int col = scanner.nextInt();
			System.out.println("You choosed the column number : " + col);

			// Vérification de la place dans la colone et positionnement du pion
			if (!board.isFullColumn(col)) {
				board.putPiece(col, player.getPiece());
				if (player == player1) {
					player = player2;   
				}
				else {
					player = player1;
				}
			}
			else {
				System.err.println("The selected column is full"); //Message d'erreur
				
			}

		}
		scanner.close();


	}

      //TODO 
	/*private boolean victory() {
		return board.isVictory() || board.isFull();
	}*/
	
}







