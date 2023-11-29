package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1748_수_이어_쓰기_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int divider = 10;
        int num = 1;
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (i % divider == 0) {
                num++;
                divider *= 10;
            }

            count += num;
        }

        System.out.println(count);
    }
}