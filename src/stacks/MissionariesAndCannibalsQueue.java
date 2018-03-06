package stacks;
import java.util.LinkedList;
import java.util.Queue;

public class MissionariesAndCannibalsQueue {

	/**
	 * Solve the "missionaries and cannibals" problem.
	 * Start with 3 of each on left bank, get them all across
	 * without ever having missionaries outnumbered by cannibals
	 * on either bank. Boat can carry at most 2 people.
	 */
	public static void main(String args[]) {
		int numberTrips = -1;
		Queue<State> q = new LinkedList<State>();
		State start = new State(3, 3, 0);
		q.add(start); // enqueue
		while (q.peek() != null) {
			State next = q.poll(); // dequeue
			if (next.m == 0 && next.c == 0 && next.b == 1) {
				numberTrips = 0;
				for (State x = next; x != null; x = x.pred) {
					x.display();
					++numberTrips;
				}
				--numberTrips;
				break;
			}
			// generate all possible next states;
			// i represents number of missionaries in boat, j number of cannibals
			for (int i = 0; i <= 2; i++)
				for (int j = 0; i + j <= 2; j++) {
					if (i == 0 && j == 0)
						continue; // can't have empty boat
					State p = next.move(i, j);
					if (!p.legal())
						continue;
					q.add(p); // enqueue
				}
		}
		System.out.println("It required " + numberTrips + " crossings");
	}
}
