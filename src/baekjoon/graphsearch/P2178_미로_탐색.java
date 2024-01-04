package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2178_미로_탐색 {

    static int N, M;
    static int[][] map;
    static int[] dx = {-1 , 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strArr = br.readLine().split(" ");
        N = Integer.parseInt(strArr[0]);
        M = Integer.parseInt(strArr[1]);
        map = new int[N][M];

        for (int i = 0; i < N; i++) {

            String str = br.readLine();

            for (int j = 0; j < str.length(); j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        bfs();

        System.out.println(map[N - 1][M - 1]);
    }

    private static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});

        while (!queue.isEmpty()) {

            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {

                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
                    continue;

                if (map[nextX][nextY] == 1) {

                    queue.offer(new int[] {nextX, nextY});
                    map[nextX][nextY] = map[nowX][nowY] + 1;
                }
            }
        }
    }
}