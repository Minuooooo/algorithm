package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1743_음식물피하기 {

    static int N, M;
    static int[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int size = 1;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 0; i < K; i++) {

            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            map[x][y] = 1;
        }

        int max = 1;

        for (int i = 1; i <= N; i++) {

            for (int j = 1; j <= M; j++) {

                if (map[i][j] == 1) {
                    bfs(i, j);
                    max = Math.max(max, size);
                    size = 1;
                }
            }
        }

        System.out.println(max);
    }

    static void bfs(int row, int column) {

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {row, column});
        map[row][column] = 0;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {

                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextX <= N && nextY >= 0 && nextY <= M && map[nextX][nextY] == 1) {
                    queue.offer(new int[] {nextX, nextY});
                    map[nextX][nextY] = 0;
                    size++;
                }
            }
        }
    }
}