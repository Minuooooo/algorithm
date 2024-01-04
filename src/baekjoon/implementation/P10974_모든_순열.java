package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P10974_모든_순열 {

    static int N;
    static int[] seq;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        seq = new int[N];
        visited = new boolean[N + 1];

        dfs(0);

        System.out.println(sb);
    }

    public static void dfs(int depth) {

        if (depth == N) {

            appendNum();
            return;
        }

        for (int i = 1; i <= N; i++) {

            if (!visited[i]) {

                seq[depth] = i;

                visited[i] = true;
                dfs(depth + 1);

                visited[i] = false;
            }
        }
    }

    public static void appendNum() {

        for (int i = 0; i < N; i++) {
            sb.append(seq[i]).append(" ");
        }

        sb.append("\n");
    }
}