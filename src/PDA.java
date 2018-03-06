/*
 * Mario DeLaPaz
 * Programming Assignment 2
 * 4/3/13
 */
import java.util.Scanner;
import java.util.Stack;


public class PDA {

public static Stack<Character> stack = new Stack<Character>();
public static int index;
public static String str;


public static void main(String[] args){
	
	String answer;
	String tans;
	String tstr;
	
	Scanner scan = new Scanner(System.in);
	
		System.out.println("Do you want to enter a string? y/n: ");
		tans = scan.nextLine();
		answer = tans.toLowerCase();
	
		//Keeps going until the answer is 'n'
		while(!answer.equals("n")){
			//if it's y then ask for a input string
			if(answer.equals("y")){
				System.out.println("Enter a string: ");
				tstr = scan.next();
				str = tstr.toLowerCase();
				
				System.out.println(str);
				//The methods will be here...
				index=0;
				if(A()){
					System.out.println("-----------Accepted! :) -----------"+"\n");
					while(!stack.empty())
					{
			    	stack.pop();
					}
					
				}
				else
					System.out.println("--------------Rejected! :( -------------"+"\n");
					while(!stack.empty())
					{
						stack.pop();
					}
				//Ask user again to reassign answer
				System.out.println("Do you want to enter a string? y/n: ");
				answer= scan.next();
			}
			else{
				//if the answer is not a n or y then ask to correct input
				System.out.println("INVALID ANSWER: Enter 'y' or 'n': ");
				answer=scan.next();
			}
		}
		//out of the loop; the answer was n
		System.out.println("DONE");
	//}
	//pw.close();
	//scan.close();
}


//The Initial State
public static boolean A(){
	 
	 if(index<str.length()){
		 System.out.println("State 1\t"+"\tReads: "+str.charAt(index)+"\tPushes: $"+"\tPops: E");
		 //Checks if the character is a dollar sign
		 if(str.charAt(index)=='$'){
			 //if so; push a dollar sign on to the stack
			 stack.push('$');
			 index++;
			 if (B()){
				 return true;
			 }
		 }		 
	 }
	 System.out.println();
	 return false;
 }

//The second state
public static boolean B(){
	 //if we haven't reached the end of the string then check the character
	 if(index<str.length()){
		 System.out.print("State 2 "+"\tReads: "+str.charAt(index));
		 //checks if the character is a letter
		 if(str.charAt(index)>='a' && str.charAt(index)<= 'z'){
			 System.out.println("\tPushes: E \tPops: E");
			 index++;
			 //go to next state
			 if (D()){
				 return true;
			 }
		 }
		 //checks if character is a open paran
		 else if(str.charAt(index)=='('){
			 System.out.println("\tPushes: ( \tPops: E");
			 stack.push('(');
			 index++;
			 //go to next state
			 if(C()){
				 return true;
			 }
		 }
	 }
	 return false;
}

public static boolean C(){
	 if(index<str.length()){
		 System.out.print("State 3 "+"\tReads: "+str.charAt(index));
		 if(str.charAt(index)<='z' && str.charAt(index) >= 'a'){
			 System.out.println("\tPushes: E \tPops: E");
			 //increment the index to the next letter in the string
			 index++;
			 if (D()){
				 return true;
			 }
		 }
		 else if(str.charAt(index)=='('){
			 System.out.println("\tPushes: ( \tPops: E");
			 stack.push('(');
			 index++;
			 if(C()){
				 return true;
			 }
		 }		 
	 }
	 return false;
}

public static boolean D(){
	 
	 if(index<str.length()){
		 System.out.print("State 4 "+"\tReads: "+str.charAt(index));
		 	 if(str.charAt(index)<='z' && str.charAt(index)>='a'){
		 	 System.out.println("\tPushes: E \tPops: E");
			 index++;
			 if(E()){
				 return true;
			 }
		}
		 else if(str.charAt(index)>='0' && str.charAt(index)<='9'){
			 System.out.println("\tPushes: E \tPops: E");
			 index++;
		 	 if(E()){
		 		 return true;
		 	 }
		 }
	 }
	 return false;
}
	 
	 public static boolean E(){
		 if(index<str.length()){
			 System.out.print("State 5 "+"\tReads: "+str.charAt(index));
			 //checks if the character is an operator
			 	 if(str.charAt(index)=='+' || str.charAt(index)=='-' || str.charAt(index)=='/' || str.charAt(index)=='*'){
			 	 System.out.println("\tPushes: E \tPops: E");
				 index++;
				 if(B()){
					 return true;
				}
			 }
			 else if(str.charAt(index)==')'){
				 System.out.println("\tPushes: E \tPops: )");
				 //if it reads a closed paran pop an element
				 stack.pop();
				 //Check if the stack is empty after we popped an element
				 if(stack.size() == 0){
					 //if so the string is not valid since we are not done with the string
					 return false;
				 }
				 index++;
			 	 if(E()){
			 		 return true;
			 	 }
			 }
			 //check if the symbol is a dollar sign 
			 else if(str.charAt(index)=='$'){
				 System.out.println("\tPushes: E \tPops: $");
				 stack.pop();
				 
				 if(F()){
					 return true;
				 }
			 }
		 }
		 return false;
	 }
	 
	 //the final state : Accepting state
	 public static boolean F(){
		 return true;
	}		 

}
