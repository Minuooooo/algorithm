package backjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BfsStudyV1Main {

    static StringBuilder sb = new StringBuilder();
    static LinkedList<Integer>[] graph;
    static int[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        graph = new LinkedList[N + 1];
        visited = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());

            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        bfs(R, visited);

        for (int i = 1; i <= N; i++) {
            sb.append(visited[i] + "\n");
        }

        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb);
    }

    public static void bfs(int v, int[] visited) {

        Queue<Integer> queue = new LinkedList<>();
        int count = 1;

        queue.offer(v);
        visited[v] = count++;

        while (!queue.isEmpty()) {

            int element = queue.poll();
            Iterator<Integer> iterator = graph[element].iterator();

            while (iterator.hasNext()) {
                int nextV = iterator.next();

                if (visited[nextV] == 0) {
                    queue.offer(nextV);
                    visited[nextV] = count++;
                }
            }
        }
    }
}
