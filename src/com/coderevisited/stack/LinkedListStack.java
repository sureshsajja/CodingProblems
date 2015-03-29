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
