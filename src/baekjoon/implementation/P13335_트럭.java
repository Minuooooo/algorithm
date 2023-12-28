package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P13335_트럭 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] trucks = new int[n];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            trucks[i] = Integer.parseInt(st.nextToken());
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < w; i++) {
            queue.offer(0);
        }

        int index = 0;
        int weight = 0;
        int count = 0;

        while (!queue.isEmpty()) {

            count++;
            weight -= queue.poll();

            if (index == n) {

                continue;
            }

            if (weight + trucks[index] <= L) {

                weight += trucks[index];
                queue.offer(trucks[index]);
                index++;
            }

            else {

                queue.offer(0);
            }
        }

        System.out.println(count);
    }
}