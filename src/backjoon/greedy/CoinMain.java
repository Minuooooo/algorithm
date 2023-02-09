package backjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class CoinMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Integer[] value = new Integer[N];

        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(value, Collections.reverseOrder());
        int count = 0;
        int i = 0;

        while (K > 0) {
            if (K >= value[i]) {
                K -= value[i];
                count++;
            } else {
                i++;
            }
        }

        System.out.println(count);
    }
}
