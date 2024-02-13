package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P16401_과자_나눠주기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int M = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int[] snack = new int[N];
        int max = 1;

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            snack[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, snack[i]);
        }

        Queue<Integer> queue = new LinkedList<>();
        int left = 1;
        int right = max;
        int result = 0;

        while (left <= right) {

            int mid = (left + right) / 2;
            int count = 0;

            for (int value : snack) {
                queue.offer(value);
            }

            while (!queue.isEmpty()) {

                int cur = queue.poll();

                if ((cur - mid) == 0) {

                    count++;
                    continue;
                }

                if ((cur - mid) > 0) {

                    queue.offer(cur - mid);
                    count++;
                }
            }

            if (count >= M) {

                result = Math.max(result, mid);
                left = mid + 1;
            }

            else
                right = mid - 1;
        }

        System.out.println(result);
    }
}