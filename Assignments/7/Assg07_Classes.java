// Phuong / Do
// Student ID#: 950-52-8399
// June 7, 2017
// Current quarter: Spring 2017
// This is the main program that calls methods from myStudent class

import java.io.*;

public class Assg07_Classes{
   public static void main (String[] args)
         throws FileNotFoundException {
      myStudent s = new myStudent(); // Instantiate a new object of the myStudent() class
      s.readData("students.txt"); // Reads a .txt file ‘students.txt’
      s.studentList("f"); // List of student swhose gender is ‘f’
      s.avgAge("f"); // Print the average age of students whose gender is ‘f’
      s.howMany(); // Print the number of students whose gender is ‘f’
      s.age(20); // Generates a list of students whose age is greater than or equal to 20
   }
}