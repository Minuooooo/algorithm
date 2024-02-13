package baekjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2417_정수_제곱근 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        long left = 0;
        long right = n;
        long result = n;

        while (left <= right) {

            long mid = (left + right) / 2;

            if (Math.pow(mid, 2) >= n) {

                result = mid;
                right = mid - 1;
            }

            else {

                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}