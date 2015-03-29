package com.coderevisited.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * resizing array implementation of stack
 * 
 * @author sureshsajja
 * 
 * @param <E>
 */
public class ResizableArrayStack<E> implements Stack<E> {

	private int N;
	private E[] array;

	@SuppressWarnings("unchecked")
	public ResizableArrayStack(int initialCapacity) {
		array = (E[]) new Object[initialCapacity];
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
		if (N == array.length) {
			resize(array.length * 2);
		}
		array[N++] = item;

	}

	@Override
	public E pop() {
		if (isEmpty()) {
			throw new RuntimeException("Stack underflow");
		}
		E elem = array[--N];
		array[N] = null;
		if (N == array.length / 4)
			resize(array.length / 2);
		return elem;
	}

	private void resize(int max) {
		@SuppressWarnings("unchecked")
		E[] dups = (E[]) new Object[max];
		System.arraycopy(array, 0, dups, 0, N);
		array = dups;

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
		return false;
	}

	@Override
	public E peek() {
		if (isEmpty()) {
			throw new RuntimeException("Stack underflow");
		}
		return array[N - 1];
	}

}
