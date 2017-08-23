// Phuong / Do
// Student ID#: 950-52-8399
// June 7, 2017
// Current quarter: Spring 2017
// This is the class file that contains methods which will be used by the main program

import java.util.*;
import java.io.*;

public class myStudent{
   String id;
   String name;
   String gender;
   double age;
   int counter = 0;
   ArrayList <myStudent> myArray = new ArrayList<>(); // create a new Array List 

// readData (String fileName) = Read text file (eg: student.txt)
   public void readData (String fileName)
      throws FileNotFoundException {
      
      Scanner someInputScanner = new Scanner(new File(fileName));
      
      while (someInputScanner.hasNext()){
      myStudent s = new myStudent();
      s.id = someInputScanner.next();
      s.name = someInputScanner.next();
      s.gender = someInputScanner.next();
      s.age = someInputScanner.nextDouble();
      myArray.add(s);
      }
      System.out.println("Contents of ‘students.txt’ loaded to array!");

   }

// studentList(String gender) = list of students whose gender is "gender"
   public void studentList(String sex){
      System.out.print("List of (female) students: ");

//Retrieve and display data for female student
      for (int i = 0; i < myArray.size(); i++){
         if (myArray.get(i).gender.startsWith("f")){
            System.out.print(myArray.get(i).name + ", ");
         }
      }
      System.out.println();
   }


// avgAge (String gender) = average age of students whose gender is "gender"
   public void avgAge(String sex){
      //int counter = 0;
      double sumAge = 0;
      System.out.print("Average age of (female) students: ");

//Retrieve and display data for female student
      for (int i = 0; i < myArray.size(); i++){
         if (myArray.get(i).gender.startsWith("f")){
            counter ++;
            sumAge = sumAge + myArray.get(i).age;
         }
      }
      System.out.println(sumAge / counter);
   }

// howMany (String gender) = Print number of students whose gender is "gender"
   public void howMany(){
      System.out.println("Number of (female) students is : " + counter);
   }

// age (int value) = list of students whose age >= value
   public void age(int value){
      System.out.print("Students older than (20): ");
      for (int i = 0; i < myArray.size(); i++){
         if (myArray.get(i).age >= value){
            System.out.print(myArray.get(i).name + ", ");
         }
      }
   }   
}