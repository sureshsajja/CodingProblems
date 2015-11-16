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

package com.coderevisited.queue;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 
 * @author sureshsajja
 * 
 * @param <E>
 */
public class ArrayQueue<E> implements Queue<E> {

	private int head;
	private int tail;
	private E[] array;
	private int size;

	@SuppressWarnings("unchecked")
	public ArrayQueue(int N) {
		head = 0;
		tail = 0;
		array = ((E[]) new Object[N]);
		size = 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

	@Override
	public void enqueue(E item) {
		if (isFull()) {
			throw new RuntimeException("Queue is full");
		}
		array[tail] = item;
		tail = (tail + 1) % array.length;
		size++;

	}

	@Override
	public E dequeue() {
		if (isEmpty()) {
			throw new RuntimeException("Queue Underflow");
		}
		E item = array[head];
		array[head] = null;
		head = (head + 1) % array.length;
		size--;
		return item;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	private class ListIterator implements Iterator<E> {

		private int i = 0;

		@Override
		public boolean hasNext() {
			return i < size;
		}

		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			E item = array[(i + head) % array.length];
			i++;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}

	}

	@Override
	public boolean isFull() {
		return size == array.length;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		if (a.length < size) {
			//length of array is than size of queue.. So creating array with queue size
			a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
		}
		for (int i = 0; i < size; i++) {
			a[i] = (T) array[(i + head) % array.length];
		}
		if(a.length > size){
			a[size] = null;
		}
		return a;
	}

}
