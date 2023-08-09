package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class P11724_연결요소의개수 {

    static List<List<Integer>> graph;
    static boolean[] isVisited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

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

        int count = 0;

        for(int i = 1; i < N + 1; i++) {
            if(!isVisited[i]) {
                count++;
                dfs(i);
            }
        }

        System.out.println(count);
    }

    public static void dfs(int v) {

        isVisited[v] = true;

        for(int nextV : graph.get(v)) {
            if(!isVisited[nextV])
                dfs(nextV);
        }
    }
}