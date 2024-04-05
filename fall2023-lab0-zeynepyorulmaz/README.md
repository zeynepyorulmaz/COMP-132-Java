# Fall 2023 Lab-0
The objective of this Lab-0 is to make sure that you are able to clone the lab assignment template, and commit and push your solution to GitHub. You must follow the instructions provided on the course web site.

# IMPORTANT:
For each lab assignment, you must include and sign (by writing your name and student id number) the following Pledge of Honor statement at the beginning of your main method source code file. After including this statement, make sure that you do the commit and push operation on GitHub. Otherwise, your lab solution will not be graded.

```
/* *********** Pledge of Honor *************************** *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Name Surname, Student id>

**********************************************************/
```

# Lab-0 Information and Tasks:
Inside the cloned Eclipse project, you will find a class named Comp132Lab0. In this class’ main method, you are asked to implement the following tasks as indicated by the comments in the code.

- **1.** Define a variable of type integer (int).

- **2.** Let the user input an integer representing the number of seconds and store it in the variable defined.
  - You can use the defined input object of type Scanner to get input from the user, and can assume that the user enters a positive integer.
```
  Scanner input = new Scanner(System.in);
```

- **3.** Write a program that converts the given number of seconds to hours, minutes, and seconds.
  - For example: "5004 seconds = 1 hours, 23 minutes, and 24 seconds".

**Hint:** You can use the modulus (i.e. remainder) operator %

- **4.** Use println to display the result.
- **5.** Define an object of type String, and store the string values of your name and surname in this object.
- **6.** Define a variable of type int, and store your KUSIS ID number in this variable.
- **7.** Use println to display the values in this object and variable.
- **8.** Write the code for displaying the integer equivalents of the letters in your name and surname.
  
**Information:** *ASCII* (American Standard Code for Information Interchange) is a character encoding standard for electronic communication. ASCII codes are used to represent characters in computers and telecom devices.
ASCII is used for representing 128 English characters in the form of numbers, with each letter being assigned to a specific number in the range 0 to 127. For example, the ASCII code for uppercase A is 65, uppercase B is 66, and so on.
In Java, you can determine a character’s integer equivalent by preceding that character with (int), as in (int) 'A'. An operator of this form is called a cast operator. The following statement outputs a character and its integer equivalent:
```
System.out.printf("Character %c has the value %d%n", 'A', ((int) 'A'));
```
When the preceding statement executes, it displays the character A and the value 65 (from the Unicode character set). The format specifier %c is a placeholder for a character (in this case, the character 'A').


### After you complete the tasks, do not forget to commit your changes and push them to your repository on GitHub.

