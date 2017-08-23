/*
 * Name: Phuong Do (Joe)
 * Date: July 25 2017
 * Course: CS211
 * Quiz #14
 * Purpose: write two public static methods called 'mirror' that returns the stack contents with itself
 * plus a mirroed version of itself
 */ 

import java.util.*;

public class Quiz14 {
	public static void main(String[] args){
		Random r = new Random();
		// test data for mirror stack
		Stack<Integer> s = new Stack<Integer>();
		for (int i = 0; i <= 5; i++){
			s.push(r.nextInt(100));
		}
		System.out.println("Mirror Stack: " + mirror(s));
		System.out.println(s);
		
		// test data for mirror queue
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 0; i <= 5; i++){
			q.add(r.nextInt(100));
		}
		System.out.println("Mirror Queue: " + mirror(q));
		System.out.println(q);
		
	}
	
	// this mirror method accepts a stack of integers as a parameter
	public static Stack<Integer> mirror(Stack<Integer> s){
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		Queue<Integer> q = new LinkedList<Integer>();
		
		if(s.size() == 0){
			return s1;
		} else{
			while(!s.empty()){
				int n = s.pop();
				q.add(n);
				s2.push(n);
			}
			while(!s2.empty()){
				int n = s2.pop();
				s1.push(n);
				s.push(n);
			}
			while(!q.isEmpty()){
				s1.push(q.remove());
			}
		}
		return s1;
	} // closes mirror (for stack) method 
	
	// this mirror method accepts a queue of integers as a parameter
	public static Queue<Integer> mirror(Queue<Integer> q){
		Queue<Integer> q1 = new LinkedList<Integer>();
		Queue<Integer> q2 = new LinkedList<Integer>();
		Stack<Integer> s = new Stack<Integer>();
		
		if(q.size() == 0){
			return q1;
		} else{
			while(!q.isEmpty()){
				int n = q.remove();
				q1.add(n);
				s.push(n);
			}
			while(!q1.isEmpty()){
				int n = q1.remove();
				q2.add(n);
				q.add(n);
			}
			while(!s.empty()){
				int n = s.pop();
				q2.add(n);
			}
		}
		return q2;
	} // closes mirror (for queue) method
	
} // closes Quiz14 class - completed quiz #14
