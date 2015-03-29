package com.coderevisited.queue;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CircularLinkedListQueue<E> implements Queue<E> {

	private LinkedListNode<E> last;
	private int size;

	@Override
	public Iterator<E> iterator() {
		return new QueueIterator();
	}

	@Override
	public void enqueue(E item) {
		if (isEmpty()) {
			last = new LinkedListNode<>(item, null);
			last.next = last;
		} else {
			last.next = new LinkedListNode<>(item, last.next);
			last = last.next;
		}
		size++;

	}

	@Override
	public E dequeue() {
		if (isEmpty())
			throw new RuntimeException("Queue underflow");
		E item = last.next.item;
		last.next = last.next.next;
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

	@Override
	public boolean isFull() {
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] toArray(T[] a) {
		if (a.length < size) {
			a = (T[]) Array.newInstance(a.getClass().getComponentType(), size);
		}
		LinkedListNode<E> temp = last.next;
		for (int i = 0; i < size; temp = temp.next, i++) {
			a[i] = (T) temp.item;
		}
		if (a.length > size) {
			a[size] = null;
		}
		return a;
	}

	private class QueueIterator implements Iterator<E> {

		private LinkedListNode<E> start = last.next;
		private int traversed = 0;

		@Override
		public boolean hasNext() {
			return traversed < size;
		}

		@Override
		public E next() {
			if(!hasNext())
				throw new NoSuchElementException();
			E item = start.item;
			start = start.next;
			traversed++;
			return item;
		}

		@Override
		public void remove() {
			throw new RuntimeException();

		}

	}

	private static class LinkedListNode<E> {

		private E item;
		private LinkedListNode<E> next;

		private LinkedListNode(E item, LinkedListNode<E> next) {
			this.item = item;
			this.next = next;
		}
	}

}
