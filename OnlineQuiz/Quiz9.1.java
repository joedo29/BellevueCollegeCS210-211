/**
 * Name: Phuong Do (Joe)
 * Date: June 29 2017
 * Course: CS211
 * Assignment: Chapter 9 quiz
 * Purpose: Learning how to implement Interface
 */
 
public class Pentagon implements Shape{
   private double a;
   
   // MUTATOR
   // construct a new pentagon with the given length
   public Pentagon(double a){
      this.a = a;
   }
   
   // return Pentagon area
   public double getArea(){
      return Math.sqrt(5 * (5 + 2 * Math.sqrt(5))) * a * a / 4;
   }
   
   // return Pentagon perimeter
   public double getPerimeter(){
      return 5 * a;
   }
}