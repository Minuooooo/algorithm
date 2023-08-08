package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1260_DFS와BFS {

    static boolean[] visited;
    static ArrayList<ArrayList<Integer>> graph;
    static int N, M, V;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        graph = new ArrayList<>(N + 1);

        for(int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for(int i = 1; i < N + 1; i++) {
            Collections.sort(graph.get(i));
        }

        dfs(V);
        sb.append('\n');

        visited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);
    }
    static void dfs(int v) {
        visited[v] = true;
        sb.append(v).append(" ");

        for(int nextV : graph.get(v)) {
            if(!visited[nextV])
                dfs(nextV);
        }
    }
    static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        visited[v] = true;

        while(!queue.isEmpty()) {
            int temp = queue.poll();
            sb.append(temp).append(" ");

            for(int nextV : graph.get(temp)) {
                if(!visited[nextV]) {
                    queue.offer(nextV);
                    visited[nextV] = true;
                }
            }
        }
    }
}