package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1138_한_줄로_서기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] person = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= N; i++) {

            int left = Integer.parseInt(st.nextToken());

            for (int j = 1; j <= N; j++) {

                if (left == 0) {

                    if (person[j] == 0) {

                        person[j] = i;
                        break;
                    }
                }

                else {

                    if (person[j] == 0)
                        left--;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.print(person[i] + " ");
        }
    }
}