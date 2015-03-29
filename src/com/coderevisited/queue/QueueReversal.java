package com.coderevisited.queue;

/**
 * 
 * @author sureshsajja
 *
 */
public class QueueReversal {

	public static <E> void reverseQueue(Queue<E> queue, Queue<E> reverseQueue) {

		E a = queue.dequeue();
		while (!queue.isEmpty())
			reverseQueue(queue,reverseQueue);
		reverseQueue.enqueue(a);

	}

	public static void main(String[] args) {
		Queue<Integer> order = new LinkedListQueue<>();
		order.enqueue(0);
		order.enqueue(1);
		order.enqueue(2);
		order.enqueue(3);
		order.enqueue(4);

		for (Integer i : order) {
			System.out.println(i);
		}

		Queue<Integer> reverseQueue = new LinkedListQueue<>();
		reverseQueue(order, reverseQueue);
		for (Integer i : reverseQueue) {
			System.out.println(i);
		}
	}

}
