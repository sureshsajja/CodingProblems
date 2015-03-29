package com.coderevisited.queue;

import java.util.ArrayList;
import java.util.List;

public class MultiWordSearch {

	public static void main(String[] args) {
		int[] array = new int[] { 5, 4, 3, 1, 2, 3, 4, 2, 1, 3, 2, 6, 7 };
		int[] toFind = new int[] { 3, 4,6 };
		searchSingleNumber(3, array);
		searchArrayOfNumbers(toFind, array);
	}

	private static void searchArrayOfNumbers(int[] toFind, int[] array) {

		List<List<Integer>> listOfLists = new ArrayList<>();
		for (int i = 0; i < toFind.length; i++) {
			if (listOfLists.isEmpty() && i == 0) {
				for (int j = 0; j < array.length; j++) {
					if (array[j] == toFind[i]) {
						List<Integer> list = new ArrayList<>();
						list.add(j);
						listOfLists.add(list);
					}

				}
			} else {
				for (List<Integer> list : listOfLists) {
					int lastIndex = list.get(list.size() - 1);
					for (int j = lastIndex + 1; j < array.length; j++) {
						if (array[j] == toFind[i]) {
							list.add(j);
							break;
						}
					}
				}
			}
		}
		
		for (List<Integer> list : listOfLists) {
			System.out.println("------");
			for (Integer i : list) {
				System.out.println(i);
			}
		}

	}

	public static void searchSingleNumber(int a, int[] array) {
		Queue<Integer> queue = new LinkedListQueue<>();
		for (int i = 0; i < array.length; i++) {
			if (array[i] == a) {
				queue.enqueue(i);
			}
		}

		System.out.println(a + " is found at ");
		for (Integer i : queue) {
			System.out.println(i);
		}
	}

}
