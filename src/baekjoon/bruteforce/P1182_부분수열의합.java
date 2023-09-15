package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1182_부분수열의합 {

    static int[] seq;
    static int N, S;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        seq = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);

        if (S == 0)
            System.out.println(count - 1);

        else
            System.out.println(count);
    }

    public static void dfs(int depth, int sum) {

        if (depth == N) {

            if (sum == S)
                count++;

            return;
        }

        dfs(depth + 1, sum + seq[depth]);
        dfs(depth + 1, sum);
    }
}