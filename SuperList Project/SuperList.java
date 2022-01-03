//Anurag Tilwe
import java.util.*;
public class SuperList<E>
{
	private ListNode<E> root, end;
	private int size;

	public SuperList()
	{
		root = null;
		end = null;
		root = end;
		size = 0;
	}//constructor

	public void add(E value)
	{
		ListNode<E> ln = new ListNode<E>(value);

		if (size==0)
		{
			root = ln;
			end = root;
		}
		else {
			ListNode<E> temp = end;
			temp.setNext(ln);
			ln.setPrev(temp);
			end = ln;
		}
		size++;
	}//add to end
	public void add(int n, E value)
	{
		if (n>size || n<0)
			throw new ArrayIndexOutOfBoundsException();
		ListNode<E> lnNew = new ListNode<E>(value);
		ListNode<E> current = root;

		size++;
		for (int i=0; i<n; i++)
			current = current.getNext();
		if (n == 0)
		{
			current.setPrev(lnNew);
			lnNew.setNext(current);
			root = lnNew;
		} else if (n == size-1) {
			current = end;
			current.setNext(lnNew);
			lnNew.setPrev(current);
			end = lnNew;
		} else {
			current.getPrev().setNext(lnNew);
			lnNew.setPrev(current.getPrev());
			lnNew.setNext(current);
			current.setPrev(lnNew);
		}
	}//add at index

	public void push(E value)
	{
		add(value);
	}//push

	public E pop()
	{
		if (end == null)
			throw new EmptyStackException();
		E value = end.getValue();
		end = end.getPrev();
		if (size>1) end.setNext(null);
		size--;
		if (size == 0)	root = end;
		return value;
	}//pop
	public E poll()
	{
		if (root == null)
			return null;

		E value = root.getValue();
		root = root.getNext();
		if (size>1) root.setPrev(null);
		size--;
		if (size == 0)	end = root;
		return value;
	}//poll

	public E stackPeek()
	{
		if (end == null)
			return null;
		else return end.getValue();
	}//stackPeek
	public E queuePeek()
	{
		if (root == null)
			return null;
		else return root.getValue();
	}//queuePeek

	public E get(int n)
	{
		if (n>=size || n<0)
			throw new ArrayIndexOutOfBoundsException();
		ListNode<E> ln = root;
		for (int i=0; i<n; i++)
			ln = ln.getNext();
		return ln.getValue();
	}//get at index

	public E set(int n, E value)
	{
		if (n>=size || n<0)
			throw new ArrayIndexOutOfBoundsException();
		ListNode<E> ln = root;
		for (int i=0; i<n; i++)
			ln = ln.getNext();
		E old = ln.getValue();
		ln.setValue(value);
		return old;
	}//set

	public int size() { return size; }//size

	public E remove(int n)
	{
		if (n>=size || n<0)
			throw new ArrayIndexOutOfBoundsException();
		ListNode<E> ln = root;
		for (int i=0; i<n; i++)
			ln = ln.getNext();
		E value = ln.getValue();
		ListNode<E> prev = ln.getPrev(), next = ln.getNext();
		if (n!=0)
			prev.setNext(next);
		else root = next;
		if (n!=size-1)
			next.setPrev(prev);
		else end = prev;
		size--;
		return value;
	}//remove

	public boolean isEmpty() {	return (size == 0); }//isEmpty

	public void clear()
	{
		root.setNext(null);
		root = null;
		end.setPrev(null);
		end = null;
		size = 0;
	}//clear

	public boolean contains(E value)
	{
		ListNode<E> ln = root;
		for (int i=0; i<size; i++)
		{
			if (ln.getValue().equals(value))
				return true;
			ln = ln.getNext();
		}
		return false;
	}//contains

	public String toString()
	{
		String line = "[";
		ListNode<E> ln = root;
		for (int i=0; i<size; i++)
		{
			line += ln.getValue();
			if (ln.hasNext())
				line += ", ";
			ln = ln.getNext();
		}
		line += "]";
		return line;
	}//toString
}//SuperList