package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2096_내려가기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] score = new int[N][3];

        for (int i = 0; i < N; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 3; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] maxDp = new int[N][3];

        for (int i = 0; i < 3; i++) {
            maxDp[0][i] = score[0][i];
        }

        for (int i = 1; i < N; i++) {

            maxDp[i][0] = Math.max(maxDp[i - 1][0], maxDp[i - 1][1]) + score[i][0];
            maxDp[i][1] = Math.max(maxDp[i - 1][0], Math.max(maxDp[i - 1][1], maxDp[i - 1][2])) + score[i][1];
            maxDp[i][2] = Math.max(maxDp[i - 1][1], maxDp[i - 1][2]) + score[i][2];
        }

        for (int i = 1; i < N; i++) {

            score[i][0] += Math.min(score[i - 1][0], score[i - 1][1]);
            score[i][1] += Math.min(score[i - 1][0], Math.min(score[i - 1][1], score[i - 1][2]));
            score[i][2] += Math.min(score[i - 1][1], score[i - 1][2]);
        }

        int max = maxDp[N - 1][0];
        int min = score[N - 1][0];

        for (int i = 1; i < 3; i++) {
            max = Math.max(max, maxDp[N - 1][i]);
            min = Math.min(min, score[N - 1][i]);
        }

        System.out.println(max + " " + min);
    }
}