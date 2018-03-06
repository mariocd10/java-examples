package stacks;
/**
 * Class to implement an expandable array with fixed initial size.
 */

public class ExpandableArray<E> {
  E[] a;
  long size;
  final int INITIAL_SIZE = 10;
  int count = 0;
  
  ExpandableArray()
  {
	  a = (E[]) new Object[INITIAL_SIZE];
	  size = INITIAL_SIZE;
  }
  
  public void add(E e)
  {
	  if(count == a.length)
		  extend();
	  a[count] = e;
	  ++count;
  }
  private void extend()
  {
	  E[] b = (E[]) new Object[2*a.length];
	  //E[] b = (E[]) new Object[a.length + 10];
	  for(int i=0;i<a.length; ++i)
		  b[i] = a[i];
	  a = b;
  }
  
  public String toString() {
	    String s = "[";
	    for (int i = 0; i < a.length; i++) {
	      if (i > 0) s  += ", "; // separate entries by commas
	      s += a[i];
	    }
	    return s + "]";
	  }
}
