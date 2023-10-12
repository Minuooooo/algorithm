package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P5014_스타트링크 {

    static int F, S, G;
    static boolean[] visited;
    static int[] move;
    static int[] dir = new int[2];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        dir[0] = Integer.parseInt(st.nextToken());
        dir[1] = Integer.parseInt(st.nextToken()) * -1;

        move = new int[F + 1];
        visited = new boolean[F + 1];

        bfs(S);
    }

    static void bfs(int start) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        visited[start] = true;
        move[start] = 0;

        while (!queue.isEmpty()) {

            int cur = queue.poll();

            if (cur == G) {
                System.out.println(move[cur]);
                return;
            }

            for (int i = 0; i < 2; i++) {

                int next = cur + dir[i];

                if (next > F || next < 1)
                    continue;

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(next);
                    move[next] = move[cur] + 1;
                }
            }
        }

        System.out.println("use the stairs");
    }
}