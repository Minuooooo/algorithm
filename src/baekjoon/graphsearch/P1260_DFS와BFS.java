package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;
import java.util.LinkedList;

public class P1260_DFS와BFS {

    static List<List<Integer>> graph;
    static boolean[] isVisited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(N + 1);
        isVisited = new boolean[N + 1];

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

        isVisited = new boolean[N + 1];
        bfs(V);

        System.out.println(sb);

    }

    public static void dfs(int v) {

        sb.append(v).append(" ");
        isVisited[v] = true;

        for(int nextV : graph.get(v)) {
            if(!isVisited[nextV])
                dfs(nextV);
        }
    }

    public static void bfs(int v) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        isVisited[v] = true;

        while (!queue.isEmpty()) {

            int now = queue.poll();
            sb.append(now).append(" ");

            for(int nextV : graph.get(now)) {
                if(!isVisited[nextV]) {
                    queue.offer(nextV);
                    isVisited[nextV] = true;
                }
            }
        }
    }
}