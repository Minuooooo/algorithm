package baekjoon.P16918;

import java.io.*;
import java.util.*;

public class Main {
    private static int R, C, N;
    private static int[][] board;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int time = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        board = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                board[i][j] = str.charAt(j) == '.' ? 0 : 3;
            }
        }

        while (time < N) {
            time++;
            if (time % 2 == 0) {
                installBomb(time);
            }
            if (time % 2 == 1) {
                explode(time);
            }
        }

        printBoard();
    }

    private static void installBomb(int time) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == 0) {
                    board[i][j] = time + 3;
                }
            }
        }
    }

    private static void explode(int time) {
        List<int[]> list = new ArrayList<>();

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (board[i][j] == time) {
                    list.add(new int[] {i, j});
                }
            }
        }

        for (int i = 0; i < list.size(); i++) {
            int[] now = list.get(i);
            board[now[0]][now[1]] = 0;

            for (int j = 0; j < 4; j++) {
                int nr = now[0] + dr[j];
                int nc = now[1] + dc[j];
                if (nr >= 0 && nr < R && nc >= 0 && nc < C) {
                    board[nr][nc] = 0;
                }
            }
        }
    }

    private static void printBoard() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                char status = board[i][j] == 0 ? '.' : 'O';
                System.out.print(status);
            }
            System.out.println();
        }
    }
}