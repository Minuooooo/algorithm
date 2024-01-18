package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P15656_N과_M_7 {

    private static int N, M;
    private static int[] arr;
    private static int[] seq;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        seq = new int[M];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        combination(0);

        System.out.println(sb);
    }

    private static void combination(int depth) {

        if (depth == M) {

            appendNum();
            return;
        }

        for (int i = 0; i < N; i++) {

            seq[depth] = arr[i];
            combination(depth + 1);
        }
    }

    private static void appendNum() {

        for (int i = 0; i < M; i++) {
            sb.append(seq[i]).append(" ");
        }

        sb.append("\n");
    }
}