package com.coderevisited.stack;

import java.lang.reflect.Array;
import java.util.Iterator;

/**
 * 
 * @author sureshsajja
 * 
 * @param <E>
 */
public class LinkedListAdvancedStack<E extends Number> implements
		AdvancedStack<E> {

	private Stack<E> maxStack;
	private Stack<E> itemStack;

	public LinkedListAdvancedStack() {
		itemStack = new LinkedListStack<>();
		maxStack = new LinkedListStack<>();
	}

	@Override
	public void push(E item) {
		itemStack.push(item);
		updateMaxStack(item);
	}

	private void updateMaxStack(E item) {
		if (maxStack.isEmpty()) {
			maxStack.push(item);
			return;
		}
		E temp = maxStack.peek();
		if (temp instanceof Integer) {
			if (temp.intValue() <= item.intValue()) {
				maxStack.push(item);
			}
		}

	}

	@Override
	public E pop() {
		E item = itemStack.pop();
		popFromMaxStack(item);
		return item;
	}

	private void popFromMaxStack(E item) {
		E temp = maxStack.peek();
		if (temp instanceof Integer) {
			if (temp.intValue() == item.intValue()) {
				maxStack.pop();
			}
		}

	}

	@Override
	public E getMax() {
		return maxStack.peek();
	}

	@Override
	public E peek() {
		return itemStack.peek();
	}

	@Override
	public boolean isEmpty() {
		return itemStack.isEmpty();
	}

	@Override
	public int size() {
		return itemStack.size();
	}

	@Override
	public boolean isFull() {
		return itemStack.isFull();
	}

	@Override
	public Iterator<E> iterator() {
		return itemStack.iterator();
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T> T[] multiPop(int k, T[] a) {
		// If k is greater than size of stack. k is set to size of stack
		if (k > itemStack.size()) {
			k = itemStack.size();
		}
		if (a.length < k) {
			a = (T[]) Array.newInstance(a.getClass().getComponentType(), k);
		}

		for (int i = 0; i < k; i++) {
			a[i] = (T) pop();
		}
		if (a.length > k)
			a[k] = null;
		return a;
	}

}
