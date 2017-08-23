// CS210 Assignment 6
// Phuong / Do
// Student ID#: 950-52-8399
// May 26, 2017
// Current quarter: Spring 2017
// The purpose of this assignment is to 
// create a database for the storage of only the user generated identities

import java.io.*;
import java.util.*;

public class UserNames{
   
   public static void main (String [] args)
	      throws FileNotFoundException {         
       // Read the list from users.txt
      Scanner someInputScanner = new Scanner(new File("users.txt"));
      someInputScanner.close();

      // Enter the names from users.txt to an array
      someInputScanner = new Scanner(new File("users.txt"));
      ArrayList<String> myArray = new ArrayList<String>();
      
      // Add username to ArrayList
      System.out.println("User Database from \"users.txt\"");
      System.out.println("===============================");
      
      while (someInputScanner.hasNext()){
         myArray.add(someInputScanner.next());
      }
      
      // Print out list of usernames
      for (int i = 0; i < myArray.size(); i++) {
         System.out.println(myArray.get(i));
      }  
      System.out.println("===============================");    
      
      // Prompt user for a new username
      Scanner console = new Scanner(System.in);
      System.out.print("Create a new user: ");
      String userName = console.next();
      
      boolean validUserName = false;
      while (!validUserName){
         boolean a = checkExisting(myArray, userName, console);
         boolean b = checkLength(userName, console);
         boolean c = checkSpecialCharacter(userName, console);
         validUserName = a && b && c;
         if (!validUserName){
            System.out.println();
            System.out.print("Please enter username again: ");
            userName = console.next();
         }
      }
      console.close();
      
      // If all three conditions passed, accept userName and write userName to users.txt
      PrintStream out = new PrintStream(new File("users.txt"));
      for (int i = 0; i < myArray.size(); i++) {
         out.println(myArray.get(i)); 
      } 
      out.println(userName);
      
      // Write new username to myArray
      myArray.add(userName);
        
      // Reprint a list of all users
      System.out.println("User \"" + userName + "\" is now added to the database.\n");
      System.out.println("Contents of \"newNameArray\":\n");
      System.out.println("===============================");
      for (int i = 0; i < myArray.size(); i++) {
         System.out.println(myArray.get(i));
      }  
      System.out.println("===============================\n");
      System.out.println ("\"newUsersArray\" is written to \"users.txt\" successfully!");
      someInputScanner.close();
         
   } // closes main method
   
   // Check new username for duplication   
   public static boolean checkExisting(ArrayList<String> myArray, String userName, Scanner console){
      boolean validUserName = true;
      for (int i = 0; i < myArray.size(); i++){
         if (userName.equalsIgnoreCase(myArray.get(i))){
            System.out.print("Username already in use. ");
            validUserName = false;
         }         
      } 
      return validUserName;  
   }
   
   // Check username for length
   public static boolean checkLength(String userName, Scanner console){
      boolean validUserName = true;
      if (userName.length() < 4 || userName.length() > 20){
         System.out.print("Username must be between 4 and 20. ");
         validUserName = false;       
      }  
      return validUserName;
   }   
  
   // Check username for valid letters
   public static boolean checkSpecialCharacter(String userName, Scanner console){   
      boolean validUserName = true;   
      for (int i = 0; i < userName.length(); i++){
         if (userName.charAt(i) < 'a' || userName.charAt(i) > 'z'){
            validUserName = false;  
         }   
      }
      if (!validUserName){
         System.out.print("Invalid input (only select character from a - z). ");
      }
      return validUserName;
   }    

} // Closes class