package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14940_쉬운_최단거리 {

    private static int n, m;
    private static int[][] map;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        map = new int[n][m];

        int startRow = 0;
        int startCol = 0;
        StringTokenizer st;

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {

                switch (Integer.parseInt(st.nextToken())) {

                    case 0:
                        map[i][j] = 0;
                        break;

                    case 1:
                        map[i][j] = -1;
                        break;

                    case 2:
                        startRow = i;
                        startCol = j;
                }
            }
        }

        bfs(startRow, startCol);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                sb.append(map[i][j]).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int row, int col) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col, 0});
        map[row][col] = 0;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();
            int nowRow = now[0];
            int nowCol = now[1];
            int nowDepth = now[2];

            for (int i = 0; i < 4; i++) {

                int nextRow = nowRow + dr[i];
                int nextCol = nowCol + dc[i];

                if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= m || map[nextRow][nextCol] == 0)
                    continue;

                if (map[nextRow][nextCol] == -1) {

                    map[nextRow][nextCol] = nowDepth + 1;
                    queue.offer(new int[] {nextRow, nextCol, nowDepth + 1});
                }
            }
        }
    }
}