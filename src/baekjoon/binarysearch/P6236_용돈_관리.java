package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P6236_용돈_관리 {

    private static int N;
    private static int[] arr;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        arr = new int[N];
        int M = Integer.parseInt(input[1]);

        int max = 1;
        int sum = 0;

        for (int i = 0; i < N; i++) {

            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        int left = max;
        int right = sum;
        int result = max;

        while (left <= right) {

            int mid = (left + right) / 2;

            if (getCount(mid) <= M) {

                result = mid;
                right = mid - 1;
            }

            else {

                left = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static int getCount(int money) {

        int balance = money;
        int count = 1;

        for (int i = 0; i < N; i++) {

            balance -= arr[i];

            if (balance < 0) {

                balance = money - arr[i];
                count++;
            }
        }

        return count;
    }
}