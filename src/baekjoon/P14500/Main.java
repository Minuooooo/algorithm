package baekjoon.P14500;

import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] board;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                search(i, j, 1, board[i][j]);
                combine(i, j, 0, 1, board[i][j]);
            }
        }

        System.out.println(max);
    }

    private static void search(int row, int col, int count, int sum) {
        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        visited[row][col] = true;

        for (int d = 0; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])
                continue;

            search(nr, nc, count + 1, sum + board[nr][nc]);
        }

        visited[row][col] = false;
    }

    private static void combine(int row, int col, int dir, int count, int sum) {
        if (count == 4) {
            max = Math.max(max, sum);
            return;
        }

        visited[row][col] = true;

        for (int d = dir; d < 4; d++) {
            int nr = row + dr[d];
            int nc = col + dc[d];

            if (nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc])
                continue;

            combine(row, col, d + 1, count + 1, sum + board[nr][nc]);
        }

        visited[row][col] = false;
    }
}