package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P21921_블로그 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        int sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

            if (i < X)
                sum += arr[i];
        }

        int max = sum;
        int count = 1;

        for (int i = X; i < N; i++) {
            sum = sum + arr[i] - arr[i - X];

            if (max == sum)
                count++;

            if (max < sum) {
                max = sum;
                count = 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        if (max == 0)
            sb.append("SAD");
        else
            sb.append(max).append("\n").append(count);

        System.out.println(sb);
    }
}