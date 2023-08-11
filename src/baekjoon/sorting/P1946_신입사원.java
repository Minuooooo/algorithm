package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1946_신입사원 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            int[] secondRank = new int[N + 1];

            for(int j = 0; j < N; j++) {

                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());
                secondRank[first] = second;
            }

            int pass = 1;
            int min = secondRank[1];

            for(int j = 2; j < N + 1; j++) {

                if(secondRank[j] < min) {
                    pass++;
                    min = secondRank[j];
                }
            }

            sb.append(pass).append('\n');
        }

        System.out.println(sb);
    }
}