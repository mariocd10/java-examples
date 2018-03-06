/*
 * Sliding 9-puzzle solution.
 * You are given a frame that fits 9 square blocks.
 * The frame contains 8 blocks, numbered $1$ through $8$,
 * leaving one location empty.
 * You can shift a neighboring block into the empty space,
 * and your goal is to find a sequence of moves that results in
 * the blocks numbered 1 through 8 going left to right, top row to bottom,
 * with the lower right position empty.
 * 
 * This version proceeds by "level", storing all states that can be reached
 * from a previous state in a queue. It uses the fact that if a solution
 * exists, there is a solution with at most 31 moves.
 */

import java.util.ArrayList;
import java.util.Scanner;

public class Slider9v2 {

	static ArrayList<String> visit; // states we have already visited

	public static void main(String[] args) {
		boolean found = false;
		ArrayList<String> q1 = new ArrayList<String>(); // queue to keep track
														// of states visited on
														// current level
		ArrayList<String> q2 = new ArrayList<String>();
		visit = new ArrayList<String>();
		Scanner sc = new Scanner(System.in);
		String initialState = sc.next(); // supply initial state in the form of
											// a string of 9 digits
		long start = System.currentTimeMillis();
		final String goalState = "123456789";
		visit.add(initialState);
		q2.add(initialState);
		for (int level = 0; level < 32 && !found; ++level) {
			System.out.println("Level= " + level + " visit.size()= "
					+ visit.size() + " q.size()= " + q2.size());
			ArrayList<String> tmp = q1; // swap roles of q1, q2
			q1 = q2;
			q2 = tmp;
			q2.clear();
			while (q1.size() > 0) {
				String s = (String) q1.remove(q1.size() - 1);
				if (s.equals(goalState)) {
					found = true;
					System.out.println("Solved in " + level + " moves.");
					break;
				}
				ArrayList<String> m = getMoves(s);
				for (String ns : m)
					if ((ns != null) && (!visit.contains(ns))) {
						q2.add(ns);
						visit.add(ns);
					}
			}
		}
		if (!found)
			System.out.println("No solution.");
		long elapsed = System.currentTimeMillis() - start;
		System.out.println("Elapsed time = " + elapsed);
	}

	/*
	 * Method returns a list of possible moves that can be made starting from
	 * state ps.
	 */

	public static ArrayList<String> getMoves(String pos) {
		int ind9 = pos.indexOf('9');
		ArrayList<String> moves = new ArrayList<String>();
		if (ind9 > 2) // try up
			moves.add(swap(pos, ind9 - 3, ind9));
		if (ind9 < 6) // try down
			moves.add(swap(pos, ind9, ind9 + 3));
		if (ind9 % 3 > 0) // try left
			moves.add(swap(pos, ind9 - 1, ind9));
		if (ind9 % 3 < 2) // try right
			moves.add(swap(pos, ind9, ind9 + 1));
		return moves;
	}

	public static String swap(String s, int i, int j) { // swap digits at i, j
		String ns = s.substring(0, i) + s.charAt(j) + s.substring(i + 1, j)
				+ s.charAt(i) + s.substring(j + 1);
		return ns;
	}
}
