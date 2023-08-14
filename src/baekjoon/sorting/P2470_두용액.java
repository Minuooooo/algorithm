package baekjoon.sorting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P2470_두용액 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] squid = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            squid[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(squid);

        int i = 0;
        int j = squid.length - 1;

        int gap = Integer.MAX_VALUE;
        int ans1 = 0;
        int ans2 = 0;

        while(i < j) {

            int sum = squid[i] + squid[j];
            int temp = Math.abs(sum);

            if (temp < gap) {
                gap = temp;
                ans1 = squid[i];
                ans2 = squid[j];
            }

            if (sum > 0)
                j--;
            else
                i++;
        }

        System.out.println(ans1 + " " + ans2);
    }
}