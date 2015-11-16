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

package com.coderevisited.matrix;

import java.util.*;

/**
 * Algorithm:
 * 1. By traversing the matrix, store indexes of each char of the search string in a map. O(MN)
 * 2. Perform exhaustive backtrack search starting from index of first char, loop through all chars of the search string. O(MN*K*8)
 * 3. At any point if we know there can't be solution found, backtrack to the previous char and choose next path.
 */
public class StringIn2DArray
{

    private static final int X[] = {1, 1, 1, -1, -1, -1, 0, 0};

    private static final int Y[] = {1, 0, -1, 1, 0, -1, 1, -1};


    public static void main(String[] args)
    {
        int N = 5, M = 5;
        char[][] matrix = new char[][]{{'A', 'C', 'P', 'R', 'C'},
                {'X', 'S', 'O', 'P', 'C'},

                {'V', 'O', 'V', 'N', 'I'},

                {'W', 'G', 'F', 'M', 'N'},

                {'Q', 'A', 'T', 'I', 'T'}};


        String toSearch = "MICROSOFT";
        Index[] solution = new Index[toSearch.length()];
        boolean solutionExists = findSolution(matrix, N, M, toSearch, solution);
        if (solutionExists) {
            System.out.println("Solution is found and it's path : ");
            for (int i = 0; i < solution.length - 1; i++) {
                System.out.print(solution[i] + " -> ");
            }
            System.out.println(solution[solution.length - 1]);
        } else {
            System.out.println("Solution is not found");
        }
    }

    private static boolean findSolution(char[][] matrix, int N, int M, String toSearch, Index[] solution)
    {

        Map<Character, List<Index>> map = new HashMap<>();

        //Init map with every character of the search string
        for (char c : toSearch.toCharArray()) {
            map.put(c, new ArrayList<Index>());
        }

        //Update indexes of search chars from matrix
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map.containsKey(matrix[i][j])) {
                    List<Index> list = map.get(matrix[i][j]);
                    list.add(new Index(i, j));
                }
            }
        }

        List<Index> list = map.get(toSearch.charAt(0));
        if (list.isEmpty())
            return false;

        //Keep track of visited indexes
        Set<Index> visited = new HashSet<>();

        for (Index index : list) {
            solution[0] = index;
            visited.add(index);
            if (findIfWordExists(map, toSearch, 1, index, solution, visited)) {
                return true;
            } else {
                visited.remove(index);
            }
        }
        return false;

    }

    private static boolean findIfWordExists(Map<Character, List<Index>> map, String toSearch, int current, Index index, Index[] solution, Set<Index> visited)
    {

        //Verify if any indexes of current char can be included in the path
        List<Index> list = map.get(toSearch.charAt(current));
        if (list.isEmpty())
            return false;
        for (Index _index : list) {
            if (checkIfAdjacent(index, _index, visited)) {
                solution[current] = _index;
                visited.add(_index);
                if (current == toSearch.length() - 1 ||
                        findIfWordExists(map, toSearch, current + 1, _index, solution, visited))
                    return true;
                else {
                    visited.remove(_index);
                }
            }
        }

        return false;
    }

    private static boolean checkIfAdjacent(Index index, Index _index, Set<Index> visited)
    {
        for (int i = 0; i < 8; i++) {
            if (index.i + X[i] == _index.i && index.j + Y[i] == _index.j) {
                if (!visited.contains(_index))
                    return true;
            }
        }
        return false;
    }

    private static class Index
    {
        private final int i;
        private final int j;

        private Index(int i, int j)
        {
            this.i = i;
            this.j = j;
        }

        public String toString()
        {
            return "(" + i + "," + j + ")";
        }

        public int hashCode()
        {
            return i * 31 + 31 + j * 31 + 31;
        }

        public boolean equals(Object o)
        {
            if (o instanceof Index) {
                Index that = (Index) o;
                return this.i == that.i && this.j == that.j;
            }
            return false;
        }
    }

}
