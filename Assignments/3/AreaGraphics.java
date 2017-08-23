// CS210 Assignment 3 (Graphic & Code Reuse)
// Phuong / Do
// The purpose of this program is to reuse the code from assignment 2 and apply
// what we learn about drawing graphic to draw shapes based on user inputs

import java.util.*;// for Scanner

import java.awt.*; // for graphic

public class AreaGraphics{
   public static final int WIDTH = 1200;
   public static final int HEIGHT = 600;
   static String name1;
   static String name2;
   static double area1;
   static double area2;
   static double width1, height1;   
   static double width2, height2;
   static double base1, base2;
   static double radius1, radius2;
   
	public static void main (String[] args){
      firstSelection();
      System.out.println();
      secondSelection();
      
      // Set up drawing panel
      DrawingPanel panel = new DrawingPanel(WIDTH, HEIGHT);
        panel.setBackground(Color.BLACK);
      Graphics g = panel.getGraphics();
      
      drawFirstFigure(g);
      drawSecondFigure(g);
      summaryStatement(g);
      
      //draw line
      g.setColor(Color.white);
      g.drawLine(600, 0, 600, 500);
      g.drawLine(0, 500, 1200, 500);
      }
   
// ask user to make the first selection and collect user inputs    
   public static void firstSelection(){ 
      Scanner userInput = new Scanner(System.in);

      System.out.print("Define the first shape (rectangle, triangle, circle): ");
      
      String firstShape = userInput.next();
      if (firstShape.equalsIgnoreCase("rectangle")){

         System.out.println ("Enter values for rectangle area:");
         System.out.print("Rectangle width(500 max)     :");
         width1 = userInput.nextDouble();
         System.out.print("Rectangle height(400 max)    :");
         height1 = userInput.nextDouble(); 
         double rec = recArea (width1, height1);
         
         System.out.println("Rectangle area = " + rec);
         name1 = "Rectangle";
         area1 = rec; 
 
      } else if (firstShape.equalsIgnoreCase("triangle")){
         
         System.out.println ("Enter values for triangle area:");
         System.out.print("Triangle base (500 max)       :");
         base1 = userInput.nextDouble();
         System.out.print("Triangle height (400 max)     :");
         height1 = userInput.nextDouble(); 
         double tri = triArea (base1, height1);
         
         name1 = "Triangle";
         area1 = tri;
         System.out.println("Triangle area = " + tri);

      } else if (firstShape.equalsIgnoreCase("circle")){
                  
            System.out.println ("Enter values for circle area:");
            System.out.print("Radius (200 max)              :");
            radius1 = userInput.nextDouble();
            double cir = cirArea (radius1);
            
            name1 = "Circle";
            area1 = cir;
            System.out.println("Circle area = " + (int) cir); 
      }
   } 
   
// ask user to make the second selection and collect user inputs
   public static void secondSelection(){ 
      Scanner userInput = new Scanner(System.in);

      System.out.print("Define the second shape (rectangle, triangle, circle): ");
      
      String secondShape = userInput.next();
      if (secondShape.equalsIgnoreCase("rectangle")){
         System.out.println ("Enter values for rectangle area:");
         System.out.print("Rectangle width (500 max)     :");
         width2 = userInput.nextDouble();
         System.out.print("Rectangle height (400 max)    :");
         height2 = userInput.nextDouble(); 
         double rec = recArea (width2, height2);
         
         System.out.println("Rectangle area = " + rec);
         name2 = "Rectangle";
         area2 = rec; 
      } else if (secondShape.equalsIgnoreCase("triangle")){
         System.out.println ("Enter values for triangle area:");
         System.out.print("Triangle base (500 max)       :");
         base2 = userInput.nextDouble();
         System.out.print("Triangle height (400 max)     :");
         height2 = userInput.nextDouble(); 
         double tri = triArea (base2, height2);
         
         name2 = "Triangle";
         area2 = tri;
         System.out.println("Triangle area = " + tri); 
      } else if (secondShape.equalsIgnoreCase("circle")){
               System.out.println ("Enter values for circle area:");
               System.out.print("Radius (200 max)              :");
               radius2 = userInput.nextDouble();
               double cir = cirArea (radius2);
               
               name2 = "Circle";
               area2 = cir;
               System.out.println("Circle area = " + (int) cir);
      }
   } 
   
// Set color for the first figure
   public static void getFirstColor(Graphics g){
      if (area1 > area2){
            g.setColor(Color.green);
         } else if (area1 < area2){
            g.setColor(Color.red);
         } else if (area1 == area2){
            g.setColor (Color.yellow);
         }
   }

// Set color for the second figure
   public static void getSecondColor(Graphics g){
      if (area2 > area1){
            g.setColor(Color.green);
         } else if (area2 < area1){
            g.setColor(Color.red);
         } else if (area1 == area2){
            g.setColor (Color.yellow);
         }
   }
   
// draw the first figure
   public static void drawFirstFigure(Graphics g){
      if (name1.equalsIgnoreCase("rectangle")){
         getFirstColor(g);
         g.fillRect(100, 100, (int) width1, (int) height1);
   } else if (name1.equalsIgnoreCase("triangle")){
            //Triangle start at x=100, y=400
            getFirstColor(g);
            Polygon poly = new Polygon();
            poly.addPoint(100, 400);
            poly.addPoint(100 + (int) base1, 400);
            poly.addPoint(300, 400 - (int) height1);
            g.fillPolygon(poly);
     } else if (name1.equalsIgnoreCase("circle")){
            getFirstColor(g);
            g.fillOval(100, 100, (int) radius1*2, (int) radius1*2);
     }
   }
   
// draw the second figure
   public static void drawSecondFigure(Graphics g){
      if (name2.equalsIgnoreCase("rectangle")){
         getSecondColor(g);
         g.fillRect(700, 100, (int)width2, (int)height2);
   } else if (name2.equalsIgnoreCase("triangle")){
            //Triangle start at x=700, y=400
            getSecondColor(g);
            Polygon poly = new Polygon();            
            poly.addPoint(700, 400);
            poly.addPoint(700 + (int) base2, 400);
            poly.addPoint(900, 400 - (int) height2);            
            g.fillPolygon(poly);
     } else if (name2.equalsIgnoreCase("circle")){
            getSecondColor(g);
            g.fillOval(700, 100, (int) radius2*2, (int) radius2*2);
     }
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
   
// Generate a summary Statement
   public static void summaryStatement(Graphics g){
         g.setColor(Color.white);
         g.setFont(new Font("Serif", Font.PLAIN, 20));      
      if (area1 > area2){
         g.drawString("The area of the " + name1 + " (" + area1 + " square units) is bigger than the area of the " + name2 + " (" + area2 + " square units)", 50,560);
      } else if (area2 > area1){
         g.drawString("The area of the " + name2 + " (" + area2 + " square units) is bigger than the area of the " + name1 + " (" + area1 + " square units)", 50,560);
      } else if (area1==area2){
         g.drawString("The area of the " + name1 + " (" + area1 + " square units) is equal to the area of the " + name2 + " (" + area1 + " square units)", 50,560);      
      }
   }

}