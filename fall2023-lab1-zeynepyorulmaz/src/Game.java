
public class Game {
	Player player1;
	Player player2;
	Dice dice;
	int numRounds;
	String winner;
	public Game(String name1, String name2, int numSides, int numRounds) {
		this.player1 = new Player(name1);
		this.player2 = new Player(name2);
		this.dice = new Dice(numSides);
		this.numRounds = numRounds;
		
	}
	/** i checked who rolled the bigger number and then increment their scores and saved who won the run, after all process using getters I compared the last values of them*/
	public void runGame() {
		int roll1st;
		int roll2nd;
		for(int i =0; i<numRounds; i++) {
			roll1st= dice.rollDice();
			roll2nd = dice.rollDice();
			System.out.println(player1.getName() + " rolled a " + roll1st);
			System.out.println(player2.getName() + " rolled a " + roll2nd);
			
			if(roll1st > roll2nd) {
				player1.increaseScore(roll1st);
				player2.increaseScore(roll2nd);
				winner = player1.getName();
				player1.wonRound();
				System.out.println(winner + " won the round");
			}
			else if(roll1st<roll2nd) {
				player1.increaseScore(roll1st);
				player2.increaseScore(roll2nd);
				winner = player2.getName();
				player2.wonRound();
				System.out.println(winner + " won the round");
				
			}
			else {
				player1.increaseScore(roll1st);
				player2.increaseScore(roll2nd);
				player1.wonRound();
				player2.wonRound();
				System.out.println(player1.getName() + " won the round");
				System.out.println(player2.getName() + " won the round");
				
			}
			System.out.println(player1.getName() + " now has a score of " + player1.getScore());
            System.out.println(player2.getName() + " now has a score of " + player2.getScore());
			
			
		}
		
		
	}
	
	public void runGame2() {
		int roll1st;
		int roll2nd;
		int threshold;
		threshold = 3;
		for(int i =0; i<numRounds; i++) {
			roll1st= dice.rollDice();
			roll2nd = dice.rollDice();
			System.out.println(player1.getName() + " rolled a " + roll1st);
			System.out.println(player2.getName() + " rolled a " + roll2nd);
			
			if(roll1st- roll2nd> threshold) {

				player1.increaseScore(2);

				winner = player1.getName();
				player1.wonRound();
				System.out.println(winner + " won the round");
			}
			else if(-roll1st+roll2nd>threshold) {

				player2.increaseScore(2);
				winner = player2.getName();
				player2.wonRound();
				System.out.println(winner + " won the round");
				
			}
			else if(roll1st- roll2nd== threshold) {
				player1.increaseScore(1);

				player1.wonRound();
				System.out.println(player1.getName() + " won the round");
				
			}

			else if(roll2nd- roll1st== threshold) {
				player2.increaseScore(1);

				player2.wonRound();
				System.out.println(player2.getName() + " won the round");
				
			}
			else if(roll1st == roll2nd) {
				player1.increaseScore(1);
				player2.increaseScore(1);

				System.out.println("The round is tied");

				
				
			}
			else if ((roll1st-roll2nd) < 3 && (roll1st-roll2nd) > -3) {
				if (roll1st<roll2nd){
					player2.increaseScore(1);
					winner = player2.getName();
					player2.wonRound();
					System.out.println(winner + " won the round");
				}
				else if (roll1st>roll2nd){
					player1.increaseScore(1);
					winner = player1.getName();
					player1.wonRound();
					System.out.println(winner + " won the round");
				}
				
			}
			System.out.println(player1.getName() + " now has a score of " + player1.getScore());
            System.out.println(player2.getName() + " now has a score of " + player2.getScore());
			
		
		
		}
		
			
			
		}
		
		
	
	
	public void printWinner() {
		 if(player1.getScore()>player2.getScore()) {
			 System.out.println(player1.getName() + " had the highest score, with " + player1.getScore());
			 
		 }
		 else if(player2.getScore()>player1.getScore()) {
			 System.out.println(player2.getName() + " had the highest score, with " + player2.getScore());
			 
		 }
		 else {
			 System.out.println(player1.getName() + " had the highest score, with " + player1.getScore());
			 System.out.println(player2.getName() + " had the highest score, with " + player2.getScore());
		 }
		 if(player1.getRoundsWon()> player2.numRoundsWon) {
			 System.out.println(player1.getName() +" had the most rounds won, with " + player1.getRoundsWon());
			 
		 }
		 else if(player1.getRoundsWon()< player2.numRoundsWon) {
			 System.out.println(player2.getName() +" had the most rounds won, with " + player2.getRoundsWon());
		 }
		 else {
			 System.out.println(player1.getName() +" had the most rounds won, with " + player1.getRoundsWon());
			 System.out.println(player2.getName() +" had the most rounds won, with " + player2.getRoundsWon());
		 }
	}
	
}
