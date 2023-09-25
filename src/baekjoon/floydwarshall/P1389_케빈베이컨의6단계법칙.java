package baekjoon.floydwarshall;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1389_케빈베이컨의6단계법칙 {

    static final int INF = 987654321;  // 간선이 없는 무한대 값

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] friend = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {

                if (i != j)
                    friend[i][j] = INF;
            }
        }

        for (int i = 0; i < M; i++) {

            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            friend[u][v] = 1;
            friend[v][u] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    friend[i][j] = Math.min(friend[i][j], (friend[i][k] + friend[k][j]));  // 최단 경로
                }
            }
        }

        int min = INF;
        int idx = -1;

        for (int i = 1; i <= N; i++) {

            int total = 0;

            for (int j = 1; j <= N; j++) {
                total += friend[i][j];
            }

            if (total < min) {
                min = total;
                idx = i;
            }
        }

        System.out.println(idx);
    }
}