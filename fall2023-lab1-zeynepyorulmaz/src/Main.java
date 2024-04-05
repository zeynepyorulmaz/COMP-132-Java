import java.util.Scanner;


public class Main {
	/* *********** Pledge of Honor ************************************************ *

	I hereby certify that I have completed this lab assignment on my own
	without any help from anyone else. I understand that the only sources of authorized
	information in this lab assignment are (1) the course textbook, (2) the
	materials posted at the course website and (3) any study notes handwritten by myself.
	I have not used, accessed or received any information from any other unauthorized
	source in taking this lab assignment. The effort in the assignment thus belongs
	completely to me.
	READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
	SIGNATURE: <Zeynep Yorulmaz, 83684>
	********************************************************************************/
	public static void main(String[] args) {
		// Declare variables
		Scanner sc; 
		int numSides,numRounds;
		String player1Name, player2Name;
		
		// Using scanner to read input from console.
		sc = new Scanner(System.in);
		
		// Getting necessary inputs for the players.
		System.out.print("Enter the name of player 1: ");
		player1Name = sc.nextLine();
		System.out.print("Enter the name of player 2: ");
		player2Name = sc.nextLine();
		System.out.print("Enter the number of sides that the dice should have (should be between 2 and 20, including 20): ");
		
		// Use the do/while loop to ensure that the number of sides of the dice is a valid number.
		do {
			numSides = sc.nextInt();
		}while(numSides < 2 || numSides > 20);
		System.out.print("Enter the number of rounds of the game: ");
		// Get the number of rounds the game will be played for.
		numRounds = sc.nextInt();
		
		// Initialize & run the game for the given players and dice configuration
		Game game = new Game(player1Name, player2Name, numSides, numRounds);
		game.runGame2();
		game.printWinner();
		
		// Close the scanner 
		sc.close();
	}
}
