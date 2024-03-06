package baekjoon.practice.P13549숨바꼭질3;

import java.io.*;
import java.util.*;

public class Main {
    private static final int MIN_POINT = 0;
    private static final int MAX_POINT = 100_000;
    private static int N, K;
    private static int[] move = {-1, 1};
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);
        bfs();
        System.out.println(answer);
    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] visited = new boolean[MAX_POINT + 1];
        queue.offer(new int[] {N, 0});
        visited[N] = true;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[0] == K) {
                answer = cur[1];
                return;
            }
            int jump = cur[0] * 2;
            if (jump <= MAX_POINT && !visited[jump]) {
                queue.offer(new int[] {jump, cur[1]});
                visited[jump] = true;
            }
            for (int i = 0; i < 2; i++) {
                int walk = cur[0] + move[i];
                if (walk < MIN_POINT || walk > MAX_POINT)
                    continue;
                if (visited[walk])
                    continue;
                queue.offer(new int[] {walk, cur[1] + 1});
                visited[walk] = true;
            }
        }
    }
}