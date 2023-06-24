package basic.datastructure.two;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1940_주몽 {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(bufferedReader.readLine());
        int M = Integer.parseInt(bufferedReader.readLine());
        int[] A = new int[N];

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        Arrays.sort(A);

        int count = 0;

        // Two pointer
        int i = 0;  // A[0] -> min
        int j = N - 1;  // A[N - 1] -> max

        while (i < j) {
            if (A[i] + A[j] < M)
                i++;
            else if(A[i] + A[j] > M)
                j--;
            else {
                count++;
                i++;
                j--;
            }
        }
        System.out.println(count);
    }
}
