package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P15650_N과M {

    public static int[] arr;
    public static int N, M;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];  // M개로 구성된 수열

        sequence(1, 0);  // 1부터 시작
        System.out.println(sb);
    }

    public static void sequence(int at, int depth) {  // 시작하는 수 at, depth 개로 구성된 수열

        if(depth == M) {  // M개의 수열이 채워졌을 경우

            for(int val : arr) {
                sb.append(val).append(' ');
            }

            sb.append('\n');
            return;
        }

        for(int i = at; i <= N; i++) {  // 1부터 N 까지의 모든 수열 경우의 수

            arr[depth] = i;
            sequence(i + 1, depth + 1);
        }
    }
}