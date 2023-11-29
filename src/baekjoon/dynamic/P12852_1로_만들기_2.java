package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P12852_1로_만들기_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] dp = new int[N + 1][2];
        boolean flag = false;

        for (int i = 2; i <= N; i++) {

            dp[i][0] = Integer.MAX_VALUE;

            if (i % 2 == 0) {
                if (dp[i][0] > dp[i / 2][0]) {
                    dp[i][0] = dp[i / 2][0] + 1;
                    dp[i][1] = 2;
                    flag = true;
                }
            }

            if (i % 3 == 0) {
                if (dp[i][0] > dp[i / 3][0]) {
                    dp[i][0] = dp[i / 3][0] + 1;
                    dp[i][1] = 3;
                    flag = true;
                }
            }

            if (dp[i][0] > dp[i - 1][0]) {
                dp[i][0] = dp[i - 1][0] + 1;
                dp[i][1] = 1;
                flag = true;
            }

            if (!flag)
                dp[i][0] = dp[i - 1][0] + 1;
        }

        System.out.println(dp[N][0]);

        int print = N;

        while (print > 1) {
            sb.append(print).append(" ");

            if (dp[print][1] == 2 || dp[print][1] == 3) {
                print /= dp[print][1];
                continue;
            }

            print--;
        }

        sb.append(1);

        System.out.println(sb);
    }
}