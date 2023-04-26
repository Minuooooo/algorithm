package baekjoon.step.deep1;

import java.util.Scanner;

public class MultiplyMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a = scan.nextInt();
        int b = scan.nextInt();

        int total = a * b;

        while(b > 0) {
            int mul = b % 10;
            b /= 10;

            System.out.println(a * mul);
        }
        System.out.println(total);
    }
}
