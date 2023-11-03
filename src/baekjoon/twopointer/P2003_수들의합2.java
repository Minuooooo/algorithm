package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2003_수들의합2 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] sequence = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(getCount(N, M, sequence));
    }

    private static int getCount(int N, int M, int[] arr) {

        int left = 0;
        int right = 0;

        int sum = 0;
        int count = 0;

        while (true) {

            if (sum >= M)
                sum -= arr[left++];

            else if (right == N)
                break;

            else
                sum += arr[right++];

            if (sum == M)
                count++;
        }

        return count;
    }
}