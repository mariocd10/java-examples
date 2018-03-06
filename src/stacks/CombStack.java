package stacks;
import java.util.Stack;

/**
 * Print out all nonempty subsets of a string using a stack instead
 * of recursion.
 */

public class CombStack {
  
  public static void main(String args[]) {
  
    Stack<CState> stack = new Stack<CState>();
    CState start = new CState("", "abc");
    stack.push(start);
    while (!stack.isEmpty()) {
      CState next = stack.pop();
      if (next.suff().length() > 0) {
        System.out.println(next.pre() + next.suff().charAt(0));
        CState n1 = new CState(next.pre() +
          next.suff().charAt(0), next.suff().substring(1));
        CState n2 = new CState(next.pre(), next.suff().substring(1));
        stack.push(n2);
        stack.push(n1);
      }
    }
  }
}
