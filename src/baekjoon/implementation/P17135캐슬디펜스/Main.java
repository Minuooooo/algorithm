package baekjoon.implementation.P17135캐슬디펜스;

import java.io.*;
import java.util.*;

public class Main {
    private static int N, M, D;
    private static int[][] map;
    private static int[][] copyMap;
    private static int[] arrow = new int[3];
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        D = Integer.parseInt(input[2]);
        map = new int[N][M];
        copyMap = new int[N][M];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int start, int depth) {
        if (depth == 3) {
            answer = Math.max(answer, attack());
            return;
        }
        for (int i = start; i < M; i++) {
            arrow[depth] = i;
            dfs(i + 1, depth + 1);
        }
    }

    private static int attack() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        int result = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int pos = 0; pos < 3; pos++) {
                int cur = arrow[pos];
                int curRow = N - i;
                int row = -1;
                int col = -1;
                int distance = Integer.MAX_VALUE;
                for (int j = N - i - 1; j >= 0; j--) {
                    for (int k = 0; k < M; k++) {
                        int curDis = Math.abs(curRow - j) + Math.abs(cur - k);
                        if (copyMap[j][k] == 0)
                            continue;
                        if (curDis > D)
                            continue;
                        if (curDis == distance && k < col) {
                            row = j;
                            col = k;
                        }
                        if (curDis < distance) {
                            distance = curDis;
                            row = j;
                            col = k;
                        }
                    }
                }
                if (row == -1 && col == -1)
                    continue;
                queue.offer(new int[] {row, col});
            }
            while (!queue.isEmpty()) {
                int[] cur = queue.poll();
                if (copyMap[cur[0]][cur[1]] == 1) {
                    copyMap[cur[0]][cur[1]] = 0;
                    result++;
                }
            }
        }
        return result;
    }
}