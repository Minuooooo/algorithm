package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P7795_먹을것인가먹힐것인가 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] A = new int[N];
            int[] B = new int[M];

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[j] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                B[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(B);

            int count = 0;

            for (int j = 0; j < N; j++) {

                int left = 0;
                int right = M - 1;
                int idx = 0;

                while (left <= right) {

                    int mid = (left + right) / 2;

                    if (B[mid] < A[j]) {
                        left = mid + 1;
                        idx = mid + 1;
                    }

                    else
                        right = mid - 1;
                }

                count += idx;
            }

            sb.append(count).append('\n');
        }

        System.out.print(sb);
    }
}