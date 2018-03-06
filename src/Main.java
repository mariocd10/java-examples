/*
 *
 */

/* Mario DeLaPaz
 * Project 2
 * March 9
 */

/*
*A -> I = E 
*E -> T + E | T - E | T 
*T -> F * T | F / T | F 
*F -> P ^ F | P 
*P -> I | L | UI | UL | (E)
*U -> + | - | !
*I -> a | b | ... | y | z 
*L -> 0 | 1 | ... | 8 | 9 
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;


public class Main{

	public static int counter = 0;

	public static String s = " ";

   public static void main(String[] args){

		File in = new File("input.txt");
		File out = new File("output.txt");
		PrintWriter pw = null;
		Scanner scan = null;
		try {
			scan = new Scanner(in);
		} 
		catch (FileNotFoundException e) {
			System.exit(0);
		}
		try { 
			pw = new PrintWriter(new FileWriter(out, true));
		} 
		catch (IOException e) {
			scan.close();
			System.exit(0);
		}
                while(scan.hasNext()){
                    s = scan.next();
                    System.out.println(s);
                    if(A() && counter == s.length()){
                        counter = 0;
                        System.out.println("The string \"" + s + "\" is in the language");
                    }
                    else{
                        counter = 0;
			System.out.println("The string " + s + " is not in the language");
                    }
                }

			
		pw.close(); 
		scan.close();
	}
   public static boolean A(){
                if(I()){
                	if(counter<s.length() && s.charAt(counter) == '='){
                                ++counter;
                                if(E()){
                                		return true;
                                	}
                	}
                }
		return false;
	}
   public static boolean E(){
		if(T()){
			if(counter<s.length() && s.charAt(counter) == '+'){
                                ++counter;
				if(E()){
					return true;
				}
			}
                        else if(counter<s.length() && s.charAt(counter) == '-'){
                                ++counter;
				if(E()){
					return true;
				}
			}
                        else
                            return true;
                        
		}
		return false;
	}
   public static boolean T(){
		if(F()){
			if(counter<s.length() && s.charAt(counter) == '*'){
                                ++counter;
                                if(T()){
					return true;
				}
			}
                        else if(counter<s.length() && s.charAt(counter) == '/'){
                                ++counter;
				if(T()){
					return true;
				}
			}
                        else{
                            return true;
                        
                        }
		}
		return false; 
	}
   public static boolean F(){
		if(P()){
			if(counter<s.length() && s.charAt(counter) == '^'){
                                ++counter;
				if(F()){
					return true;
				}
			}
                        else 
                            return true;
		}
		return false;
	}
   public static boolean P(){
		if(I()){
			return true;
		}
		else if(L()){
			return true;
		}
		else if(U() && I()){
			return true;
		}
		else if(U() && L()){
			return true;
		}
		else if(counter<s.length() && s.charAt(counter)=='('){
                        ++counter;
			if(E()){
				if(counter<s.length() && s.charAt(counter)==')'){
					++counter;
					return true;
				} 
			}
		}
		return false;
	}
   public static boolean U(){
		if(counter<s.length() && s.charAt(counter) == '+'){
                    ++counter;
                    return true;
		}
 		else if(counter<s.length() && s.charAt(counter) == '-'){
                    ++counter;
                    return true;
		}
		else if(counter<s.length() && s.charAt(counter) == '!'){
                    ++counter;
                    return true;
		} 
		return false;
	}
   public static boolean I(){
		if(counter<s.length() && s.charAt(counter) >= 'a' && s.charAt(counter)<= 'z'){
                    ++counter;
                    return true;
		}
		return false;
	} 
   public static boolean L(){
		if(counter<s.length() && s.charAt(counter) >= '0' && s.charAt(counter)<= '9'){
                    ++counter;
                    return true;
		} 
		return false;
	} 
}
