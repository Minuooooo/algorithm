package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P18111_마인크래프트 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] ground = new int[N][M];
        int minHeight = 256;
        int maxHeight = 0;

        for (int i = 0; i < N; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                minHeight = Math.min(minHeight, ground[i][j]);
                maxHeight = Math.max(maxHeight, ground[i][j]);
            }
        }

        int resultSecond = Integer.MAX_VALUE;
        int resultHeight = 0;

        for (int i = minHeight; i <= maxHeight; i++) {

            int second = 0;
            int block = B;

            for (int j = 0; j < N; j++) {

                for (int k = 0; k < M; k++) {

                    if (i > ground[j][k]) {
                        second += (i - ground[j][k]);
                        block -= (i - ground[j][k]);
                    }

                     else if (i < ground[j][k]) {
                         second += (ground[j][k] - i) * 2;
                         block += (ground[j][k] - i);
                    }
                }
            }

            if (block < 0)
                continue;

            if (resultSecond >= second) {
                resultSecond = second;
                resultHeight = Math.max(resultHeight, i);
            }
        }

        System.out.println(resultSecond + " " + resultHeight);
    }
}