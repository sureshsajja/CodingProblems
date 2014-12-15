package com.coderevisited.graph;

import java.util.*;

/**
 * For each word, create edge from ith char to (i+1)th char, if they are different.
 * For pair for words, create edge between first different chars
 * Using modified DFS, print topological order
 */
public class DictionaryFromAlienLang
{
    public static void main(String[] args)
    {

        String words[] = {"ABCDE", "CF", "DG"};
        DAG dag = new DAG();
        for (int i = 0; i < words.length - 1; i++) {
            char[] word1 = words[i].toCharArray();
            for (int j = 0; j < word1.length - 1; j++) {
                if (word1[j] != word1[j + 1]) {
                    dag.addEdge(word1[j], word1[j + 1]);
                }
            }
            char[] word2 = words[i + 1].toCharArray();
            int k = word1.length < word2.length ? word1.length : word2.length;
            for (int j = 0; j < k; j++) {
                if (word1[j] != word2[j]) {
                    dag.addEdge(word1[j], word2[j]);
                    break;
                }
            }
        }

        char[] lastWord = words[words.length - 1].toCharArray();
        for (int j = 0; j < lastWord.length - 1; j++) {
            if (lastWord[j] != lastWord[j + 1]) {
                dag.addEdge(lastWord[j], lastWord[j + 1]);
            }
        }

        for (Character c : dag.topologicalSort()) {
            System.out.print(c + " ");
        }
        System.out.println();

    }


    public static class DAG
    {
        private Map<Character, List<Character>> adj = new HashMap<>();
        private boolean[] marked = new boolean[256];
        private List<Character> list = new ArrayList<>();


        public void addEdge(char v, char w)
        {
            if (!adj.containsKey(v)) {
                adj.put(v, new ArrayList<Character>());
            }

            adj.get(v).add(w);
        }


        public void prepareDFS()
        {
            for (Character c : adj.keySet()) {
                if (!marked[c])
                    dfsUtil(c, adj.get(c));
            }
        }

        private void dfsUtil(Character c, List<Character> list)
        {
            marked[c] = true;
            for (Character w : list) {
                if (!marked[w]) {
                    if (adj.get(w) == null)
                        dfsUtil(w, Collections.<Character>emptyList());
                    else
                        dfsUtil(w, adj.get(w));
                }
            }
            this.list.add(c);
        }

        public Iterable<Character> topologicalSort()
        {
            prepareDFS();
            List<Character> reverse = new ArrayList<>();

            for (int i = list.size() - 1; i >= 0; i--) {
                reverse.add(list.get(i));
            }
            return reverse;
        }

    }
}
