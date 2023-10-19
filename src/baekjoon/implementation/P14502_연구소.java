package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P14502_연구소 {

    static int N, M;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int[][] lab;
    static int[][] virus;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        lab = new int[N][M];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(max);
    }

    static void dfs(int depth) {

        if (depth == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < M; j++) {

                if (lab[i][j] == 0) {
                    lab[i][j] = 1;
                    dfs(depth + 1);
                    lab[i][j] = 0;
                }
            }
        }
    }

    static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        virus = new int[N][M];
        int safe = 0;

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < M; j++) {

                virus[i][j] = lab[i][j];

                if (virus[i][j] == 2)
                    queue.offer(new int[] {i, j});
            }
        }

        while (!queue.isEmpty()) {

            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {

                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && virus[nextX][nextY] == 0) {
                    virus[nextX][nextY] = 2;
                    queue.offer(new int[] {nextX, nextY});
                }
            }
        }

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < M; j++) {

                if (virus[i][j] == 0)
                    safe++;
            }
        }

        max = Math.max(max, safe);
    }
}