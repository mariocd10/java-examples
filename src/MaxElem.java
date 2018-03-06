import java.util.Random;
import java.util.Scanner;

public class MaxElem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//make a random num object
		Random rn = new Random();
		//create an int array of size 10
		int[] fmax = new int[10];
		//create variables that i'm going to use later
		int index=0;
		int max=0;
		//the loop to insert values into the array
		for(int i=0; i<fmax.length; i++){
			//create a random number from 0-10
			int randomnum = rn.nextInt(10);
			//assign the num to the array index
			fmax[i] = randomnum;
			//check if it's bigger than max. if it is then make it the new max
			if(fmax[i]>max){
				max = fmax[i];
				index = i;
			}
			
		}
		
		System.out.println("The maximum value is: "+max);
		System.out.println("This is element number "+index+"in the list of numbers");
	}

}
