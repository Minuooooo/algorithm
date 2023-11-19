package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11048_이동하기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N + 1][M + 1];
        int max = 0;

        for (int i = 1; i <= N; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= M; j++) {

                map[i][j] = Integer.parseInt(st.nextToken());

                max = Math.max(map[i][j - 1], Math.max(map[i - 1][j - 1], map[i - 1][j]));
                map[i][j] += max;
            }
        }

        System.out.println(map[N][M]);
    }
}