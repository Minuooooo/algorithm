package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2638_치즈 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {

                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int result = 0;

        while (true) {

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[] {0, 0});
            map[0][0] = -1;

            while (!queue.isEmpty()) {

                int[] now = queue.poll();
                int nowX = now[0];
                int nowY = now[1];

                for (int i = 0; i < 4; i++) {

                    int nextX = nowX + dx[i];
                    int nextY = nowY + dy[i];

                    if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
                        continue;

                    if (map[nextX][nextY] == 0) {
                        map[nextX][nextY] = -1;
                        queue.offer(new int[] {nextX, nextY});
                    }
                }
            }

            Queue<int[]> removedCheese = new LinkedList<>();

            for (int i = 0; i < N; i++) {

                for (int j = 0; j < M; j++) {

                    int count = 0;

                    if (map[i][j] == 1) {

                        for (int k = 0; k < 4; k++) {

                            int nextX = i + dx[k];
                            int nextY = j + dy[k];

                            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M)
                                continue;

                            if (map[nextX][nextY] == -1) {

                                count++;

                                if (count >= 2)
                                    break;
                            }
                        }
                    }

                    if (count == 2)
                        removedCheese.offer(new int[] {i, j});
                }
            }

            if (removedCheese.isEmpty()) {
                System.out.println(result);
                return;
            }

            result++;

            while (!removedCheese.isEmpty()) {
                int[] removed = removedCheese.poll();
                map[removed[0]][removed[1]] = 0;
            }

            for (int i = 0; i < N; i++) {

                for (int j = 0; j < M; j++) {

                    if (map[i][j] == -1)
                        map[i][j] = 0;
                }
            }
        }
    }
}