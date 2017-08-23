//package Exercise;
/**
 * Name: Phuong Do (Joe)
 * Date: July 10 2017
 * Course: CS211
 * Assignment #11
 * Purpose: CharInt class is a customized data structure that implements Comparable<CharInt> and Comparator<CharInt>
 * to provide the correct sorting
 */ 
import java.io.*;
import java.io.FileNotFoundException;
import java.util.*;

public class CharInt implements Comparable<CharInt>, Comparator<CharInt>{
   private char character;
   private int count;
   
   // Create a constructor to accept a char and a count Int
   public CharInt (Character character, Integer integer){
	   this.character = character;
	   this.count = integer;
   }
   
   // ACCESSOR: implement getCount() method
   public int getCount(){
	   return count;
   }
   
   // override compareTo method - Compares this object with the specified object for order.
   public int compareTo(CharInt o){
	   int setCount = o.getCount();
	   
	   //descending
	   return setCount - this.count;
   }
   
   // compare(T o1, T o2) Compares its two arguments for order.
   public int compare(CharInt o1, CharInt o2){
	   return o1.count - o2.count;
   }
   
   // equals(Object obj) - Indicates whether some other object is "equal to" this comparator.
   public boolean equals(CharInt obj){ // compare c to c11
		return (this.character == obj.character);   
   }
   
   // toString() method to print out CharInt
   public String toString() {
       return this.character + "=" + this.count;
   }

}
