// CS210 Assignment 1 (Chapter1Ex11)
// Phuong / Do

public class Chapter1Ex11{

public static void main(String[] args){
   drawCone();
   drawBox();
   unitedStates();
   drawBox();
   drawCone();
}
public static void drawCone(){
   System.out.println("   /\\       /\\");
   System.out.println("  /  \\     /  \\");
   System.out.println(" /    \\   /    \\");   
}
public static void drawBox(){
   System.out.println("+------+ +------+");
   System.out.println("|      | |      |");
   System.out.println("|      | |      |");
   System.out.println("+------+ +------+");
}
public static void unitedStates(){
   System.out.println("|United| |United|");
   System.out.println("|States| |States|");
}
}