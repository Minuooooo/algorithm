package baekjoon.dynamic;

import java.util.Scanner;

public class P11727_2xn타일링2 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] dp = new int[1001];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 3;

        int n = scanner.nextInt();

        // 규칙
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2] * 2) % 10007;
        }

        System.out.println(dp[n]);
    }
}