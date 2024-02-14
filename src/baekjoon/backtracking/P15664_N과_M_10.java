package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P15664_N과_M_10 {

    private static int N, M;
    private static int[] arr;
    private static int[] seq;
    private static Set<String> set = new LinkedHashSet<>();
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        arr = new int[N];
        seq = new int[M];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        dfs(0, 0);
        sb = new StringBuilder();

        for (String cur : set) {

            String[] strArr = cur.split(" ");

            for (String str : strArr) {
                sb.append(str).append(" ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int start, int depth) {

        if (depth == M) {

            sb = new StringBuilder();

            for (int i = 0; i < M; i++) {
                sb.append(seq[i]).append(" ");
            }

            set.add(sb.toString());

            return;
        }

        for (int i = start; i < N; i++) {

            seq[depth] = arr[i];
            dfs(i + 1, depth + 1);
        }
    }
}