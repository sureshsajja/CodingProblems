package com.coderevisited.coding.matrix;

import java.util.*;

/**
 * Algorithm:
 * 1. By traversing the matrix, store indexes of each char of the search string in a map.
 * 2. start from index of first char, loop through all chars of the search string.
 * 3. At any point if we know there can't be solution found back track to the previous solution.
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

        Map<Character, List<Index>> map = new HashMap<>();
        String toSearch = "MICROSOFT";
        for (char c : toSearch.toCharArray()) {
            map.put(c, new ArrayList<Index>());
        }

        findIndices(matrix, map, N, M);
        Index[] solution = new Index[toSearch.length()];
        boolean solutionExists = findSolution(map, toSearch, solution);
        if (solutionExists) {
            System.out.println("Solution found and it's path : ");
            for (int i = 0; i < solution.length - 1; i++) {
                System.out.print(solution[i] + " -> ");
            }
            System.out.println(solution[solution.length - 1]);
        }
    }

    private static boolean findSolution(Map<Character, List<Index>> map, String toSearch, Index[] solution)
    {

        List<Index> list = map.get(toSearch.charAt(0));
        Set<Index> visited = new HashSet<>();
        if (list.isEmpty())
            return false;

        for (Index index : list) {
            solution[0] = index;
            if (findIfWordExists(map, toSearch, 1, index, solution, visited)) {
                return true;
            }
        }
        return false;

    }

    private static boolean findIfWordExists(Map<Character, List<Index>> map, String toSearch, int current, Index index, Index[] solution, Set<Index> visited)
    {

        List<Index> list = map.get(toSearch.charAt(current));
        if (list.isEmpty())
            return false;
        for (Index _index : list) {
            if (checkIfAdjacent(index, _index, visited)) {
                solution[current] = _index;
                if (current == toSearch.length() - 1 ||
                        findIfWordExists(map, toSearch, current + 1, _index, solution, visited))
                    return true;
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

    private static void findIndices(char[][] matrix, Map<Character, List<Index>> map, int N, int M)
    {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map.containsKey(matrix[i][j])) {
                    List<Index> list = map.get(matrix[i][j]);
                    list.add(new Index(i, j));
                }
            }
        }
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
