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
