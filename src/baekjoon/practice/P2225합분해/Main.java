package baekjoon.practice.P2225합분해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[][] dp = new int[K + 1][N + 1];
        for (int i = 0; i <= N; i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i <= K; i++) {
            dp[i][0] = 1;
        }
        for (int i = 2; i <= K; i++) {
            for (int j = 1; j <= N; j++) {
                dp[i][j] = (dp[i][j - 1] + dp[i - 1][j]) % 1_000_000_000;
            }
        }
        System.out.println(dp[K][N]);
    }
}