package backjoon.step.step07;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class WomanPresidentMain {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            int[] count = new int[n];

            for(int j = 0; j < n; j++)
                count[j] = j + 1;

            if(k == 1)
                System.out.println(n * (n + 1) / 2);
            else {
                for (int j = 0; j < k; j++) {
                    for (int h = 1; h < n; h++) {
                        count[h] += count[h - 1];
                    }
                }
                System.out.println(count[n - 1]);
            }
        }
    }
}
