package baekjoon.implementation.P15684사다리조작;

import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, H, result;
    private static int[][] map;
    private static boolean check = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);
        map = new int[H + 1][N + 1];
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            map[row][col] = 1;
            map[row][col + 1] = 2;
        }
        for (int i = 0; i <= 3; i++) {
            result = i;
            dfs(0);
            if (check)
                break;
        }
        System.out.println(check ? result : -1);
    }

    private static void dfs(int depth) {
        if (check)
            return;
        if (depth == result) {
            if (checkRoad())
                check = true;
            return;
        }
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j < N; j++) {
                if (map[i][j] == 0 && map[i][j + 1] == 0) {
                    map[i][j] = 1;
                    map[i][j + 1] = 2;
                    dfs(depth + 1);
                    map[i][j] = 0;
                    map[i][j + 1] = 0;
                }
            }
        }
    }

    private static boolean checkRoad() {
        for (int i = 1; i <= N; i++) {
            int row = 1;
            int col = i;
            while (row <= H) {
                if (map[row][col] == 1)
                    col++;
                else if (map[row][col] == 2)
                    col--;
                row++;
            }
            if (col != i)
                return false;
        }
        return true;
    }
}