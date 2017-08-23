/**
 * Name: Phuong Do (Joe)
 * Date: July 06 2017
 * Course: CS211
 * Quiz #10
 * Write a method minToFront that takes an ArrayList of Strings as a parameter and that moves the minimum value 
 * (as defined by .compareTo) in the list to the front, otherwise preserving the order of the elements.
 */ 
import java.util.ArrayList;

public class Quiz10{
	public static void main(String[] a) {
     ArrayList<String> words = new ArrayList<String>();
     words.add("three");  words.add("two");  words.add("one");
     words.add("four");  words.add("two");  words.add("five");
     System.out.println("original list: " + words); // [three, two, one]
     
     minToFront(words);
     System.out.println("Bring min value to front: " + words);
     }
 
// create a static method to compare string values in the ArrayList
	public static void minToFront(ArrayList<String> easy){
		String minValue = "";
		int min = 0;
			for (int j = 1; j < easy.size(); j++){
				if (easy.get(min).compareTo(easy.get(j)) > 0){
					minValue = easy.get(j);
					min = j;
				}
			}
		easy.remove(min);
		easy.add(0, minValue);
      
	} // closes minToFront1 method
	
} // closes Quiz10 class