package baekjoon.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P1094_막대기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        boolean[] stick = new boolean[65];

        int size = 64;
        stick[size] = true;

        while (true) {

            int sum = 0;
            int count = 0;

            for (int i = 1; i <= 64; i++) {
                if (stick[i]) {
                    sum += i;
                    count++;
                }
            }

            if (sum == X) {
                System.out.println(count);
                break;
            }

            if (sum >= X) {

                stick[size] = false;

                size /= 2;
                stick[size] = true;
            }

            if (sum < X) {
                size /= 2;
                stick[size] = true;
            }
        }
    }
}