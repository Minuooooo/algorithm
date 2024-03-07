package baekjoon.implementation.P2503숫자야구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int N;
    private static String[] input;
    private static boolean[] visited = new boolean[10];
    private static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        input = new String[N];
        for (int i = 0; i < N; i++) {
            input[i] = br.readLine();
        }
        StringBuilder sb = new StringBuilder();
        getCount(0, sb);
        System.out.println(answer);
    }

    private static void getCount(int depth, StringBuilder sb) {
        if (depth == 3) {
            boolean check = true;
            for (int i = 0; i < N; i++) {
                String[] str = input[i].split(" ");
                int strike = 0;
                int ball = 0;
                for (int j = 0; j < 3; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (sb.charAt(k) == str[0].charAt(j)) {
                            if (k == j)
                                strike++;
                            else
                                ball++;
                        }
                    }
                }
                if (strike != Integer.parseInt(str[1]) || ball != Integer.parseInt(str[2])) {
                    check = false;
                    break;
                }
            }
            if (check)
                answer++;
            return;
        }
        for (int i = 1; i <= 9; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            sb.append(i);
            getCount(depth + 1, sb);
            visited[i] = false;
            sb.delete(depth, depth + 1);
        }
    }
}