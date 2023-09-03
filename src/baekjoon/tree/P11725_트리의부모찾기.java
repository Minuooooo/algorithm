package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P11725_트리의부모찾기 {

    static int N;
    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] isVisited;
    static int[] parent;  // 자식 노드를 index 로 하여 부모 노드 저장

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList<>(N + 1);
        isVisited = new boolean[N + 1];
        parent = new int[N + 1];

        for(int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < N - 1; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1);

        for(int i = 2; i <= N; i++) {
            System.out.println(parent[i]);
        }
    }

    static void dfs(int v) {

        isVisited[v] = true;

        for(int nextV : graph.get(v)) {

            if(!isVisited[nextV]) {
                parent[nextV] = v;  // 자식을 index 로 하여 부모 저장
                dfs(nextV);
            }
        }
    }
}