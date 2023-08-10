package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P5567_결혼식 {

    static ArrayList<ArrayList<Integer>> graph;
    static boolean[] isVisited;
    static int colleague = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        graph = new ArrayList<>(n + 1);
        isVisited = new boolean[n + 1];

        for(int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs(1);

        System.out.println(colleague);
    }

    public static void bfs(int v) {

        if(graph.get(1).size() == 0)
            return;

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(v);
        isVisited[v] = true;

        int depth = 0;

        while (depth <= graph.get(1).size()) {

            if(!queue.isEmpty()) {

                int now = queue.poll();

                for(int nextV : graph.get(now)) {
                    if(!isVisited[nextV]) {
                        queue.offer(nextV);
                        isVisited[nextV] = true;
                        colleague++;
                    }
                }
            }

            depth++;
        }
    }
}