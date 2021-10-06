package Utility;

import java.lang.reflect.Array;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;



public class MyStackImplemented<E> implements StackADT {
	MyArrayList<E> stackList;
	
	/**
	 * constructor for myStackImplemented
	 */
	public MyStackImplemented(){
		stackList = new MyArrayList<E>();
	}
	
	/**
	 * pushes an object to the top of the stack
	 */

	@Override
	public void push(Object toAdd) throws NullPointerException {
		stackList.add((E) toAdd);
	}
	/**
	 * pops the object on the top of the stack
	 */
	

	@Override
	public Object pop() throws EmptyStackException {
		if (stackList.isEmpty() != true) {
			E popValue = stackList.get(stackList.size()- 1);
			stackList.remove(stackList.size()-1);
			return popValue;
			
		}
		else {
			Object E;
			return (E) (E = null);
		}
		
	
	}
/*
 * looks at the top of the stack without removing it
 */
	@Override
	public Object peek() throws EmptyStackException {
		return stackList.get(stackList.size()- 1);
	}
	/**
	 * clears the stack
	 */

	@Override
	public void clear() {
		stackList.clear();
		
	}
	/**
	 * checks if stack is empty
	 */

	@Override
	public boolean isEmpty() {
		if (stackList.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * sends the stack to an array
	 */

	@Override
	public Object[] toArray() {
		Object [] toHold = new Object[this.size()];
		for (int i = 0; i > this.size(); i++) {
			toHold[i] = this.pop();
		}
		return toHold;
	
	}
	/**
	 * 
	 * @param holder - send in the object array to be put into the array
	 */

	@Override
	public Object[] toArray(Object[] holder) throws NullPointerException {
		if (holder == null)
		{
			throw new NullPointerException();
		}
		if (holder.length < this.size()) {
			
		holder = (E[]) (Array.newInstance(holder.getClass().getComponentType(), this.size()));
		}
		Iterator iterator = this.iterator();
		
		
		for (int i = 0; i < this.size(); i++) {
			holder[i] = iterator.next();
		}
		return holder;
	}
	/**
	 * returns true if the stack contains the tofind object
	 * @param toFind - the object you are looking to see if its in the stack
	 */
	@Override
	public boolean contains(Object toFind) throws NullPointerException {
		if (stackList.contains((E) toFind)) {
			return true;
		}
		else {
		return false;
		}
	}
	/**
	 * returns the position of the object in the stack
	 * @param toFind - the object you are seaching for
	 */

	@Override
	public int search(Object toFind) {
		int index = -1;
		int pos;
		for (int i = this.size() - 1; i >= 0; i-- ) {
			if (stackList.get(i).equals(toFind)) {
				index = i;
				break;
			}
			
		}
		
		return index;
	}
	/**
	 * iterator for the stack
	 */

	@Override
	public Iterator<E> iterator() {
		return new MyStackIterator();
	}
	private class MyStackIterator implements Iterator<E>
	{
		//Attribute 
		private int pos;

		@Override
		public boolean hasNext() {
			return pos < stackList.size();
		}

		@Override
		public E next() throws NoSuchElementException {
			if(pos >= stackList.size()) 
			{
				throw new NoSuchElementException();
			}
			return stackList.get(pos++);
		}
		
	}
	/**
	 * checks if 2 stacks are the same
	 */

	@Override
	public boolean equals (StackADT that) {
		if (that == this) {
			return true;
		}
		
		if (this.size() != that.size()) {
			return false;
		}
		Iterator iterator = this.iterator();
		Iterator iterator2 = that.iterator();
		
		while (iterator.hasNext()) {
			if (!iterator.next().equals(iterator2.next())) {
				return false;
			}
				
			}
		return true;
		}
		
		
	/**
	 * returns the size of the stack
	 */

	@Override
	public int size() {
		
		return stackList.size();
	}

}
