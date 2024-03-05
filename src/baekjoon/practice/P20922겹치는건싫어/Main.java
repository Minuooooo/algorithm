package baekjoon.practice.P20922겹치는건싫어;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int K = Integer.parseInt(input[1]);
        int[] sequence = new int[N];
        int[] frequency = new int[100_001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(st.nextToken());
        }
        int start = 0;
        int end = 0;
        int answer = 0;
        while (end < N) {
            while (end < N && frequency[sequence[end]] + 1 <= K) {
                frequency[sequence[end]]++;
                end++;
            }
            answer = Math.max(answer, end - start);
            frequency[sequence[start]]--;
            start++;
        }
        System.out.println(answer);
    }
}