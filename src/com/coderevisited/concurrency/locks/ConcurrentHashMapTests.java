package com.coderevisited.concurrency.locks;


/**
 * 
 * @author sureshsajja
 * 
 */
public class ConcurrentHashMapTests {

	MyConcurrentHashMap<Integer, Integer> map;

	public static void main(String[] args) {
		ConcurrentHashMapTests test = new ConcurrentHashMapTests();
		test.init();

	}

	private void init() {
		map = new MyConcurrentHashMap<>();
		new Thread(new Writer()).start();
		
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		for(int i = 0; i < 100; i++){
			new Thread(new Reader(i)).start();
		}
		

	}

	private class Reader implements Runnable {
		int key;

		public Reader(int key) {
			this.key = key;
		}

		@Override
		public void run() {
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("Retrieved " + map.get(key));
		}

	}

	private class Writer implements Runnable {

		@Override
		public void run() {
			for (int i = 0; i < 100; i++) {
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				map.put(i, i);
			}

		}

	}

}
