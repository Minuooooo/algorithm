package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10971_외판원_순회_2 {

    static int N;
    static int[][] W;
    static boolean[] visited;
    static int cost;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        visited = new boolean[N];

        StringTokenizer st;

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {

            cost = 0;
            visited[i] = true;

            dfs(i, i, 0);

            visited[i] = false;
        }

        System.out.println(min);
    }

    public static void dfs(int start, int now, int depth) {

        if (depth == N - 1) {

            if (W[now][start] != 0) {

                cost += W[now][start];
                min = Math.min(min, cost);

                cost -= W[now][start];
            }

            return;
        }

        for (int i = 0; i < N; i++) {

            if (W[now][i] == 0)
                continue;

            if (!visited[i]) {

                cost += W[now][i];
                visited[i] = true;

                dfs(start, i, depth + 1);

                cost -= W[now][i];
                visited[i] = false;
            }
        }
    }
}