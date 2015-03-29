package com.coderevisited.memoryleaks;

/**
 * @author sureshsajja
 */
public class StackTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>(10000);
        for (int i = 0; i < 10000; i++) {
            s.push(i);
        }

        while (!s.isEmpty()) {
            s.pop();
        }

        while (true) {
            //do something
        }

    }

}
