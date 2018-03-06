import java.util.*;


public class InsertionSort {

	/**
	 * Mario DeLaPaz
	 * CS241
	 * March 13
	 */
	
	static int CountC = 0;
	static int[] A = new int[32];
	static int[] A2 = new int[100];
	static int[] A3 = new int[1000];
	static int[] A4 = new int[10000];
	
	
	
	public static void main(String[] args) {
		Random randint = new Random();
		int[] A = new int[32];
		//int[] A2 = new int[100];
	   // int[] A3 = new int[1000];
		//int[] A4 = new int[10000];
		
		//Data for 32 elements in the array
		//Random data input ---------------------------------------
		for(int i=0;i<A.length;i++){
			A[i] = randint.nextInt(32);
		}
		
		System.out.println("Unsorted Array: "+Arrays.toString(A));
		int[] sorted = InsertSort(A);
		System.out.println("Sorted Array: "+Arrays.toString(sorted));
		System.out.println("Key Comparisons: "+CountC);
		System.out.println();
		
		//Best Case ----------------------------------------
		for(int i=0; i<A.length;++i)
		{
			A[i] = i;
		}
		System.out.println("Unsorted Array: "+Arrays.toString(A));
		int[] sorted2 = InsertSort(A);
		System.out.println("Sorted Array: "+Arrays.toString(sorted2));
		System.out.println("Key Comparisons: "+CountC);
		System.out.println();
		
		//Worst Case -----------------------------------------------------
		for(int i = 0; i <A.length/2; ++i)
		{
		    int temp = A[i];
		    A[i] = A[A.length - i - 1];
		    A[A.length - i - 1] = temp;
		}
		System.out.println("Unsorted Array: "+ Arrays.toString(A));
		int[] sorted3 = InsertSort(A);
		System.out.println("Sorted Array: "+Arrays.toString(sorted3));
		System.out.println("Key Comparisons: "+CountC);
		
		
		
		

	}

	
	static boolean Smaller(int x,int y)
	{
		CountC++;
		if(x<y)
		{
			return true;
		}
		return false;
	}
	
	static int[] InsertSort(int[] A)
	{
		CountC = 0;
		//go through the array from begginning
		for(int i=0; i<A.length; i++)
		{
			int j=i;
			//while j>0 and j<j-1 then swap 
			while(j>0 && Smaller(A[j], A[j-1]))
			{
				int temp = A[j-1];
				A[j-1]=A[j];
				A[j] = temp;
				j=j-1;
			}
			
		}
		
		return A;
		
		
	}
}
