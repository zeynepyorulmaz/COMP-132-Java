
public class Player {
	//	declaring variables
	public int score;
	public int numRoundsWon;
	public String playerName;
	
	// define class
	public Player(String name) {
		this.score = 0;
		this.numRoundsWon = 0;
		this.playerName = name;
		
	}
		

	// defining getters setters
		public void increaseScore(double score) {
			this.score += score;
			
			}
		public void wonRound() {
			numRoundsWon++;
			
			
			
		}
		public int getScore() {
			return score;
		}
		public int getRoundsWon() {
			return numRoundsWon;
		}
		public String getName() {
			return this.playerName;	
		}
		

}
