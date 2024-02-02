package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3079_입국심사 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);

        int[] arr = new int[N];
        long max = 0;

        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long left = 0;
        long right = M * max;
        long result = right;

        while (left <= right) {

            long mid = (left + right) / 2;
            long sum = 0;

            for (int i : arr) {

                long count = mid / i;

                if (sum >= M)
                    break;

                sum += count;
            }

            if (sum >= M) {

                right = mid - 1;
                result = Math.min(result, mid);
            }

            else
                left = mid + 1;
        }

        System.out.println(result);
    }
}