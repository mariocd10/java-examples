/**
 * Mario DeLaPaz
 * 10/19/11
 * CS 114
 * Deque interface
 */

public interface Deque<E>
{

	public int size();

	public boolean isEmpty();

	public E getFirst() throws EmptyDequeException;

	public E getLast() throws EmptyDequeException;

	public void addFirst(E e);

	public void addLast(E e);

	public E removeFirst() throws EmptyDequeException;

	public E removeLast() throws EmptyDequeException;

	public String toString();

}
