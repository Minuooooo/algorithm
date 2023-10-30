package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P1325_효율적인해킹 {

    static List<List<Integer>> graph;
    static boolean[] visited;
    static int count;
    static int max = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>(N + 1);

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(v).add(u);
        }

        int[] hackedComputerCount = new int[N + 1];

        for (int i = 1; i < N + 1; i++) {

            visited = new boolean[N + 1];
            count = 0;

            bfs(i);
            hackedComputerCount[i] = count;

            max = Math.max(count, max);
        }

        for (int i = 1; i < N + 1; i++) {

            if (hackedComputerCount[i] == max)
                sb.append(i).append(" ");
        }

        System.out.println(sb);
    }

    static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {

            int now = queue.poll();

            for (int nextV : graph.get(now)) {

                if (!visited[nextV]) {

                    queue.offer(nextV);
                    count++;

                    visited[nextV] = true;
                }
            }
        }
    }
}