package backjoon.step12;

import java.util.Scanner;

public class ChessMain {

    static boolean[][] chess;
    static int min = 64;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        chess = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String color = scanner.next();

            for (int j = 0; j < M; j++) {
                if(color.charAt(j) == 'W')
                    chess[i][j] = true;
                else
                    chess[i][j] = false;
            }
        }

        int rowN = N - 7;
        int colM = M - 7;

        for (int i = 0; i < rowN; i++) {
            for (int j = 0; j < colM; j++) {
                check(i, j);
            }
        }

        System.out.println(min);
    }

    public static void check(int x, int y) {
        int endX = x + 8;
        int endY = y + 8;
        int count = 0;

        boolean tf = chess[x][y];

        for (int i = x; i < endX; i++) {
            for (int j = y; j < endY; j++) {
                if (chess[i][j] != tf) {
                    count++;
                }

                tf = !tf;
            }

            tf = !tf;
        }

        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}
