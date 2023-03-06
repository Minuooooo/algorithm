package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TriangleMain {

    static int[][] triangle;
    static Integer[][] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        triangle = new int[n][n];
        dp = new Integer[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j <= i; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }

        System.out.println(triangle(0, 0));
    }

    static int triangle(int depth, int index) {

        if (depth == n - 1) {
            return dp[depth][index];
        }

        if (dp[depth][index] == null) {
            dp[depth][index] = Math.max(triangle(depth + 1, index), triangle(depth + 1, index + 1)) + triangle[depth][index];
        }

        return dp[depth][index];
    }
}
