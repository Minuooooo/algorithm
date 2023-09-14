package baekjoon.dynamic;

import java.util.Scanner;

public class P2193_이친수 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        long[][] dp = new long[N + 1][2];

        dp[1][0] = 0;
        dp[1][1] = 1;

        for (int i = 2; i <= N; i++) {

            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];  // 끝이 0
            dp[i][1] = dp[i - 1][0];  // 끝이 1
        }

        System.out.println(dp[N][0] + dp[N][1]);
    }
}