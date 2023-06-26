package basic.greedy;

import java.util.Scanner;

public class P11047_동전개수의최솟값 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int A[] = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        // Greedy algorithm -> 최대한 큰 동전 먼저 사용
        int count = 0;
        for (int i = N - 1; i >= 0; i--) {
            if (A[i] <= K) {
                count += (K / A[i]);
                K %= A[i];
            }
        }

        System.out.println(count);
    }
}
