package baekjoon.P2302;

import java.io.*;

public class Main {
    static final int MAX_SEAT = 41;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] dp = new int[MAX_SEAT];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= N; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        int ans = 1;
        int before = 0;
        for (int i = 0; i < M; i++) {
            int vip = Integer.parseInt(br.readLine());
            ans *= dp[vip - before - 1];
            before = vip;
        }
        ans *= dp[N - before];
        System.out.println(ans);
    }
}