package backjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RGBMain {

    static int R = 0;
    static int G = 1;
    static int B = 2;
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            cost[i][R] = Integer.parseInt(st.nextToken());
            cost[i][G] = Integer.parseInt(st.nextToken());
            cost[i][B] = Integer.parseInt(st.nextToken());
        }

        dp[0][R] = cost[0][R];
        dp[0][G] = cost[0][G];
        dp[0][B] = cost[0][B];

        System.out.println(Math.min(paintCost(N - 1, R), Math.min(paintCost(N - 1, G), paintCost(N - 1, B))));
    }

    static int paintCost(int N, int color) {

        if (dp[N][color] == 0) {
            if (color == R) {
                dp[N][R] = Math.min(paintCost(N - 1, G), paintCost(N - 1, B)) + cost[N][R];
            } else if (color == G) {
                dp[N][G] = Math.min(paintCost(N - 1, R), paintCost(N - 1, B)) + cost[N][G];
            } else {
                dp[N][B] = Math.min(paintCost(N - 1, R), paintCost(N - 1, G)) + cost[N][B];
            }
        }

        return dp[N][color];
    }
}
