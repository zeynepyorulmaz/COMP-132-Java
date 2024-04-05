[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/vWp3THmF)
# COMP 132, Fall 2023

# IMPORTANT

For each lab assignment, **you must include and sign (by writing your name and student id number) the following Pledge of Honor statement at the beginning of your main method source code file. After including this statement, make sure that you do the commit and push operation on GitHub. Otherwise, your lab solution will not be graded.**
```
/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Name Surname, Student id>
********************************************************************************/
```
## IMPORTANT NOTE 2: After you complete the tasks, do not forget to commit your changes and push them to your repository on Github.

## IMPORTANT NOTE 3: This README.md file only contains the instructions for PRELAB. You will also have INLAB questions.

# Lab-1 Prelab - Enhanced Dice Game
![](/img/dices.jpeg?raw=true "")

Using the object-oriented programming concepts covered so far, your task is to implement a dice roll game between two players. There will be a predetermined (fixed) number of rounds of this game, and at each round, the player with the highest value of the dice roll wins the round. At the end of all the rounds, the player with the largest sum of scores over all the rounds wins the game. 

Important: In your code, please put a comment for each class and method which describes it.

## Dice Class
This class will represent the dice thrown during the game. 
### Instance Variables
- #### Random random:
We will use Java’s built-in random number generator to roll the dice. To use this, you must import java.util.Random as in the following: 

```
import java.util.Random;
```
The constructor for the Random class does not need any parameters. You can create an instance of Random class as in the following: 
```
// Instance of random class
Random rand = new Random(); 
```

- #### int numSides
The number of sides of the dice. When the dice is rolled, it should produce a number between 1 and numSides (including numSides).

### Methods
```
- public Dice(int numSides)
```
  Constructor that initializes the Random instance variable, and sets the value of numSides to be the value provided.
  ```
- public int rollDice()
```
  Generates a random number between 1 and numSides, and return it
  To generate a random number using the Random instance variable, you can use random.nextInt(N). This will generate a number between 0 and N - 1. Be sure to shift it properly to get numbers between 1 and N.

## Player Class
This class represents one of the players in the game. 

### Instance Variables
- #### int score: 
  Represents the total sum of the scores from each round of the game. Assume that each player starts the game with a sum of 0.
- #### int numRoundsWon: 
  Keeps track of how many individual rounds the current player has won.
- #### String playerName:
  The name of this player.

### Methods
```
-  public Player(String name):
```
  Constructor that initializes all instance variables to be 0, and stores the player name.
  ```
- public void increaseScore(double score):
```
  Increases the total score by the value provided. 
  ```
- public void wonRound():
```
  Increments the numRoundsWon instance variable (increase by 1).

  ```
- public int getScore():
```
  Getter method for the score instance variable.

```
- public int getRoundsWon():
```
  Getter method for the numRoundsWon instance variable.
  ```
- public String getName():
```
  Return the name of the player.

## Game Class
This class will run the entire game, and determine the winner.

### Instance Variables
  - #### Player player1, player2
    Represents each of the players of the game.
  - #### Dice dice
    The dice used in the game.
  - #### int numRounds
  How many rounds to run the game for.

### Methods
```
- public Game(String name1, String name2, int numRounds, int numSides)
```
  Constructor that initializes all the instance variables.
```
- public void runGame()
```
  Run the game for numRounds rounds. For each round, you should roll the dice for each player, and update their scores, and determine who won the round. The score of a player is the value they rolled on the dice. If both players get the same score, then it is considered that both players won the round, and you should increase the necessary variables for both of them. Use a loop to repeat. At the end of each round, you should print out the dice roll for each player, the current score for each player, and who won the round. A tie is considered that both players won the round.
  ```
 -  public void printWinner()
```
  Print out the name of the player who won the most rounds, and the name of the player who had the highest sum of scores. If it is a tie for either of these values, you should print that there was a tie for that specific value.

## Main Class

This class is provided for you to test your code. Please do not apply any changes to this class.

## Sample Output
```
Enter the name of player 1: A
Enter the name of player 2: B
Enter the number of sides that the dice should have (should be between 2 and 20, including 20): 6
Enter the number of rounds of the game: 5
A rolled a 2
B rolled a 5
B won the round
A now has a score of 2
B now has a score of 5
A rolled a 4
B rolled a 4
A won the round
B won the round
A now has a score of 6
B now has a score of 9
A rolled a 3
B rolled a 3
A won the round
B won the round
A now has a score of 9
B now has a score of 12
A rolled a 1
B rolled a 3
B won the round
A now has a score of 10
B now has a score of 15
A rolled a 2
B rolled a 1
A won the round
A now has a score of 12
B now has a score of 16
A rolled a 2
B rolled a 5
B won the round
A now has a score of 14
B now has a score of 21
B had the highest score, with 21
B had the most rounds won, with 5
```


## Submission Instructions
After finishing each class, you should push your changes to Github Classroom. We will be checking the commit logs to verify this.


This pre-lab must be finished before 10am Friday, when the lab starts. Any questions can be answered by attending the office hours of one of the TAs/SLs, or emailing one of us.
The main class is provided for you, and should not be modified for the pre-lab.

