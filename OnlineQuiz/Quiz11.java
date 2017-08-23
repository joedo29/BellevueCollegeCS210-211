// package Exercise;
/**
 * Name: Phuong Do (Joe)
 * Date: July 11 2017
 * Course: CS211
 * Quiz #11
 * Write two methods: detail of each method is described below 
 */ 
import java.util.*;

public class Quiz11 {
    public static void main(String[] args) {
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        list1.add(1);  list1.add(1);  list1.add(1);  list1.add(2);  list1.add(3);
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(3);  list2.add(4);  list2.add(5); list2.add(2); list2.add(2); list2.add(2);
        System.out.println(Quiz11.maxOccurrences(list1)); // 3
        System.out.println(Quiz11.maxIntersections(list1, list2)); // 4
}
    // METHOD 1
    // Write a public static method maxOccurrences that accepts a list of Integers 
    // as a parameter and returns the number of times the most frequent occurring integer (the "mode") occurs in the list. 
    public static int maxOccurrences(List<Integer> list1) {
        Map<Integer, Integer> myMap = new TreeMap<Integer, Integer>();
        int newValue = 0;
        for(int number : list1) { // run through every value in myList
            if(myMap.containsKey(number)) { // if myMapap contains number, add number to myMap and increment value by 1
            	myMap.put(number, myMap.get(number) + 1);
            } else {
            	myMap.put(number, 1);
            }
            if(myMap.get(number) > newValue){ // if current Map's value is greater than newValue, set newValue to current Map's value
            	newValue = myMap.get(number);
            }	
        }
        return newValue;
    } // closes maxOccurrences method
    
    // METHOD 2
    //  Write a public static method maxIntersections that accepts two lists of Integers
    // and returns the number of times the most frequent Integer occurs only when in both lists.  
    // For example, for list1=[1,1,1,2,3] and list2=[3,4,5], then maxIntersections(list1,list2) would return two as the 3 is in both lists so seen twice.  If no elements are common to both lists, return 0.
    public static int maxIntersections(List<Integer> list2, List<Integer> list3){
		List<Integer> finalList = new ArrayList<>(); // create a new list to store all common value
		for(int i: list2){
			if(list3.contains(i)){
				finalList.add(i);
			}
		}
		for (int j: list3){
			if(list2.contains(j)){
				finalList.add(j);
			}
		}
		// now that we have a list of all common value, return the most occurrences of a number
		int max = 0;
		for (int i = 0; i < finalList.size(); i++) {
			int count = 0;
			for (int j = 0; j < finalList.size(); j++) {
				if (finalList.get(i) == finalList.get(j)){
					count++;
				}
				if (count >= max)
					max = count;
		 }
    }
		return max;
    } // Closes macIntersections
    
} // completed Quiz11 class