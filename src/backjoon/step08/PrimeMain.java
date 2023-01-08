package backjoon.step08;

import java.io.IOException;
import java.util.Scanner;

public class PrimeMain {

    private static boolean[] prime;

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);

        int M = scanner.nextInt();
        int N = scanner.nextInt();
        prime = new boolean[N + 1];

        getPrime();

        for (int i = M; i <= N; i++) {
            if(prime[i] == false)
                System.out.println(i);
        }
    }

    public static void getPrime() {
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            for(int j = i * i; j < prime.length; j += i)
                prime[j] = true;
        }
    }
}
