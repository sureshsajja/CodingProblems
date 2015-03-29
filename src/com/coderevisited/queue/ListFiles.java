package com.coderevisited.queue;

import java.io.File;

public class ListFiles {

	public static void main(String[] args){
		listFilesFromDirectory("/Users/sureshsajja/work");
	}
	
	public static void listFilesFromDirectory(String s) {
		Queue<File> directories = new LinkedListQueue<>();
		directories.enqueue(new File(s));
		while (!directories.isEmpty()) {
			File file = directories.dequeue();
			File[] files = file.listFiles();
			assert files != null;
			for (File f : files) {
				if (f.isDirectory()) {
					directories.enqueue(f);
				} else {
					System.out.println(file.getAbsolutePath() + " : "
							+ file.length());
				}
			}
		}
	}

}
