//package Exercise;
/**
 * Name: Phuong Do (Joe)
 * Date: July 10 2017
 * Course: CS211
 * Assignment #11
 * Purpose: create a Class called FileCharCount that provides char counts for any text file
 */ 
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class FileCharCount {

	public static void main(String[] args) throws FileNotFoundException{
		System.out.println("This program display the most frequently occurring characters from the book Moby Dick.");
		System.out.println();
		 
		// Import a text file
		Scanner in = new Scanner(new File("/Users/jeodo/Documents/workspace/Chapter11/src/Exercise/mobydick.txt"));
		Set<CharInt> wordCountSet = getCountSet(in);
		
		for (CharInt value: wordCountSet){
			System.out.println(value);
		}
	}
	
	// Read each word from the text, get a total count and add it to the TreeSet
	public static Set<CharInt> getCountSet(Scanner in){
		Set<CharInt> wordCountSet = new HashSet<CharInt>();
		
		while (in.hasNext()){
			String word = in.next().toLowerCase();
			for(int i = 0; i < word.length(); i++){
	            char test = word.charAt(i);
	            CharInt dummy = new CharInt(test, 0);
	            
	   			if(wordCountSet.contains(dummy)){ // This char is already existed in the text file
	   				int count = 0;
	   				for(CharInt value: wordCountSet){
	   					if (wordCountSet.contains(dummy)){
	   						count++;
	   					}
	   				}
	   				CharInt existingValue = new CharInt(test, count);
	   				wordCountSet.add(existingValue);
	   			} else { // This char isn't in the text file, add it to the Set
	   				CharInt newValue = new CharInt(word.charAt(i), 1);
	   				wordCountSet.add(newValue);
	   			}
			}
		}
		return wordCountSet;
	} // Closes getCountSet method

} // Closes fileCharCount class

