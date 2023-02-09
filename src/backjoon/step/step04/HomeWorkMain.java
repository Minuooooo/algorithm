package backjoon.step.step04;

import java.util.Scanner;

public class HomeWorkMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] stuNum = new int[31];
        stuNum[0] = 0;

        for (int i = 0; i < 28; i++) {
            stuNum[scanner.nextInt()] = 1;
        }
        for (int i = 1; i <= 30; i++) {
            if (stuNum[i] == 0) {
                System.out.println(i);
            }
        }
    }
}
