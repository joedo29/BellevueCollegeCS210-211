/**
 * Name: Phuong Do (Joe)
 * Date: July 12 2017
 * Course: CS211
 * Assignment #12
 * Purpose: Write a faster version that is still recursive, but far more efficient, and can handle very BIG int's
 */ 
import java.io.*;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.*;

public class Fibonacci {
	public static void main(String[] args) {
        int test = 45; // I will limit my test code to passing int parameters
        BigInteger test2 = new BigInteger("9000"); // only needed for overload
        System.out.println(theBigFib(test)); // a fast recursive version
        System.out.println(theBigFib(test2)); // overload, using same as above
        System.out.println(fibonacci(test)); // slow version in text   
    }

	// this is a slow version (from the instructor) to find Fibonacci number
    public static int fibonacci(int n) {
        if (n<=2) {
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
    
    // Math method to find Fibonacci number in a more efficient way
    // though this method is not required for this assignment, it's easy to build this method prior to writing recursive code
	public static int findFibonacciNumber(int number){
		int first = 0, second = 1;
		if (number == 0){
			return 0;
		}
		
		if (number == 1){
			return 1;
		} else {
			for (int i = 2; i <= number; i++){
				int sum = first + second;
				first = second;
				second = sum;
			}
		}
		return second;
	}
	
	// Convert findFibonacciNumber math method to recursive code and implement BigInteger
	// this is an improved method that receives int value
	public static BigInteger theBigFib(int value){
		if (value == 0){
			return BigInteger.ZERO;
		}
		if (value == 1){
			return BigInteger.ONE;
		}
		else {
		    return theBigFib(BigInteger.ZERO, BigInteger.ONE, 2, value);
		}
	}
	
	// this is a helper for BigInteger method 
	public static BigInteger theBigFib(BigInteger first, BigInteger second, int count, int value){
		if (count > value){
			return second; 
		}
		return theBigFib(second, first.add(second), count + 1, value);
	}
	
    // this is an improved method that receives BigInteger value
    public static BigInteger theBigFib(BigInteger bigValue) {
    	int convertToInt = bigValue.intValue();
    	return theBigFib(BigInteger.ZERO, BigInteger.ONE, 2, convertToInt);
    }
    
} // closes class Fibonacci - completed assignment #12
