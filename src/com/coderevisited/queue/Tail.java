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

import com.coderevisited.utils.FileIn;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;


/**
 * @author sureshsajja
 */
public class Tail {

    private Queue<String> queue;
    private int numLines;
    private String file;

    public Tail(int numLines, String file) {
        queue = new LinkedListQueue<>();
        this.numLines = numLines;
        this.file = file;
    }

    public static void main(String[] args) {
        Tail tail = new Tail(Integer.valueOf(args[0]), args[1]);
        tail.readData();
        tail.printLines();
    }

    private void printLines() {
        Iterator<String> itr = queue.iterator();
        System.out.println("Last " + numLines + " lines of file " + file);
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

    }

    private void readData() {
        FileIn in = null;
        try {
            in = new FileIn(file);
            String s = in.readLine();
            while (s != null) {
                if (queue.size() == numLines) {
                    queue.dequeue();
                }
                queue.enqueue(s);
                s = in.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert in != null;
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
