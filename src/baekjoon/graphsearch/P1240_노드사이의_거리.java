package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1240_노드사이의_거리 {

    private static int N;
    private static int[][] graph;
    private static boolean[] visited;
    private static int min;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        graph = new int[N + 1][N + 1];

        StringTokenizer st;

        for (int i = 0; i < N - 1; i++) {

            st = new StringTokenizer(br.readLine());

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            graph[first][second] = graph[second][first] = distance;
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            visited = new boolean[N + 1];
            min = Integer.MAX_VALUE;

            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            dfs(first, second, 0);
            sb.append(min).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int node, int end, int distance) {

        if (node == end) {

            min = Math.min(min, distance);
            return;
        }

        for (int next = 1; next <= N; next++) {

            if (graph[node][next] == 0 || visited[next])
                continue;

            visited[next] = true;
            dfs(next, end, distance + graph[node][next]);
            visited[next] = false;
        }
    }
}