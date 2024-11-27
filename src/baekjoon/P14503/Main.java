package baekjoon.P14503;

import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    private static int[][] room;
    private static int[] dr = {-1, 0, 1, 0};
    private static int[] dc = {0, 1, 0, -1};
    private static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        room = new int[n][m];
        st = new StringTokenizer(br.readLine());
        int startRow = Integer.parseInt(st.nextToken());
        int startCol = Integer.parseInt(st.nextToken());
        int startDir = Integer.parseInt(st.nextToken());
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(startRow, startCol, startDir);
        System.out.println(count);
    }

    private static void dfs(int row, int col, int dir) {
        room[row][col] = -1;
        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;
            int nr = row + dr[dir];
            int nc = col + dc[dir];
            if (nr >= 0 && nr < n && nc >= 0 && nc < m && room[nr][nc] == 0) {
                count++;
                dfs(nr, nc, dir);
                return;
            }
        }
        int back = (dir + 2) % 4;
        int br = row + dr[back];
        int bc = col + dc[back];
        if (br >= 0 && br < n && bc >= 0 && bc < m && room[br][bc] != 1) {
            dfs(br, bc, dir);
        }
    }
}