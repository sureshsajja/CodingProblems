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
