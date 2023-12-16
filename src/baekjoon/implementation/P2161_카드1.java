package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class P2161_카드1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        Queue<Integer> card = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            card.offer(i);
        }

        StringBuilder sb = new StringBuilder();

        while (card.size() > 1) {
            sb.append(card.poll()).append(" ");
            card.offer(card.poll());
        }

        sb.append(card.peek());

        System.out.println(sb);
    }
}