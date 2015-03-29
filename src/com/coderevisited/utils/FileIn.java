package com.coderevisited.utils;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * @author sureshsajja
 *
 */
public class FileIn implements Closeable {

	private BufferedReader br;

	public FileIn(String file) throws FileNotFoundException {
		br = new BufferedReader(new FileReader(file));
	}

	public String readLine() throws IOException {
		return br.readLine();
	}

	@Override
	public void close() throws IOException {
		br.close();

	}

}
