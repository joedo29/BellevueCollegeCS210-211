/**
 * Name: Phuong Do (Joe)
 * Date: July 13 2017
 * Course: CS211
 * Quiz #12
 * Purpose: Write a public static method toBinaryString that accepts an integer parameter
 * n and returns a String representation of a single integer argument as an unsigned integer in base 2 
 */ 

public class Quiz12 {
	public static void main (String [] args){
		System.out.println(Quiz12.toBinaryString(43));  // "101011"

		System.out.println(Quiz12.toBinaryString(8));  // "1000"

		System.out.println(Quiz12.toBinaryString(0));  // "0"
	}
	
	// Note for base-2: Even number ends in 0 
	// odd number ends in 1
	// base-2 representation of (n / 2)
	// the final digit (n % 2)
    public static String toBinaryString(int n) { // Assume a value of n between 0 to MAX_INT.
    	if (n == 0){
    		return String.valueOf(0);
    	}
    	if (n == 1){
    		return String.valueOf(1);
    	} else {
    		return toBinaryString(n/2) + n % 2;
    	}
    } // closes toBinaryString method
    
} // closes Quiz12, completed the quiz
