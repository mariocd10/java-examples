/**
 * Christian N. Hernandez
 * 10/19/11
 * CS 114
 * Expandable Array Implementing ADT
 */

import java.util.*;

class ExpandArray<E> implements Deque<E>
{
  E[] a;

  ExpandArray()
  {
	  a = (E[]) new Object[10];
  }

  public int size()
  {
	return a.length;
  }

  public int countEmpty()
  {
  	int c = 0;
  	if(a[0] != null)
  	{
  		for(int i = 0; i < size(); i++)
  		{
  			if(a[i] == null)
  			{
  				c++;
  			}
  		}
  	}
  	return c;
  }

  public int countElement()
  {
  	return (size() - countEmpty());
  }

  public boolean isEmpty()
  {
 	if(countEmpty() == (size()-1))
		return true;
	return false;
  }

  public void add(E e)
  {
  	if(countEmpty() == 0)
  	{
  		extend();
  	}
  	if(a[0] == null)
  	{
  		a[0] = e;
  	}
  	else
  	{
  		int last = ((a.length-1) - countEmpty());
  		int emptyLast = (last + 1);
  		a[emptyLast] = e;
  	}
  }

  public E getFirst() throws EmptyDequeException
  {
  	if(isEmpty())
  	{
		throw new EmptyDequeException("Deque is empty.");
  	}
  	return a[0];
  }

  public E getLast() throws EmptyDequeException
  {
  	if(isEmpty())
  	{
		throw new EmptyDequeException("Deque is empty.");
  	}
  	int last = ((a.length-1) - countEmpty());
  	if(countEmpty() > 0)
  	{
		return a[last];
  	}
	return a[a.length-1];
  }

  public void addFirst(E e)
  {
  	if(countEmpty() == 0)
  	{
  		extend();
  	}
  	moveDown();
  	a[0] = e;

  }

  public void addLast(E e)
  {
  	if(isEmpty())
  	{
		throw new EmptyDequeException("Deque is empty.");
  	}
  	if(countEmpty() == 0)
  	{
  		extend();
  	}
  	int last = ((a.length-1) - countEmpty());
    a[last+1] = e;

  }

  public E removeFirst() throws EmptyDequeException
  {
  	if(isEmpty())
	{
		throw new EmptyDequeException("Deque is empty.");
	}

	a[0] = null;
	moveUp();
	return getFirst();

  }

  public E removeLast() throws EmptyDequeException
  {
	if(isEmpty())
	{
		throw new EmptyDequeException("Deque is empty.");
	}
	int last = ((a.length-1) - countEmpty());
	a[last] = null;
	return getLast();
  }

  private void extend()
  {
	  E[] b = (E[]) new Object[2*a.length];
	  //E[] b = (E[]) new Object[a.length + 10];
	  for(int i=0;i<a.length; ++i)
		  b[i] = a[i];
	  a = b;
  }

  void moveUp()
  {
  	int last = ((a.length-1) - countEmpty());
	for(int i = 0; i < last; i++)
	{
		a[i] =a[i+1];
	}

  }

  void moveDown()
  {
  	int last = ((a.length-1) - countEmpty());
  	int emptyLast = (last + 1);
  	if(a[emptyLast] == null)
  	{
		for(int i = emptyLast; i > 0; i--)
		{
			a[i] = a[i-1];
		}
  	}

  }

  public String toString() {
	    String s = "[";
	    for (int i = 0; i < a.length; i++)
	    {
			if(a[i] != null)
			{
	      		if (i > 0)
	      		{
	      			s  += ", "; // separate entries by commas
	      		}
	      		s += a[i];
			}
	    }
	    return s + "]";
	  }
}
