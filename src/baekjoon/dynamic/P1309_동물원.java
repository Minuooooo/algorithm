package baekjoon.dynamic;

import java.util.Scanner;

public class P1309_동물원 {

    static final int MOD = 9901;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        long[][] resultArr = countCase(N);

        System.out.println((resultArr[N][0] + resultArr[N][1] + resultArr[N][2]) % MOD);

        scanner.close();
    }

    private static long[][] countCase(int row) {

        long[][] dp = new long[row + 1][3];
        dp[1][0] = dp[1][1] = dp[1][2] = 1;

        for (int i = 2; i <= row; i++) {

            dp[i][0] = (dp[i - 1][0] + dp[i - 1][1] + dp[i - 1][2]) % MOD;
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % MOD;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % MOD;
        }

        return dp;
    }
}