package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1890_점프 {

    private static int N;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];

        for (int i = 0; i < N; i++) {

            String[] jump = br.readLine().split(" ");

            for (int j = 0; j < jump.length; j++) {
                map[i][j] = Integer.parseInt(jump[j]);
            }
        }

        long[][] dp = new long[N][N];
        dp[0][0] = 1;

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N; j++) {

                if (map[i][j] == 0)
                    continue;

                if (dp[i][j] != 0) {

                    if (check(i + map[i][j])) {

                        dp[i + map[i][j]][j] += dp[i][j];
                    }

                    if (check(j + map[i][j])) {

                        dp[i][j + map[i][j]] += dp[i][j];
                    }
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }

    private static boolean check(int index) {
        return (index < N);
    }
}