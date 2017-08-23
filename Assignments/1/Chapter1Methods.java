//CS210 Assignment 1 (Methods)
//Phuong / Do


public class Chapter1Methods {

   public static void first() {
      System.out.println("first method");
      second();
   }
 
   public static void second() {
      System.out.println("second method");
   }
 
   public static void third() {
      System.out.println("third method");
      first();
   } 
 
   public static void main(String[] args) {
    // DO NOT change this main method
      first();
      third();
      second();
      third();
   }
}


// output
// first method
// second method
// third method
// first method
// second method
// second method
// third method
// first method
// second method