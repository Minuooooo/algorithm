package baekjoon.greedy.P1080행렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        int[][] mapA = new int[N][M];
        int[][] mapB = new int[N][M];
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                mapA[i][j] = Integer.parseInt(str[j]);
            }
        }
        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                mapB[i][j] = Integer.parseInt(str[j]);
            }
        }
        int count = 0;
        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j < M - 2; j++) {
                if (mapA[i][j] == mapB[i][j])
                    continue;
                for (int k = i; k < i + 3; k++) {
                    for (int h = j; h < j + 3; h++) {
                        mapA[k][h] = mapA[k][h] == 0 ? 1 : 0;
                    }
                }
                count++;
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mapA[i][j] != mapB[i][j]) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(count);
    }
}