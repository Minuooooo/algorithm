package baekjoon.implementation.P14890경사로;

import java.io.*;
import java.util.*;

public class Main {
    private static int N, L;
    private static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (checkForward(i, 0, 0))
                result++;
            if (checkForward(0, i, 1))
                result++;
        }
        System.out.println(result);
    }

    private static boolean checkForward(int r, int c, int d) {
        int[] height = new int[N];
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            height[i] = (d == 0) ? map[r][c + i] : map[r + i][c];
        }
        for (int i = 0; i < N - 1; i++) {
            if (height[i] == height[i + 1])
                continue;
            if (Math.abs(height[i] - height[i + 1]) > 1)
                return false;
            if (height[i] - 1 == height[i + 1]) {
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N || height[j] != height[i + 1] || visited[j])
                        return false;
                    visited[j] = true;
                }
            }
            if (height[i] + 1 == height[i + 1]) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || height[j] != height[i] || visited[j])
                        return false;
                    visited[j] = true;
                }
            }
        }
        return true;
    }
}