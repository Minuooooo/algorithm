package backjoon.step04;

import java.util.Scanner;

public class RestMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] rest = new int[10];
        int count = 1;

        for (int i = 0; i < 10; i++) {
            rest[i] = scanner.nextInt() % 42;
        }
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {
                if (rest[i] != rest[j]) {
                    if (j == 9) {
                        count++;
                    }
                } else {
                    break;
                }
            }
        }
        System.out.println(count);
    }
}
