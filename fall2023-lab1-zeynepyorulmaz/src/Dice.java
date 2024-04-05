import java.util.Random;
	
	
public class Dice {
	public Random random;
	public int numSides;
	
	public Dice(int numSides) {
		this.random = new Random();
		this.numSides = numSides;
		
	}
	//random dice rolling
	public int rollDice(){
		int pickedValue = random.nextInt(numSides+1) ; 
		return pickedValue;
	}

}
//Instance of random class


