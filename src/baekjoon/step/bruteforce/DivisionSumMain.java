package baekjoon.step.bruteforce;

import java.util.Scanner;

public class DivisionSumMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int constructor = 1;

        while (true) {
            int sum = constructor;
            int rest = constructor;

            while (rest > 0) {
                sum += rest % 10;
                rest /= 10;
            }

            if(sum == N)
                break;
            else if (constructor == N) {
                constructor = 0;
                break;
            }

            constructor++;
        }

        System.out.println(constructor);
    }
}
