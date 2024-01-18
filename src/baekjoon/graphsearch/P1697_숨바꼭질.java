package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P1697_숨바꼭질 {

    private static int[] time = new int[100001];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);

        System.out.println(bfs(N, K));
    }

    private static int bfs(int start, int end) {

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        while (!queue.isEmpty()) {

            int nowPos = queue.poll();

            if (nowPos == end)
                return time[nowPos];

            int prev = nowPos - 1;
            int next = nowPos + 1;
            int jump = nowPos * 2;

            if (prev >= 0 && time[prev] == 0) {

                queue.offer(prev);
                time[prev] = time[nowPos] + 1;
            }

            if (next <= 100000 && time[next] == 0) {

                queue.offer(next);
                time[next] = time[nowPos] + 1;
            }

            if (jump <= 100000 && time[jump] == 0) {

                queue.offer(jump);
                time[jump] = time[nowPos] + 1;
            }
        }

        return -1;
    }
}