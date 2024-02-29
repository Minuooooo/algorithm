package baekjoon.greedy.P15903카드합체놀이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);
        Queue<Long> queue = new PriorityQueue<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            queue.offer(Long.parseLong(st.nextToken()));
        }
        for (int i = 0; i < m; i++) {
            long x = queue.poll();
            long y = queue.poll();
            for (int j = 0; j < 2; j++) {
                queue.offer(x + y);
            }
        }
        long sum = 0;
        while (!queue.isEmpty()) {
            sum += queue.poll();
        }
        System.out.println(sum);
    }
}