package baekjoon.implementation.P2573빙산;

import java.io.*;
import java.util.*;

public class Main {
    private static int N, M;
    private static int[][] map;
    private static int[][] updatedMap;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};
    private static int year = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        map = new int[N][M];
        updatedMap = new int[N][M];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                updatedMap[i][j] = map[i][j];
            }
        }
        while (true) {
            int dummy = 0;
            visited = new boolean[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (visited[i][j])
                        continue;
                    if (map[i][j] == 0)
                        continue;
                    search(i, j);
                    dummy++;
                }
            }
            if (dummy > 1)
                break;
            if (dummy == 0) {
                System.out.println(0);
                return;
            }
            updateMap();
        }
        System.out.println(year);
    }

    private static void updateMap() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0)
                    continue;
                for (int k = 0; k < 4; k++) {
                    int nr = i + dr[k];
                    int nc = j + dc[k];
                    if (map[nr][nc] == 0)
                        updatedMap[i][j]--;
                }
                if (updatedMap[i][j] < 0)
                    updatedMap[i][j] = 0;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = updatedMap[i][j];
            }
        }
        year++;
    }

    private static void search(int row, int col) {
        visited[row][col] = true;
        for (int i = 0; i < 4; i++) {
            int nr = row + dr[i];
            int nc = col + dc[i];
            if (visited[nr][nc])
                continue;
            if (map[nr][nc] == 0)
                continue;
            search(nr, nc);
        }
    }
}