package tickets;
/**
 * Name: Phuong Do (Joe)
 * Date: July 02 2017
 * Course: CS211
 * Assignment #9, exercise 7 - Second submission
 * Purpose: implememt a class called AdvanceTicket to represent tickets purchased in advance
 */ 

public class AdvanceTicket extends Ticket{

   // This method is used for constructor
   public AdvanceTicket(){
   this(0, 1);
   }

   // This method is used for constructor with data other than zero
   public AdvanceTicket(int number, int numberOfDay){
      super(number);
      if (numberOfDay > 10){
         this.price = 30.0;
      } 
      else if (numberOfDay <= 10 && numberOfDay > 0){
         this.price = 40.0;
      } else {
         throw new IllegalArgumentException(" Day can not be zero or negative.");
      }
   } // closes AdvanceTicket method
   
   // ACCESSORS
   public double getPrice(){
      return this.price;
   }
   
} // closes AdvanceTicket class