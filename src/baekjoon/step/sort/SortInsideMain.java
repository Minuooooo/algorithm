package baekjoon.step.sort;

import java.util.Scanner;

public class SortInsideMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] counting = new int[10];

        while (N != 0) {
            counting[N % 10]++;
            N /= 10;
        }

        for (int i = 9; i > 0; i--) {
            while(counting[i]-- > 0)
                System.out.print(i);
        }
    }
}
