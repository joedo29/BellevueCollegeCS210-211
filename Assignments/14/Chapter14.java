/*
 * Name: Phuong Do (Joe)
 * Date: July 24 2017
 * Course: CS211
 * Assignment #14
 * Purpose: Work on Exercises #2, #5, #15, #19 in the BJP text
 * plus additional requirements adhere to only using Stack Operations.
 */ 

import java.util.*;

public class Chapter14 {
	
	// #19 removeMin
	// removeMin accepts a stack of integers as a parameter and removes and returns the smallest value from the stack
	public static Stack<CalendarDate> removeMin(Stack<CalendarDate> testAll){
		Queue<CalendarDate> q = new LinkedList<CalendarDate>(); // for auxiliary storage
		CalendarDate min = testAll.peek();
	
		while(!testAll.empty()){
			CalendarDate n = testAll.pop();
			q.add(n);
			if(n.compareTo(min) == -1){
				min = n;
			}
		} // now we know the smallest value
		
		while(!q.isEmpty()){ // transfer every queue value to the stack except the min value
			if(q.peek().compareTo(min) != 0){
				testAll.push(q.remove());
			} else{
				q.remove();
			}
		}
		
		while(!testAll.empty()){
			q.add(testAll.pop());
		}
		while(!q.isEmpty()){
			testAll.push(q.remove());
		}
		return testAll;
	} // closes removeMin method 
	
	
	// #15 isSorted method
	// isSorted accepts a stack of integers and returns true if the elements in 
	// the stack occur in ascending (nondecreasing) order from top to bottom
	public static boolean isSorted(Stack<CalendarDate> testAll){
		boolean check = true;
		boolean sorted = true;
		Stack<CalendarDate> temp = new Stack<CalendarDate>(); // for auxiliary storage
		
		if(testAll.size() == 0 || testAll.size() == 1){
			return sorted;
		} else{
			CalendarDate smallestNumber = testAll.pop();
			temp.push(smallestNumber);
			while(!testAll.empty() && check){
				CalendarDate s1 = testAll.pop();
				temp.push(s1);
				if(s1.compareTo(smallestNumber) != 1 || s1.compareTo(smallestNumber) != 0){
					sorted = false;
					check = false;
				}
			}
		}
		while(!temp.empty()){
			testAll.push(temp.pop());
		}
		return sorted;
	} // closes isSorted method

	
	// #2 stutter method
	// this method accepts a stack of integer and replaces every value in the stack with two occurrences of that value
	public static Stack<CalendarDate> stutter(Stack<CalendarDate> testAll){
		Queue<CalendarDate> q = new LinkedList<CalendarDate>(); // for auxiliary storage
		Stack<CalendarDate> s = new Stack<CalendarDate>();
		
		while(!testAll.empty()){ // add every values of the stack to a queue
			q.add(testAll.pop());
		}
		
		while(!q.isEmpty()){ // transfer all values back to the stack in a reversed order
			testAll.push(q.remove());
		}
		
		while(!testAll.empty()){ // transfer the reversed order to a queue
			q.add(testAll.pop());
		}
		
		while(!q.isEmpty()){ // transfer all values back to the stack with two occurrences of each value
			CalendarDate n = q.remove();
			s.push(n);
			s.push(n);
			testAll.push(n);
		}
		return s;
	} // closes stutter method
	
	
	// #5 equals method
	// this method accepts two stacks and return true if they store exactly the same sequence of integer values in the same order	
	public static boolean equals(Stack<CalendarDate> stack1, Stack<CalendarDate> stack2){
		boolean areEqual = true;
		boolean check = true;
		if (stack1 == stack2){ // account for the case when two objects are the same
			return true;
		}
		Stack<CalendarDate> temp = new Stack<CalendarDate>(); // for auxiliary storage
				
		if(stack1.size() != stack2.size()){
			return !areEqual;
		} else{
			while(!stack1.empty() && check){
				CalendarDate s1 = stack1.pop();
				CalendarDate s2 = stack2.pop();
				temp.push(s1);
				temp.push(s2);				
				if(s1.compareTo(s2) != 0){
					areEqual = false;
					check = false;
				}
			}
			while(!temp.empty()){
				stack2.push(temp.pop());
				stack1.push(temp.pop());
			}
		}
		return areEqual;
	} // closes equals method

} // Closes Chapter14 class - completed assignment 14
