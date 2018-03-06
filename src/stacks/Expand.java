package stacks;
/*
 *Program to test the expandable array class.
 */


public class Expand {

	
	public static void main(String[] args) {
		ExpandableArray<Integer> ea = new ExpandableArray<Integer>();
		int n = 20;
		
		long start = System.currentTimeMillis();
		for(int i=0;i<n;++i)
			ea.add(i);
		long end = System.currentTimeMillis();
		System.out.println("n= " + n + " time= "+(end-start));
		System.out.println(ea);
	}
}
