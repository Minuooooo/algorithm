package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P15655_N_과_M_6 {

    private static int N, M;
    private static int[] arr;
    private static int[] seq;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        arr = new int[N];
        seq = new int[M];

        String[] strArr = br.readLine().split(" ");

        for (int i = 0; i < strArr.length; i++) {
            arr[i] = Integer.parseInt(strArr[i]);
        }

        Arrays.sort(arr);

        combination(0, 0);

        System.out.println(sb);
    }

    private static void combination(int start, int depth) {

        if (depth == M) {

            appendNum();
            return;
        }

        for (int i = start; i < N; i++) {

            seq[depth] = arr[i];
            combination(i + 1, depth + 1);
        }
    }

    private static void appendNum() {

        for (int i = 0; i < M; i++) {
            sb.append(seq[i]).append(" ");
        }

        sb.append("\n");
    }
}