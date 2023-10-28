package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2206_벽부수고이동하기 {

    static int N, M;
    static int[][] map;
    static int[][][] distance;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        distance = new int[2][N][M];

        distance[0][0][0] = 1;

        for (int i = 0; i < N; i++) {

            String str = br.readLine();

            for (int j = 0; j < M; j++) {

                int num = str.charAt(j) - '0';

                if (num == 1)
                    map[i][j] = num;
            }
        }

        if (N == 1 && M == 1) {
            System.out.println(1);
            System.exit(0);
        }

        System.out.println(bfs());
    }

    static int bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, 0});

        while (true) {

            int[] now = queue.poll();
            int nowZ = now[0];
            int nowX = now[1];
            int nowY = now[2];

            for (int i = 0; i < 4; i++) {

                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
                    continue;

                if (map[nextX][nextY] == 0) {

                    if (distance[nowZ][nextX][nextY] == 0) {

                        queue.offer(new int[] {nowZ, nextX, nextY});
                        distance[nowZ][nextX][nextY] = distance[nowZ][nowX][nowY] + 1;

                        if (nextX == N - 1 && nextY == M - 1)
                            return distance[nowZ][nextX][nextY];
                    }
                }

                else {

                    if (nowZ == 0) {

                        if (distance[1][nextX][nextY] == 0) {

                            queue.offer(new int[] {1, nextX, nextY});
                            distance[1][nextX][nextY] = distance[0][nowX][nowY] + 1;

                            if (nextX == N - 1 && nextY == M - 1)
                                return distance[1][nextX][nextY];
                        }
                    }
                }
            }

            if (queue.isEmpty())
                return -1;
        }
    }
}