/**
 * 
 */
package com.coderevisited.stack;

/**
 * @author sureshsajja
 * 
 */
public interface Stack<E> extends Iterable<E> {

	void push(E item); // add an item

	E pop(); // remove the most recently added item
	
	E peek(); //returns most recently inserted item

	boolean isEmpty(); // is the stack empty?

	int size(); // number of items in the stack
	
	boolean isFull(); //for Array based stacks only

}
