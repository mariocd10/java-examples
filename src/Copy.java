// Copy the numbers input 
import java.util.*; // for class Scanner 
   
   public class Copy
      {public static void main(String[] args) { 
       Scanner stdin = new Scanner(System.in); 
       System.out.println( 
          "Ready to copy numbers!\n" + 
          "Enter Control-Z when done!"); 
    double num; 
    double count = 0;
    double sum = 0;
    while(stdin.hasNext()) { 
       num = stdin.nextDouble(); 
       count += 1;
       sum += num;
       System.out.printf("%.2f\n", num); 
    } 
 
    System.out.println("Count of number read = "+ count);
    System.out.println("Total value of numbers read = " + sum);
    System.out.println("Avergage value of numbers read = " + sum/count);

    System.out.println("Goodbye!"); 
    System.exit(0); 
 } 
}