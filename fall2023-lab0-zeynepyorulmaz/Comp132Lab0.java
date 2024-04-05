import java.util.Scanner;

public class Comp132Lab0 {
	
	
	private String name ;




	public Comp132Lab0(String name) {
		// TODO Auto-generated constructor stub
		this.name = name;
	
	}

		

	/* *********** Pledge of Honor ************************************************
	*
	* I hereby certify that I have completed this lab assignment on my own
	* without any help from anyone else. I understand that the only sources of authorized
	* information in this lab assignment are (1) the course textbook, (2) the
	* materials  posted at the course website and (3) any study notes handwritten by myself.
	*
	* I have not used, accessed or received any information from any other unauthorized
	* source in taking this lab assignment. The effort in the assignment thus belongs
	* completely to me.
	*
	*  READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
	*  SIGNATURE:   <Zeynep Yorulmaz,    83684>
	* 
	********************************************************************************/
	public static void main(String[] args) {


		// TODO:  1. Define a variable of type integer (int).
		int a;
		a = 0;
		
		
		// TODO:  2. Let the user input an integer representing the number of seconds and store it in the variable defined.
		
		int sayi = 5/2;
		System.out.println(sayi);
		// Note: You can use the defined input object of type Scanner to get input from the user.
		System.out.println("Give me seconds.");
		Scanner input = new Scanner(System.in);
		int sec = input.nextInt();
		// TODO:  3. Write a program that converts the given number of seconds to hours, minutes, and seconds. 
		
		int hours = sec /3600;
		int artan_saniyeler = sec - hours*3600;
		int dakika = artan_saniyeler / 60;
		int son_saniyeler = artan_saniyeler - 60*dakika;

		// TODO:  4. Use println to display the result.
		System.out.println(hours + " hours, " + dakika + " minutes, " + son_saniyeler + " seconds.");

		// TODO:  5. Define an object of type String, and store the string values of your name and surname in this object.
		Comp132Lab0 me = new Comp132Lab0("Zeynep Yorulmaz");
		
		
		// TODO:  6. Define a variable of type int, and store your KUSIS ID number in this variable.
		int ID = 83684;


		// TODO:  7. Use println to display the values in this object and variable.
		System.out.println( me.name + " "+ ID);

		// TODO:  8. Write the code for displaying the integer equivalents of the letters in your name and surname.
		for (char letter : me.name.toCharArray()) {
            System.out.println("Character " + letter+ " has the value " + (int)letter);
        }


	}

}
