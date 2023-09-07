package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1912_연속합 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] seq = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n];
        dp[0] = seq[0];
        int max = dp[0];

        for (int i = 1; i < n; i++) {

            dp[i] = Math.max(dp[i - 1] + seq[i], seq[i]);  // 연속합을 순차적으로 비교
            max = Math.max(dp[i], max);  // 최댓값
        }

        System.out.println(max);
    }
}