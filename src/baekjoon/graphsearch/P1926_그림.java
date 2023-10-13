package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1926_그림 {

    static int n, m;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];

        int count = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                if (map[i][j] == 1) {
                    count++;
                    max = Math.max(max, bfs(i, j));
                }
            }
        }

        System.out.print(count + "\n" + max);
    }

    static int bfs(int column, int row) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {column, row});
        map[column][row] = 0;

        int area = 1;

        while (!queue.isEmpty()) {

            int[] cur = queue.poll();
            int curX = cur[0];
            int curY = cur[1];

            for (int i = 0; i < 4; i++) {

                int nextX = curX + dx[i];
                int nextY = curY + dy[i];

                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m && map[nextX][nextY] == 1) {
                    map[nextX][nextY] = 0;
                    queue.offer(new int[] {nextX, nextY});
                    area++;
                }
            }
        }

        return area;
    }
}