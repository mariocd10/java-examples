package stacks;
/**
 * Christian N. Hernandez
 * 10/19/11
 * CS 114
 * Expandable Array Implementing ADT
 */


class ExpandArrayTest
{


	public static void main(String[] args) {
		ExpandArray<Integer> ea = new ExpandArray<Integer>();
		int n = 20;

		long start = System.currentTimeMillis();
		for(int i=0;i<n;++i)
		{
			ea.add(i);
		}

		System.out.println("Original array: \n" + ea.toString());
		System.out.println("The first element is: " + ea.getFirst());
		System.out.println("The last element is: " + ea.getLast() + "\nAdded 70 to the front.");
		ea.addFirst(70);
		System.out.println(ea.toString() + "\nAdd 80 to the back.");
		ea.addLast(80);
		System.out.println(ea.toString() + "\nRemoved the first element.");
		ea.removeFirst();
		System.out.println(ea.toString() + "\nRemoved the last element.");
		ea.removeLast();
		System.out.println(ea.toString());
		System.out.println("Number of Elements: " + ea.countElement());
		System.out.println("Is the array empty? " + ea.isEmpty());

		long end = System.currentTimeMillis();
		System.out.println("n = " + n + " time = "+(end-start));

	}
}
