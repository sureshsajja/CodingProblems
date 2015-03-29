package com.coderevisited.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Stack implementation with fixed size array
 * 
 * @author sureshsajja
 * 
 * @param <E>
 */
public class ArrayStack<E> implements Stack<E> {

	private int N;
	private E[] array;

	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		array = (E[]) new Object[capacity];
	}

	@Override
	public Iterator<E> iterator() {
		return new StackIterator();
	}

	private class StackIterator implements Iterator<E> {

		private int i = N - 1;

		@Override
		public boolean hasNext() {
			return i >= 0;
		}

		@Override
		public E next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return array[i--];
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}

	}

	@Override
	public void push(E item) {
		if (isFull()) {
			throw new RuntimeException("Stack overflow");
		}
		array[N++] = item;
	}

	@Override
	public E pop() {
		if (isEmpty())
			throw new RuntimeException("Stack underflow");
		E item = array[--N];
		array[N] = null;
		return item;

	}

	@Override
	public boolean isEmpty() {
		return N == 0;
	}

	@Override
	public int size() {
		return N;
	}

	@Override
	public boolean isFull() {
		return N == array.length;
	}

	@Override
	public E peek() {
		if (isEmpty())
			throw new RuntimeException("Stack underflow");
		return array[N - 1];
	}

}
