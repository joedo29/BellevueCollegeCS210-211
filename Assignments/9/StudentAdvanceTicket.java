package tickets;
/**
 * Name: Phuong Do (Joe)
 * Date: July 02, 2017
 * Course: CS211
 * Assignment #9, exercise 8 - Second submission
 * Purpose: implememt a class called AdvanceTicket to represent tickets purchased in advance by studen
 */ 

public class StudentAdvanceTicket extends AdvanceTicket{
   
   // This method is used for constructor with default data to zero
   public StudentAdvanceTicket() {
      this(0,1);
   }

   // This method is used for constructor with data other than zero
   public StudentAdvanceTicket(int number, int numberOfDay){
      super(number, numberOfDay);
      this.price = this.price / 2;
   } // closes StudentAdvanceTicket method
   
   // accessor
   public double getPrice(){
      return this.price;   
   }
   
   // override
    public String toString() {
        return super.toString() + " (ID Required)";
    }   
} // closes StudentAdvanceTicket class