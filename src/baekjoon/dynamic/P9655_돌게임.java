package baekjoon.dynamic;

import java.util.Scanner;

public class P9655_돌게임 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        String[] dp = new String[N + 1];

        dp[1] = "SK";

        for (int i = 2; i <= N; i++) {

            if (dp[i - 1].equals("SK"))
                dp[i] = "CY";

            if (dp[i - 1].equals("CY"))
                dp[i] = "SK";
        }

        System.out.println(dp[N]);
    }
}