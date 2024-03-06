package baekjoon.practice.P2531회전초밥;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int d = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);
        int c = Integer.parseInt(input[3]);
        int[] belt = new int[N];
        int[] choice = new int[3_001];
        for (int i = 0; i < N; i++) {
            belt[i] = Integer.parseInt(br.readLine());
        }
        int start = 0;
        int end = 0;
        int count = 0;
        int answer = 0;
        while (start < N) {
            while (end - start < k) {
                if (choice[belt[end % N]] == 0) {
                    count++;
                }
                choice[belt[end % N]]++;
                end++;
            }
            if (choice[c] == 0)
                answer = Math.max(answer, count + 1);
            else
                answer = Math.max(answer, count);
            if (choice[belt[start]] == 1)
                count--;
            choice[belt[start]]--;
            start++;
        }
        System.out.println(answer);
    }
}