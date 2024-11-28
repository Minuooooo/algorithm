package baekjoon.P3190;

import java.io.*;
import java.util.*;

public class Main {
    private static int N, K, X;
    private static int[][] map;
    private static char[] timesToTurn = new char[10001];
    private static int[] dr = {0, 1, 0, -1};
    private static int[] dc = {1, 0, -1, 0};
    private static int direction = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        map = new int[N + 2][N + 2];

        buildWall();

        for (int i = 0; i < K; i++) {
            String[] location = br.readLine().split(" ");
            map[Integer.parseInt(location[0])][Integer.parseInt(location[1])] = 1;
        }

        X = Integer.parseInt(br.readLine());

        for (int i = 0; i < X; i++) {
            String[] input = br.readLine().split(" ");
            timesToTurn[Integer.parseInt(input[0])] = input[1].charAt(0);
        }

        System.out.println(move());
    }

    private static void buildWall() {
        for (int i = 0; i <= N + 1; i++) {
            map[i][0] = -1;
            map[0][i] = -1;
        }
        for (int i = N + 1; i > 0; i--) {
            map[i][N + 1] = -1;
            map[N + 1][i] = -1;
        }
    }

    private static int move() {
        int time = 0;
        int row = 1;
        int column = 1;
        Queue<int[]> snake = new LinkedList<>();
        snake.offer(new int[] {row, column});

        while (true) {
            changeDirection(time);

            row += dr[direction];
            column += dc[direction];

            if (map[row][column] == -1) {
                return time + 1;
            }
            for (int[] body : snake) {
                if (Arrays.equals(new int[] {row, column}, body)) {
                    return time + 1;
                }
            }

            snake.offer(new int[] {row, column});
            if (map[row][column] != 1) {
                snake.poll();
            }
            if (map[row][column] == 1) {
                map[row][column] = 0;
            }
            time++;
        }
    }

    private static void changeDirection(int time) {
        if (timesToTurn[time] == 'L') {
            direction = (direction + 3) % 4;
        }
        if (timesToTurn[time] == 'D') {
            direction = (direction + 1) % 4;
        }
    }
}