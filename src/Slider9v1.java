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
 * With this version, you may need to increase the vm stack size.
 * You can do this by passing the argument -Xss4096k to the
 * virtual machine.
 * (You may need a bigger number than 4096, but I doubt it.)
 *
 * In Eclipse,
 * open the launch configurations in Run - Run Configurations... and open your
 * program under "Java Applications". Select the Arguments pane, where you will
 * find "VM arguments".
 * This is where -Xss1024k goes.
 *
 * On AFS, you would type
 * java -Xss4096k YourProgramName
 *
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Slider9v1 {

	static String d; // desired configuration
	static ArrayList<String> visited;
	static ArrayDeque<String> q;
	static int count;

	public static void main(String[] args) {
		// Scanner sc = new Scanner(System.in);
		q = new ArrayDeque<String>();
		visited = new ArrayList<String>();
		// String cur = sc.next();
		String cur = "823946157";
		System.out.println("Initial configuration: " + cur);
		d = "123456789";
		count = 0; // how many moves in our current solution
		if (!explore(cur)) {
			System.out.println("No solution.");
		} else {
			System.out.println("Solution of length " + q.size());
		}
		// while (!q.isEmpty()) {
		// String c = q.removeFirst();
		// System.out.println(c);
		// }

	}

	/*
	 * Recursive method to explore from state c.
	 */

	static boolean explore(String c) {
		++count;
		if (visited.contains(c)) // if we have been here, don't explore again
			return false;
		else {
			if (c.equals(d)) {
				return true; // reached goal
			}
			q.addLast(c);
			visited.add(c);

			ArrayList<String> m = getMoves(c);
			for (String ns : m) { // explore each possible move from this state
				if (explore(ns))
					return true;
			}
			q.removeLast(); // none of the possibilities lead to a solution;
			// backtrack
			return false;
		}
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
		// System.out.println(moves);
		return moves;
	}

	public static String swap(String s, int i, int j) { // swap digits at i,j
		String ns = s.substring(0, i) + s.charAt(j) + s.substring(i + 1, j)
				+ s.charAt(i) + s.substring(j + 1);
		return ns;
	}

}
