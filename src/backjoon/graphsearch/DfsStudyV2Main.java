package backjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class DfsStudyV2Main {

    static StringBuilder sb = new StringBuilder();
    static LinkedList<Integer>[] graph;
    static int[] visited;
    static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new LinkedList[N + 1]; //그래프
        visited = new int[N + 1]; //방문

        for (int i = 1; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1); //양방향
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i], Collections.reverseOrder()); //내림차순
        }

        dfs(R, graph, visited);

        for (int i = 1; i <= N; i++) {
            sb.append(visited[i] + "\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    public static void dfs(int v, LinkedList<Integer>[] graph, int[] visited) {

        Iterator<Integer> iterator = graph[v].iterator();

        visited[v] = ++count;

        while (iterator.hasNext()) {

            int nextV = iterator.next();

            if (visited[nextV] == 0) {
                dfs(nextV, graph, visited);
            }
        }
    }
}
