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
