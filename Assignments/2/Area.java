// CS210 Assignment 2 (Area)
// Phuong / Do
// The purpose of this program is to practice using Scanner and if/else statement.

import java.util.*;//for Scanner

public class Area{
   static String name1;
   static String name2;
   static double area1;
   static double area2;
	
	public static void main (String[] args){
      firstSelection();
      System.out.println();
      secondSelection();
      System.out.println();
      comparison();
      }
      
// ask user to make the first selection and collect user inputs      
   public static void firstSelection(){ 
      Scanner userInput = new Scanner(System.in);

      System.out.println("We have three shapes: 1) Rectangle 2) Triangle 3) Circle");
      System.out.print("Please select your favorite shape     :");
      
      int f = userInput.nextInt();
      if (f==1){
         rectangleValue1(); 
      } else if (f==2){
         triangleValue1(); 
      } else if (f==3){
            circleValue1(); 
      }
   } 
   
// ask user to make the second selection and collect user inputs
   public static void secondSelection(){ 
      Scanner userInput = new Scanner(System.in);

      System.out.println("We have three shapes: 1) Rectangle 2) Triangle 3) Circle");
      System.out.print("Please select your favorite shape     :");
      
      int f = userInput.nextInt();
      if (f==1){
         rectangleValue2(); 
      } else if (f==2){
         triangleValue2();
      } else if (f==3){
         circleValue2();
      }
   } 
   
   public static void rectangleValue1(){ //obtain rectangular value for first selection
         Scanner userInput = new Scanner(System.in);

         System.out.println ("Enter values for rectangle area:");
         System.out.print("Rectangle width     :");
         double width = userInput.nextDouble();
         System.out.print("Rectangle height    :");
         double height = userInput.nextDouble(); 
         double rec = recArea (width, height);
         
         System.out.println("Rectangle area = " + rec);
         name1 = "Rectangle";
         area1 = rec;
   }
   
   public static void triangleValue1(){ //obtain triangle value for first selection
         Scanner userInput = new Scanner (System.in);
         
         System.out.println ("Enter values for triangle area:");
         System.out.print("Triangle base       :");
         double base = userInput.nextDouble();
         System.out.print("Triangle height     :");
         double height = userInput.nextDouble(); 
         double tri = triArea (base, height);
         
         name1 = "Triangle";
         area1 = tri;
         System.out.println("Triangle area = " + tri);
   }
   
   public static void circleValue1(){ //obtain circle value for first selection
         Scanner userInput = new Scanner (System.in);
                  
         System.out.println ("Enter values for circle area:");
         System.out.print("Radius              :");
         double r = userInput.nextDouble();
         double cir = cirArea (r);
         
         name1 = "Circle";
         area1 = cir;
         System.out.println("Circle area = " + (int) cir);
   }
   
   public static void rectangleValue2(){ //obtain rectangular value for second selection
         Scanner userInput = new Scanner(System.in);

         System.out.println ("Enter values for rectangle area:");
         System.out.print("Rectangle width     :");
         double width = userInput.nextDouble();
         System.out.print("Rectangle height    :");
         double height = userInput.nextDouble(); 
         double rec = recArea (width, height);
         
         System.out.println("Rectangle area = " + rec);
         name2 = "Rectangle";
         area2 = rec;
   }
   
   public static void triangleValue2(){ //obtain triangle value for second selection
         Scanner userInput = new Scanner (System.in);
         
         System.out.println ("Enter values for triangle area:");
         System.out.print("Triangle base       :");
         double base = userInput.nextDouble();
         System.out.print("Triangle height     :");
         double height = userInput.nextDouble(); 
         double tri = triArea (base, height);
         
         name2 = "Triangle";
         area2 = tri;
         System.out.println("Triangle area = " + tri);
   }
   
   public static void circleValue2(){ //obtain circle value for second selection
         Scanner userInput = new Scanner (System.in);
                  
         System.out.println ("Enter values for circle area:");
         System.out.print("Radius              :");
         double r = userInput.nextDouble();
         double cir = cirArea (r);
         
         name2 = "Circle";
         area2 = cir;
         System.out.println("Circle area = " + (int) cir);
   }


// Compute area of rectangle
   public static double recArea(double width, double height){ 
      return width*height;
   }
   
// Compute area of triangle
   public static double triArea(double base, double height){ 
      return (0.5)*base*height;
   }
   
// Compute area of circle
   public static double cirArea(double r){
      return r*r* 3.14;
   }   
   
// compare two selections   
   public static void comparison(){ 
      if (area1 > area2){
         System.out.println(name1 + " seems bigger than " + name2);
      } else if (area1 == area2){
         System.out.println(name1 + " and " + name2 + " seem equal");
      }
      else {System.out.println(name2 + " seems bigger than " + name1);}
   }
}