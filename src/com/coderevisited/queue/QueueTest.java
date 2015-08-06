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

import java.util.Iterator;

/**
 * 
 * @author sureshsajja
 * 
 */
public class QueueTest {


	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedListQueue<>();
		// queue.dequeue();
		queue.enqueue(3);
		queue.enqueue(6);
		queue.enqueue(5);
		queue.enqueue(4);
		queue.enqueue(2);
		queue.enqueue(1);

		queue.dequeue();
		queue.dequeue();

		System.out.println("Size of the Queue " + queue.size());

		for (Integer aQueue : queue) {
			System.out.println(aQueue);
		}

		queue.dequeue();

		System.out.println("Size of the Queue " + queue.size());

		queue.enqueue(3);
		queue.enqueue(6);
		queue.enqueue(5);
		
		System.out.println("Size of the Queue " + queue.size());

		for (Integer i : queue) {
			System.out.println(i);
		}

		System.out.println("array returned from toArray ");
		Integer[] intArray = new Integer[queue.size()-3];
		intArray = queue.toArray(intArray);
		for (Integer i : intArray) {
			System.out.println(i);
		}

		intArray[0] = null;
		System.out.println("modified array ");
		System.out.println("checking queue contents");

		for (Integer i : queue) {
			System.out.println(i);
		}
		
		System.out.println("checking array contents");
		for (Integer i : intArray) {
			System.out.println(i);
		}

	}

}
