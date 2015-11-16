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

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Linked list implementation of stack
 * 
 * @author sureshsajja
 * 
 * @param <E>
 */
public class LinkedListStack<E> implements Stack<E> {

	private StackNode<E> head;
	private int size = 0;
	private transient int modCount = 0;

	public LinkedListStack() {

	}

	@Override
	public Iterator<E> iterator() {
		return new StackIterator();
	}

	@Override
	public void push(E item) {
		head = new StackNode<>(item, head);
		size++;
		modCount++;
	}

	@Override
	public E pop() {
		if (isEmpty())
			throw new RuntimeException("Stack Underflow");

		E item = head.item;
		head = head.next;
		size--;
		modCount++;
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

	private static class StackNode<E> {
		E item;
		StackNode<E> next;

		public StackNode(E item, StackNode<E> next) {
			this.item = item;
			this.next = next;
		}
	}

	private class StackIterator implements Iterator<E> {

		private StackNode<E> current = head;
		private int expectedModCount = modCount;

		@Override
		public boolean hasNext() {
			checkForModification();
			return current != null;
		}

		private void checkForModification() {
			if(expectedModCount != modCount)
				throw new ConcurrentModificationException();
			
		}

		@Override
		public E next() {
			if (!hasNext())
				throw new NoSuchElementException();
			E item = current.item;
			current = current.next;
			return item;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();

		}

	}

	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public E peek() {
		if (isEmpty())
			throw new RuntimeException("Stack Underflow");
		return head.item;
	}

}
