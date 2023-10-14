package baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class P1715_카드정렬하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            priorityQueue.offer(Long.parseLong(br.readLine()));
        }

        long sum = 0;

        while (priorityQueue.size() > 1) {

            long temp1 = priorityQueue.poll();
            long temp2 = priorityQueue.poll();

            sum += (temp1 + temp2);

            priorityQueue.offer(temp1 + temp2);
        }

        System.out.println(sum);
    }
}