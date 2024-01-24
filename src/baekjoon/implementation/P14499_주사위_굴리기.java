package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P14499_주사위_굴리기 {

    private static final int COUNT = 6;

    private static int N, M;
    private static int[][] map;
    private static int x, y;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};
    private static int[] dice;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        dice = new int[COUNT];

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {

                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < K; i++) {

            int command = Integer.parseInt(st.nextToken());
            move(command - 1);
        }
    }

    private static void move(int dir) {

        int nowX = x + dx[dir];
        int nowY = y + dy[dir];

        if (nowX < 0 || nowX >= N || nowY < 0 || nowY >= M)
            return;

        int temp = dice[5];

        switch (dir) {

            case 0:
                dice[5] = dice[2];
                dice[2] = dice[0];
                dice[0] = dice[3];
                dice[3] = temp;
                break;

            case 1:
                dice[5] = dice[3];
                dice[3] = dice[0];
                dice[0] = dice[2];
                dice[2] = temp;
                break;

            case 2:
                dice[5] = dice[1];
                dice[1] = dice[0];
                dice[0] = dice[4];
                dice[4] = temp;
                break;

            case 3:
                dice[5] = dice[4];
                dice[4] = dice[0];
                dice[0] = dice[1];
                dice[1] = temp;
                break;
        }

        x = nowX;
        y = nowY;

        if (map[x][y] == 0) {

            map[x][y] = dice[5];
        }

        else {

            dice[5] = map[x][y];
            map[x][y] = 0;
        }

        System.out.println(dice[0]);
    }
}