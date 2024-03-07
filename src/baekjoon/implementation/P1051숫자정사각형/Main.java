package baekjoon.implementation.P1051숫자정사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N, M;
    private static int[][] rectangle;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        rectangle = new int[N][M];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                rectangle[i][j] = str.charAt(j) - '0';
            }
        }
        int answer = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int row = i + 1;
                int col = j + 1;
                int len = 1;
                while (row < N && col < M) {
                    if (rectangle[i][j] == rectangle[row][j] && rectangle[row][j] == rectangle[i][col] && rectangle[i][col] == rectangle[row][col]) {
                        len = row - i + 1;
                    }
                    row++;
                    col++;
                }
                answer = Math.max(answer, len);
            }
        }
        System.out.println(answer * answer);
    }
}