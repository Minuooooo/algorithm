package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2589_보물섬 {

    static int N, M;
    static char[][] map;
    static int[][] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {

            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < M; j++) {

                if (map[i][j] == 'L')
                    bfs(i, j);
            }
        }

        System.out.println(max);
    }

    static void bfs(int startX, int startY) {

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < M; j++) {

                visited[i][j] = -1;
            }
        }

        queue.offer(new int[] {startX, startY});
        visited[startX][startY] = 0;

        while (!queue.isEmpty()) {

            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {

                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
                    continue;

                if (map[nextX][nextY] == 'L' && visited[nextX][nextY] == -1) {

                    queue.offer(new int[] {nextX, nextY});

                    visited[nextX][nextY] = visited[nowX][nowY] + 1;
                    max = Math.max(max, visited[nextX][nextY]);
                }
            }
        }
    }
}