package baekjoon.implementation.P1138한줄로서기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        boolean[] visited = new boolean[N];
        Arrays.fill(arr, N);
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            int pos = Integer.parseInt(st.nextToken());
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (visited[j])
                    continue;
                if (count == pos) {
                    arr[j] = i;
                    visited[j] = true;
                    break;
                }
                if (arr[j] > i)
                    count++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append(" ");
        }
        System.out.println(sb);
    }
}