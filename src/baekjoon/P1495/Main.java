package baekjoon.P1495;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);
        int[] dp = new int[M + 1];
        Arrays.fill(dp, -1);
        dp[S] = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int volume = Integer.parseInt(st.nextToken());
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= M; j++) {
                if (dp[j] != i)
                    continue;
                int plus = j + volume;
                int minus = j - volume;
                if (0 <= plus && plus <= M) {
                    list.add(plus);
                }
                if (0 <= minus && minus <= M) {
                    list.add(minus);
                }
            }
            for (int num : list) {
                dp[num] = i + 1;
            }
        }
        int max = -1;
        for (int i = 0; i <= M; i++) {
            if (dp[i] == N)
                max = i;
        }
        System.out.println(max);
    }
}