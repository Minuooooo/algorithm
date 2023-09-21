package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2776_암기왕 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            StringBuilder sb = new StringBuilder();
            int N = Integer.parseInt(br.readLine());
            int[] origin = new int[N + 1];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                origin[j] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(origin);

            int M = Integer.parseInt(br.readLine());

            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < M; j++) {

                int left = 0;
                int right = N;
                int val = Integer.parseInt(st.nextToken());
                boolean flag = false;

                while (left <= right) {

                    int mid = (left + right) / 2;

                    if (origin[mid] == val) {
                        flag = true;
                        break;
                    }

                    else if (origin[mid] < val)
                        left = mid + 1;

                    else
                        right = mid - 1;
                }

                sb.append(flag? 1 : 0).append('\n');
            }

            System.out.print(sb);
        }
    }
}