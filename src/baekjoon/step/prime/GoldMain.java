package baekjoon.step.prime;

import java.util.Scanner;

public class GoldMain {

    private static boolean[] prime = new boolean[10001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int T = scanner.nextInt();

        getPrime();

        for (int i = 0; i < T; i++) {
            int n = scanner.nextInt();
            int leftPartition = n / 2;
            int rightPartition = n / 2;

            while (true) {
                if(prime[leftPartition] == false && prime[rightPartition] == false) {
                    System.out.println(leftPartition + " " + rightPartition);
                    break;
                }
                leftPartition--;
                rightPartition++;
            }
        }
    }

    public static void getPrime() {
        prime[0] = true;
        prime[1] = true;

        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if(prime[i])
                continue;

            for (int j = i * i; j < prime.length; j += i) {
                prime[j] = true;
            }
        }
    }
}
