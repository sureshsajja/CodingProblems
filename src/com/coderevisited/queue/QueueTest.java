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
