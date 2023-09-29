package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2644_촌수계산 {

    static int n;
    static List<List<Integer>> graph;
    static int[] relation;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList<>(n + 1);
        relation = new int[n + 1];

        Arrays.fill(relation, -1);

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int edge = Integer.parseInt(br.readLine());

        for (int i = 0; i < edge; i++) {

            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        bfs(start, end);

        System.out.println(relation[end]);
    }

    public static void bfs(int start, int end) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        relation[start] = 0;

        while (!queue.isEmpty()) {

            int now = queue.poll();

            if (now == end)
                return;

            for (int nextV : graph.get(now)) {

                if (relation[nextV] != -1)
                    continue;

                queue.offer(nextV);
                relation[nextV] = relation[now] + 1;
            }
        }
    }
}