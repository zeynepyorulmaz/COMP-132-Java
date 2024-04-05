package arraymanipulation;
/* *********** Pledge of Honor ************************************************ *

I hereby certify that I have completed this lab assignment on my own
without any help from anyone else. I understand that the only sources of authorized
information in this lab assignment are (1) the course textbook, (2) the
materials posted at the course website and (3) any study notes handwritten by myself.
I have not used, accessed or received any information from any other unauthorized
source in taking this lab assignment. The effort in the assignment thus belongs
completely to me.
READ AND SIGN BY WRITING YOUR NAME SURNAME AND STUDENT ID
SIGNATURE: <Zeynep Yorulmaz, 83684
********************************************************************************/
public class AdvancedArrayManipulation {

    public static void main(String[] args) {
        // Define an array of integers
        int[] numbers = {5, 7, 2, 8, 1, 6, 9, 3, 4};
        int[] numbers2 = {5, 7, 2, 8, 1, 6, 9, 3, 4};
        int[] numbers2Descending = {5, 7, 2, 8, 1, 6, 9, 3, 4};

        System.out.print("The original array is ");
        printArray(numbers);

        // 1. Sort the array in ascending order.
        sortAscending(numbers2);
        System.out.print("The sorted array is ");
        printArray(numbers2);
        System.out.println("The result should be [1, 2, 3, 4, 5, 6, 7, 8, 9]");
        System.out.println();
        
        // 2. Sort array in descending order
        sortDescending(numbers2Descending);
        System.out.print("The descending sorted array is ");
        printArray(numbers2Descending);
        System.out.println("The result should be [9, 8, 7, 6, 5, 4, 3, 2, 1]");
        System.out.println();
        
        // 3. Calculate the median of all the elements in the array.
        double median = getMedian(numbers);
        
        System.out.println("The median of the numbers is " + median);
        System.out.println("The median should be 5");
        System.out.println();

        // 4. Find the second largest element in the array.
        int secondLargest = getNthLargest(numbers, 2);
        System.out.println("The second largest is " + secondLargest);
        System.out.println("The second largest should be 8");
        System.out.println();

        // 5. Remove the element at index 4 and shift the subsequent elements to the left.
        int[] numbers3 = removeAtIndex(numbers, 4);
        System.out.print("Removing the element at index 4, we get ");
        printArray(numbers3);
        System.out.println("The result should be {5, 7, 2, 8, 6, 9, 3, 4}");
        System.out.println();

        // 6. Replace all occurrences of a specific element, for example, 7, with 0.
        int[] numbers4 = replaceDigits(numbers, 7, 0);
        System.out.print("Replacing all 7s with 0s, we get ");
        printArray(numbers4);
        System.out.println("We should get [5, 0, 2, 8, 1, 6, 9, 3, 4]");
        System.out.println();

    }

    // Given an input array of integers, this method should replace every appearance of oldDigit in the array with newDigit, while keeping
    // all other elements of the array unchanged.
    public static int[] replaceDigits(int[] numbers, int oldDigit, int newDigit) {
        int[] newArray = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] == oldDigit) { // swap the old digit and new digit variables
                newArray[i] = newDigit;
            }
            else {
                newArray[i] = numbers[i];
            }
        }
        return newArray;
    }

    // Given an input array and an index, this method should delete the element at the provided index, and shift every element after it
    // one position to the left. 
    public static int[] removeAtIndex(int[] numbers, int index) {
        int[] newArray = new int[numbers.length-1]; // we put -1 because we remove an element
        for(int i = 0; i < index; i++) {
            newArray[i] = numbers[i];
        }
        for(int i = index; i < numbers.length-1; i++) { //we do not need an index subtraction
            newArray[i] = numbers[i + 1]; // we have to assign a value in the index
        }
        return newArray;
    }

    // Given an input array and a number n, this method should find the n-th largest number in the array. Here, 1-st largest just means largest.
    public static int getNthLargest(int[] numbers, int n) {
        int[] newNumbers = cloneArray(numbers);
        sortAscending(newNumbers);
        //what if the array has the same numbers???? burayı da sor
        return newNumbers[newNumbers.length - n];
    }

    // Return the median of the provided array.
    // Hint: This code only works properly when the input array has odd length. What goes wrong when the array has even length?
    public static double getMedian(int[] numbers) {
        int[] newNumbers = cloneArray(numbers);
        sortAscending(newNumbers);
        
        if ( newNumbers.length % 2 == 1) {
        	int length = newNumbers.length/2;
        	return newNumbers[length];
        }
        else {
        	int length = newNumbers.length/2;
        	double result = (newNumbers[length-1] + newNumbers[length])/2.0;
        	return result;
        }
        
    }

    // Here we are doing the most basic way of sorting an array.
    // At each step, we find the next smallest element in the list, and add that to the next location in the array.
    // TODO: DO NOT IMPLEMENT a sortAscending method with totally different logic, 
    // TODO: FIX this one
    public static void sortAscending(int[] numbers) {
        for(int i = 0; i < numbers.length; i++) {
            int index = i;
            for(int j = i + 1; j < numbers.length; j++) {
                if(numbers[j] < numbers[index]) {
                    index = j;
                }
            }
            int nextElement = numbers[i]; //we define a new temporary variable
            numbers[i] = numbers[index];  // we first change the ith index because it starts from 0
            numbers[index] = nextElement; // then we take the smallest index and put our temp value
            
        }
    }

    public static void sortDescending(int[] numbers) {
        // TODO: Once you have fixed sortAscending, use the same idea to write a sortDescending method
        for(int i = 0; i < numbers.length; i++) {
            int index = i;
            for(int j = i + 1; j < numbers.length; j++) {
                if(numbers[j] > numbers[index]) { // we just change the small symbol to big symbol
                    index = j;
                }
            }
            int nextElement = numbers[i]; //we define a new temporary variable
            numbers[i] = numbers[index];  // we first change the ith index because it starts from 0
            numbers[index] = nextElement; // then we take the biggest index value and put our temp value
            
        }
    }

     // Helper method to clone arrays for sorting (DO NOT MODIFY)
    public static int[] cloneArray(int[] numbers) {
        int[] newArray = new int[numbers.length];
        for(int i = 0; i < numbers.length; i++) {
            newArray[i] = numbers[i];
        }
        return newArray;
    }

    // Helper function to print the array (DO NOT MODIFY)
    public static void printArray(int[] array) {
        System.out.print("[");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if(i != array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }
}
