// CS210 Assignment 4 (Guessing Game)
// Phuong / Do
// The purpose of this program is to build a guessing game using while loop and random number

import java.util.*;//for Scanner

public class GuessingGame{
	
	public static void main (String[] args){
      System.out.println("Player is thinking of a number between 1 and 100.");
      Scanner console = new Scanner(System.in);
      Random rand = new Random();

      int highBound = 101; 
      int lowBound = 1;
      boolean guesser = true;
      while (guesser){
         int computerGuess = (rand.nextInt(highBound-lowBound) + lowBound);
         System.out.println("Computer guesses: " + computerGuess);
         System.out.print("Player responds, this is (high, low, correct): ");
         String input = console.next();
         
// Controls change to guess range if user says "low"
         if (input.startsWith("l")){
            lowBound = computerGuess;
         } 
         
// Controls change to guess range if user says "high"
         else if (input.startsWith("h")){
            highBound = computerGuess;
         }
         
// Ends guessing cycle if user says "correct" and starts a new round if user says "Y"
         else if (input.startsWith("c")){
            guesser = false;
            System.out.print("Play Again? (Y/N)");
            String replay = console.next();
            if (replay.startsWith ("y")){
               System.out.println();
               System.out.println("Player is thinking of a number between 1 and 100.");
               guesser = true;
               highBound = 101;
               lowBound = 1;
            } else if (replay.startsWith("n")){ 
               System.out.println("Thanks for playing!");
               guesser = false;
            }
         } // closes else if
                
   
      } // closes while loop
   } // closes main
} // closes class

