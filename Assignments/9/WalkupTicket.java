package tickets;
/**
 * Name: Phuong Do (Joe)
 * Date: July 02 2017
 * Course: CS211
 * Assignment #9, exercise 6 - Second submission
 * Purpose: implememt a class called WalkupTicket to represent a walk-up event ticket
 */

public class WalkupTicket extends Ticket{
   
   // This method is used for constructor
   public WalkupTicket(int number){
      super (number);
   }
   
   // ACCESSORS
   public double getPrice(){
      return price = 50.0;
   }
} // closes class WalkupTicket