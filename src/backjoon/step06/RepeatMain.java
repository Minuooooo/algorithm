package backjoon.step06;

import java.util.Scanner;

public class RepeatMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner((System.in));

        int testCase = scanner.nextInt();


        for (int i = 0; i < testCase; i++) {
            int repeat = scanner.nextInt();
            String str = scanner.next();
            String print = "";

            for (int j = 0; j < str.length(); j++) {
                for (int k = 0; k < repeat; k++) {
                    print += str.charAt(j);
                }
            }
            System.out.println(print);
        }
    }
}
