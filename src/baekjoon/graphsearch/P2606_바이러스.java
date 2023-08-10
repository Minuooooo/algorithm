package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P2606_바이러스 {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] isVisited;
    static int virus = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computer = Integer.parseInt(br.readLine());
        int connection = Integer.parseInt(br.readLine());

        graph = new ArrayList<>(computer + 1);
        isVisited = new boolean[computer + 1];

        for(int i = 0; i < computer + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < connection; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        dfs(1);

        System.out.println(virus);
    }

    public static void dfs(int v) {

        isVisited[v] = true;

        for(int nextV : graph.get(v)) {
            if(!isVisited[nextV]) {
                virus++;
                dfs(nextV);
            }
        }
    }
}