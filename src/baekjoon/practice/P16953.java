package baekjoon.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P16953 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        String A = input[0];
        String B = input[1];
        int count = 0;
        while (Integer.parseInt(B) > Integer.parseInt(A)) {
            if (B.charAt(B.length() - 1) == '1') {
                B = B.substring(0, B.length() - 1);
                count++;
                continue;
            }
            if (Integer.parseInt(B) % 2 == 0) {
                B = Integer.toString(Integer.parseInt(B) / 2);
                count++;
            }
            else
                break;
        }
        if (Integer.parseInt(A) == Integer.parseInt(B))
            System.out.println(count + 1);
        else
            System.out.println(-1);
    }
}