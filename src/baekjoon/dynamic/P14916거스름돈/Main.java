package baekjoon.dynamic.P14916거스름돈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100_001];
        Arrays.fill(dp, -1);
        dp[2] = dp[5] = 1;
        dp[4] = 2;
        for (int i = 6; i <= n; i++) {
            if (dp[i - 2] > 0 && dp[i - 5] == -1)
                dp[i] = dp[i - 2] + 1;
            if (dp[i - 2] == -1 && dp[i - 5] > 0)
                dp[i] = dp[i - 5] + 1;
            if (dp[i - 2] > 0 && dp[i - 5] > 0)
                dp[i] = Math.min(dp[i - 2], dp[i - 5]) + 1;
        }
        System.out.println(dp[n]);
    }
}