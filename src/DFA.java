import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.*;

public class DFA {
//Mario DeLaPaz
// Project 1
// Feb 20, 2013
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
						System.out.println("Accepted! :) "+"\n");
					}
					else
						System.out.println("Rejected! :( "+"\n");
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
	
	//Machine that will check the string
	 public static boolean A(){
		 
		 if(index<str.length()){
			 System.out.println("State 1 "+"Char "+str.charAt(index));
			 
			 if(str.charAt(index)=='w'){
				 index++;
				 if (B()){
					 return true;
				 }
			 }
			 else if(str.charAt(index)=='.'){
				 index++;
				 if(I()){
					 return true;
				 }
			 }
			 else{
				 index++;
				 if(J()){
					 return true;
				 }
			 }
			 
		 }
		 return false;
	  }
	 
	 public static boolean B(){
		 
		 if(index<str.length()){
			 System.out.println("State 2 "+"Char "+str.charAt(index));
			 if(str.charAt(index)=='w'){
				 index++;
				 if (C()){
					 return true;
				 }
			 }
			 else if(str.charAt(index)=='.'){
				 index++;
				 if(I()){
					 return true;
				 }
			 }
			 else{
				 index++;
				 if(J()){
					 return true;
				 }
			 }
			 
		 }
		 return false;
	 }
	 
	 public static boolean C(){

		 if(index<str.length()){
			 System.out.println("State 3 "+"Char "+str.charAt(index));
			 if(str.charAt(index)=='w'){
				 index++;
				 if (D()){
					 return true;
				 }
			 }
			 else if(str.charAt(index)=='.'){
				 index++;
				 if(I()){
					 return true;
				 }
			 }
			 else{
				 index++;
				 if(J()){
					 return true;
				 }
			 }
			 
		 }
		 return false;
	 }
	 
	 public static boolean D(){
		 
		 if(index<str.length()){
			 System.out.println("State 4 "+"Char "+str.charAt(index));
			 	 if(str.charAt(index)=='.'){
				 index++;
				 if(E()){
					 return true;
				 }
			}
			 else{
				 index++;
			 	 if(J()){
			 		 return true;
			 	 }
			 }
		 }
		 return false;
	 }
		 
		 public static boolean E(){
			 if(index<str.length()){
				 System.out.println("State 5 "+"Char "+str.charAt(index));
				 	 if(str.charAt(index)=='e'){
					 index++;
					 if(F()){
						 return true;
					}
				 }
				 else{
					 index++;
				 	 if(J()){
				 		 return true;
				 	 }
				 }
			 }
			 return false;
		 }
		 
		 public static boolean F(){
			 
			 if(index<str.length()){
				 System.out.println("State 6 "+"Char "+str.charAt(index));
				 	 if(str.charAt(index)=='d'){
					 index++;
					 if(G()){
						 return true;
					 }
			     }
				 else if(str.charAt(index)!='d' && str.charAt(index)!='.'){
					 index++;
				 	 if(J()){
				 		 return true;
				 	 }
				 }
				 else{
					 index++;
				 	if(I()){
				 		return true;
				 	}
				 }
			 }
			 return false;
		 }
		 
		 public static boolean G(){
			 
			 if(index<str.length()){
				 System.out.println("State 7 "+"Char "+str.charAt(index));
				 	 if(str.charAt(index)=='u'){
					 index++;
					 if(H()){
						 return true;
					 }
			     }
				 else if(str.charAt(index)!='u' && str.charAt(index)!='.'){
					 index++;
				 	 if(J()){
				 		 return true;
				 	 }
				 }
				 else{
					 index++;
				 	if(I()){
				 		return true;
				 	}
				 }
			 }
			 return false;
		 }
		 
		 public static boolean H(){
			 if(index<str.length()){
				 System.out.println("State 8 "+"Char "+str.charAt(index));
				 	 if(str.charAt(index)=='.'){
					 index++;
					 if(I()){
						 return true;
					 }
			     }
				 else{
					 index++;
				 	 if(J()){
				 		return true;
				 	}
				 }
			 }
			 return true;	 
	   }
		 
		public static boolean J(){
			if(index<str.length()){
				System.out.println("State 10 "+"Char "+str.charAt(index));
					 if(str.charAt(index)=='.'){
					 index++;
					 if(I()){
						 return true;
					 }
			     }
				 else{
					 index++;
				 	 if(J()){
				 		return true;
				 	}
				 }
			 }
			 return false;
		}
		
		public static boolean I(){
			if(index<str.length()){
				System.out.println("State 9 "+"Char "+str.charAt(index));
					 if(str.charAt(index)=='e'){
					 index++;
					 if(K()){
						 return true;
					 }
			     }
				 else{
					 index++;
				 	 if(N()){
				 		return true;
				 	}
				 }
			 }
			 return false;
		}
		
		public static boolean K(){
			if(index<str.length()){
				System.out.println("State 11 "+"Char "+str.charAt(index));
					 if(str.charAt(index)=='d'){
					 index++;
					 if(L()){
						 return true;
					 }
			     }
				 else{
					 index++;
				 	 if(N()){
				 		return true;
				 	}
				 }
			 }
			 return false;
		}
		
		public static boolean L(){
			if(index<str.length()){
				System.out.println("State 12 "+"Char "+str.charAt(index));
					 if(str.charAt(index)=='u'){
					 index++;
					 if(M()){
						 return true;
					 }
			     }
				 else{
					 index++;
				 	 if(N()){
				 		return true;
				 	}
				 }
			 }
			 return false;
		}
		
		public static boolean M(){
			if(index<str.length()){
				System.out.println("State 13 "+"Char "+str.charAt(index));
					index++;
				 if(N()){
					 return true;
				 }
				 else{
					 return false;
			 }
			}
			 return true;
		}
		
		public static boolean N(){
			if(index<str.length()){
				System.out.println("State 14 "+"Char "+str.charAt(index));
					index++;
				if(N()){
					return true;
				}
				else{
					return false;
			 }
			}
			 return false;
		}
	
}
