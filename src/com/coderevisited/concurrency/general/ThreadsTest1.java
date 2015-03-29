package com.coderevisited.concurrency.general;

public class ThreadsTest1 {
	
	public synchronized void methodA(){
		System.out.println("I should be called using instance");
		methodB();
	}
	
	public static synchronized void methodB(){
		System.out.println("I should be called from Static");
	}

}
