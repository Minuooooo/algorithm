package backjoon.step03;

import java.util.Scanner;

public class CycleMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int num = scan.nextInt();
        int cycle = num;
        int count = 0;

        while (true) {
            count++;

            int temp = (cycle / 10) + (cycle % 10);
            cycle = (cycle % 10) * 10 + (temp % 10);

            if (cycle == num) {
                System.out.println(count);
                break;
            }
        }
    }
}
