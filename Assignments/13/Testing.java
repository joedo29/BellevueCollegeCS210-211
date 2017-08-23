/**
 * Name: Phuong Do (Joe)
 * Date: July 17 2017
 * Course: CS211
 * Assignment #13
 * Purpose: Use the System clock (milliseconds) 
 * and demonstrate the run-time complexity, O(N), O(N^2), O(N^N), O(1), etc...  for the "bogus" sorting algorithm
 */ 

import java.util.*;

public class Testing {
	public static void main (String [] args){
		ArrayList<Integer> list = new ArrayList<Integer>();

		// test elements (range from 5 to 14)
		Integer [] listInteger = new Integer[] {21, 20, 22, 8, 3, 10, 4, 6, 7, 9, 0, 11, 14, 17}; 
		list.addAll(Arrays.asList(listInteger));
		
		long startTime = System.currentTimeMillis(); // begin counting time
		System.out.println(bogoSort(list)); // runs bogoSort and print out sorted list
		
		long endTime = System.currentTimeMillis(); // end counting time
		System.out.println("This program took "+ (endTime - startTime) + " ms to run."); 
	}

	// build algorithm to shuffle an array until it's sorted
	public static ArrayList<Integer> bogoSort(ArrayList<Integer> list){
		while(!isSorted(list)){
		Collections.shuffle(list);
		}
		return list;
	} // closes bogoSort method
		
	// This method is to test whether the list is sorted
	private static boolean isSorted(ArrayList<Integer> list){
	    for (int i = 0; i < list.size()-1; i++) {
	        if(list.get(i).compareTo(list.get(i+1)) > 0){
	        	return false;
	        } 
	    }
	    return true;
	} // closes isSorted method

} // closes Testing class