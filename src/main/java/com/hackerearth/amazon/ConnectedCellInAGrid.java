package com.hackerearth.amazon;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;
import static java.lang.System.in;
import static java.lang.System.out;

/**
 * ssajja 16-08-2016
 */
public class ConnectedCellInAGrid {

    private static final int[] rowNeighbours = new int[] {-1, -1, -1, 0, 0, 1, 1, 1};
    private static final int[] columnNeighbours = new int[] {-1, 0, 1, -1, 1, -1, 0, 1};

    private static BufferedReader reader;
    private static StringTokenizer tokenizer;
    private static PrintWriter pw;

    private static String next() throws IOException {
        while (!tokenizer.hasMoreTokens()) {
            tokenizer = new StringTokenizer(reader.readLine());
        }
        return tokenizer.nextToken();
    }

    private static int nextInt() throws IOException {
        return parseInt(next());
    }

    public static void main(String[] args) throws IOException {

        reader = new BufferedReader(new InputStreamReader(in));
        tokenizer = new StringTokenizer("");
        pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(out)));

        solve();

        reader.close();
        pw.close();

    }

    private static void solve() throws IOException {

        int m = nextInt();
        int n = nextInt();
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = nextInt();
            }
        }

        boolean[][] visited = new boolean[m][n];
        int largeCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    int[] count = new int[] {1};
                    dfs(matrix, i, j, visited, m, n, count);
                    if (largeCount < count[0]) {
                        largeCount = count[0];
                    }
                }
            }
        }

        pw.println(largeCount);
    }

    private static void dfs(int[][] matrix, int i, int j, boolean[][] visited, int m, int n, int[] count) {
        visited[i][j] = true;
        for (int k = 0; k < 8; k++) {
            int row = i + rowNeighbours[k];
            int column = j + columnNeighbours[k];
            if (row >= 0 && row < m && column >= 0 && column < n && !visited[row][column] && matrix[row][column] == 1) {
                count[0] += 1;
                dfs(matrix, row, column, visited, m, n, count);
            }
        }
    }
}
