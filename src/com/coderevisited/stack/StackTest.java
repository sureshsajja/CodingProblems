package com.coderevisited.stack;

/**
 * Sample test client
 *
 * @author sureshsajja
 */
public class StackTest {


    public static void main(String[] args) {
        AdvancedStack<Integer> stack = new LinkedListAdvancedStack<>();
        stack.push(3);
        stack.push(6);
        stack.push(4);
        stack.push(8);
        stack.push(1);
        stack.push(2);
        stack.push(0);

        System.out.println("Size of the Stack " + stack.size());

        for (int i : stack) {
            System.out.println(i);
        }

        System.out.println("Elem from Stack " + stack.pop());
        System.out.println("Elem from Stack " + stack.pop());
        System.out.println("Elem from Stack " + stack.pop());

        System.out.println("Size of the Stack " + stack.size());

        for (int i : stack) {
            System.out.println(i);
        }

        System.out.println("Max of the Stack " + stack.getMax());
        stack.push(8);

        for (int i : stack) {
            System.out.println(i);
        }
        System.out.println("Max of the Stack " + stack.getMax());
        stack.pop();
        for (int i : stack) {
            System.out.println(i);
        }
        System.out.println("Max of the Stack " + stack.getMax());

        Integer[] items = new Integer[8];
        items = stack.multiPop(8, items);
        for (Integer i : items) {
            System.out.println(i);
        }

    }
}
