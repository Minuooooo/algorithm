package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P13023_ABCDE {

    private static final int EDGE = 4;
    private static int N, M;
    private static List<List<Integer>> graph;
    private static boolean[] visited;
    private static int result = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        graph = new ArrayList<>(N);
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st;

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }

        for (int i = 0; i < N; i++) {

            if (result == 0)
                dfs(i, 0);
        }

        System.out.println(result);
    }

    private static void dfs(int node, int depth) {

        visited[node] = true;

        if (depth == EDGE) {

            result = 1;
            return;
        }

        for (int nextNode : graph.get(node)) {

            if (visited[nextNode])
                continue;

            dfs(nextNode, depth + 1);
        }

        visited[node] = false;
    }
}