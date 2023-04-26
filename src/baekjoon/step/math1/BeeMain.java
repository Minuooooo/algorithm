package baekjoon.step.math1;

import java.util.Scanner;

public class BeeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();
        int count = 1;
        int end = 1;

        while(end < num) {
            end += (6 * count);
            count++;
        }

        System.out.println(count);
    }
}
