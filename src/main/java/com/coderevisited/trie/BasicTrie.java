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

package com.coderevisited.trie;

public class BasicTrie
{
    //lower case a to z
    private static final int CHAR_SIZE = 26;
    private TrieNode root;

    public static void main(String[] args)
    {
        BasicTrie trie = new BasicTrie();
        String[] keys = new String[]{"hello", "hi", "whatsup", "bear", "bat", "doll", "boy", "hero", "mat", "rat",
                "cat", "sat"};
        for (String s : keys) {
            trie.insert(s);
        }

        String[] searchKeys = new String[]{"boy", "mad", "sad", "bear", "doll", "toy", "hero"};
        for (String s : searchKeys) {
            if (trie.search(s)) {
                System.out.println(s + " is found");
            } else {
                System.out.println(s + " is not found");
            }
        }
    }

    private static boolean searchUtil(TrieNode x, String key, int d)
    {
        if (x == null) {
            return false;
        }
        if (d == key.length()) {
            return x.isLeaf;
        } else {
            char c = key.charAt(d);
            return searchUtil(x.next[c - 'a'], key, d + 1);
        }
    }

    private static TrieNode insertUtil(TrieNode x, String key, int d)
    {
        if (x == null) {
            x = new TrieNode();
        }
        if (d == key.length()) {
            x.isLeaf = true;
        } else {
            char c = key.charAt(d);
            x.next[c - 'a'] = insertUtil(x.next[c - 'a'], key, d + 1);
        }
        return x;
    }

    private boolean search(String key)
    {
        return searchUtil(root, key, 0);
    }

    public void insert(String key)
    {
        root = insertUtil(root, key, 0);
    }

    private static class TrieNode
    {
        boolean isLeaf;
        TrieNode[] next = new TrieNode[CHAR_SIZE];
    }
}
