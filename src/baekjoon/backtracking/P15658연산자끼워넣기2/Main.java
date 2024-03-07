package baekjoon.backtracking.P15658연산자끼워넣기2;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[] numArr;
    private static int[] op = new int[4];  // +, -, *, /
    private static int min = Integer.MAX_VALUE;
    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        numArr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        getMinAndMaxValue(0, numArr[0]);
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(min);
        System.out.println(sb);
    }

    private static void getMinAndMaxValue(int depth, int value) {
        if (depth == N - 1) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] == 0)
                continue;
            op[i]--;
            int temp = value;
            switch (i) {
                case 0:
                    temp += numArr[depth + 1];
                    break;
                case 1:
                    temp -= numArr[depth + 1];
                    break;
                case 2:
                    temp *= numArr[depth + 1];
                    break;
                case 3:
                    if (temp < 0) {
                        temp = Math.abs(value) / numArr[depth + 1] * (-1);
                    }
                    else
                        temp /= numArr[depth + 1];
            }
            getMinAndMaxValue(depth + 1, temp);
            op[i]++;
        }
    }
}