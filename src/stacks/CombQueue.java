package stacks;

import java.util.LinkedList;
import java.util.Queue;

public class CombQueue {

/**
 * Print out all nonempty subsets of a string using a queue instead
 * of recursion.
 */

  public static void main(String args[]) {
    // Stack<CState> stack = new Stack<CState>();
    Queue<CState> q = new LinkedList<CState>();
    CState start = new CState("", "abc");
    q.add(start);
    while (!q.isEmpty()) {
      CState next = q.poll(); // dequeue
      if (next.suff().length() > 0) {
        System.out.println(next.pre() + next.suff().charAt(0));
        CState n1 = new CState(next.pre() + next.suff().charAt(0),
                    next.suff().substring(1));
        CState n2 = new CState(next.pre(), next.suff().substring(1));
        q.add(n1);
        q.add(n2);
      }
    }
  }
}
