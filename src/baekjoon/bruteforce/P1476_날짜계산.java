package baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P1476_날짜계산 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int E = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        if (E == 15)
            E = 0;

        if (S == 28)
            S = 0;

        if (M == 19)
            M = 0;

        long year = 1;

        while (true) {

            if (year % 15 == E) {
                if (year % 28 == S) {
                    if (year % 19 == M)
                        break;
                }
            }

            year++;
        }

        System.out.println(year);
    }
}