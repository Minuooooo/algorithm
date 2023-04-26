package baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadovanMain {

    private static Long[] arr = new Long[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        arr[0] = 0L;
        arr[1] = 1L;
        arr[2] = 1L;
        arr[3] = 1L;

        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            sb.append(padovan(N)).append('\n');
        }
        System.out.println(sb);
    }

    public static long padovan(int N) {
        if (arr[N] == null) {
            arr[N] = padovan(N - 2) + padovan(N - 3);
        }
        return arr[N];
    }
}
