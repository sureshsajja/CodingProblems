package com.coderevisited.stack;

/**
 * 
 * @author sureshsajja
 *
 * @param <E>
 */
public interface AdvancedStack<E extends Number> extends Stack<E> {

	E getMax();
	
	<T> T[] multiPop(int k, T[] a);
}
