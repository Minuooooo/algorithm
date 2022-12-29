package backjoon.step04;

import java.util.Scanner;

public class AvgMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        for (int i = 0; i < testCase; i++) {
            int stuNum = scanner.nextInt();
            int[] stuScore = new int[stuNum];
            double total = 0;
            double count = 0;

            for (int j = 0; j < stuNum; j++) {
                stuScore[j] = scanner.nextInt();
                total += stuScore[j];
            }

            double stuAvg = (total / stuNum);

            for (int j = 0; j < stuNum; j++) {
                if (stuScore[j] > stuAvg) {
                    count++;
                }
            }

            double rate = (count / stuNum) * 100;
            System.out.printf("%.3f%%\n", rate);
        }
    }
}
