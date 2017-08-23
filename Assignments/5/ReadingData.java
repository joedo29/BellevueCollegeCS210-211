// CS210 Assignment 5
// Phuong / Do
// May 15, 2017
// Current quarter: Spring 2017
// The purpose of this assignment is to practice reading information from an external data source and respond accordingly

import java.io.*;
import java.util.*;

public class ReadingData{
   
   public static void main (String [] args)
	      throws FileNotFoundException { // Handle exceptions and reprompt for the file should the user provide an erroneous input
      
      // Load the indicated dataset into an array object using a method that allows for variations in list length
      double[] age = new double[14];
      String[] id = new String[14];
      String[] name = new String [14];
      String[] gender = new String[14];
      
      // Prompt the user for the name of the dataset to load
      Scanner console = new Scanner(System.in);
      System.out.print("Please input a filename to load: ");
      File filename = new File (console.nextLine());
      
      // Verify whether the filename is readable      
      while (!filename.canRead()){
         System.out.println("File not found.  Try again.");
         System.out.print("input file name? ");
         filename = new File (console.nextLine());
      }
      
      // Ask users whether they want to display male or female student entries
      // Also make sure users enter the right value
      System.out.print("Parse by gender (M/F): ");
      String sex = console.next();
      while (!sex.startsWith("m") && !sex.startsWith("f")){
         System.out.println("Incorrect input for gender");
         System.out.print("Parse by gender again (M/F): ");
         sex = console.next();
      }
      Scanner input = new Scanner (filename);
      
      System.out.println("==============================="); 
      int counter = 0;
      double sumAge = 0;
      int index = -1;   
         
	   while (input.hasNext()){ // Retrieve data from file
         index++;
         if (sex.startsWith("m")){ // Retrieve and display data for male student
            id [index] = input.next();
   		   name [index] = input.next();
            gender [index] = input.next();
   		   age [index] = input.nextDouble();
               if (gender[index].startsWith("m")){
                  System.out.println(String.format("%-5s", id [index]) + String.format("%-10s", name [index]) + String.format("%12.1f", age [index]) );
                  counter++;
                  sumAge = sumAge + age [index];
               }
            
         } // closes first if statement 
      
         else if (sex.startsWith("f")){ // Retrieve and display data for female student
            id [index]  = input.next();
      		name [index] = input.next();
            gender [index] = input.next();
      		age [index] = input.nextDouble();
               if (gender[index].startsWith("f")){
                  System.out.println (String.format("%-5s", id [index]) + String.format("%-10s", name [index]) + String.format("%12.1f", age [index]));
                  counter++;
                  sumAge = sumAge + age [index];
               }
         } // closes second else if statement      
      
	   } // closes while loop
   
      if (sex.startsWith("m")){ // Output a summary statement for male students
         System.out.println ();
         System.out.println ("There are (" + counter + ") male students.");
         System.out.println ("Their average age is (" + (sumAge / counter) + ").");
      } else if (sex.startsWith("f")){ // Output a summary statement for female students
         System.out.println ();
         System.out.println ("There are (" + counter + ") female students.");
         System.out.println ("Their average age is (" + (sumAge / counter) + ").");
      }
      System.out.println("===============================");      
         
  } // closes main  
  
} // closes ReadingData class
