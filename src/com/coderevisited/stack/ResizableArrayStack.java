/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 CodeRevisited.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 *
 */

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
