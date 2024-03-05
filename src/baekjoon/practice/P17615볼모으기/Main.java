package baekjoon.practice.P17615볼모으기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String ball = br.readLine();
        int answer = Integer.MAX_VALUE;
        boolean swap = false;
        int count = 0;
        int len = ball.length();
        for (int i = 0; i < len; i++) {
            if (swap && ball.charAt(i) == 'R') {
                count++;
            }
            if (ball.charAt(i) == 'B')
                swap = true;
        }
        answer = count;
        swap = false;
        count = 0;
        for (int i = 0; i < len; i++) {
            if (swap && ball.charAt(i) == 'B') {
                count++;
            }
            if (ball.charAt(i) == 'R')
                swap = true;
        }
        answer = Math.min(answer, count);
        swap = false;
        count = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (swap && ball.charAt(i) == 'R') {
                count++;
            }
            if (ball.charAt(i) == 'B')
                swap = true;
        }
        answer = Math.min(answer, count);
        swap = false;
        count = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (swap && ball.charAt(i) == 'B') {
                count++;
            }
            if (ball.charAt(i) == 'R')
                swap = true;
        }
        answer = Math.min(answer, count);
        System.out.println(answer);
    }
}