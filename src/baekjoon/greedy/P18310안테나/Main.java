package baekjoon.greedy.P18310안테나;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int left = 0;
        int right = N - 1;
        long min = Long.MAX_VALUE;
        int result = N - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (i == mid)
                    continue;
                sum += Math.abs(arr[mid] - arr[i]);
            }
            if (sum < min) {
                min = sum;
                result = arr[mid];
                left = mid + 1;
            }
            else
                right = mid - 1;
        }
        System.out.println(result);
    }
}