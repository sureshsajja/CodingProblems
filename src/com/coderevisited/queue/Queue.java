package com.coderevisited.queue;

/**
 * 
 * @author sureshsajja
 *
 * @param <E>
 */
public interface Queue<E> extends Iterable<E> {

	void enqueue(E item); // add an item

	E dequeue(); // remove the least recently added item

	boolean isEmpty(); // is the queue empty?

	int size(); // number of items in the queue
	
	boolean isFull(); //is queue is Full
	
	<T> T[] toArray(T[] a);
	

}
