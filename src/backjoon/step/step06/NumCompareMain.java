package backjoon.step.step06;

import java.util.Scanner;

public class NumCompareMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.next();
        String str2 = scanner.next();

        int num1 = (str1.charAt(0) - '0') + 10 * (str1.charAt(1) - '0') + 100 * (str1.charAt(2) - '0');
        int num2 = (str2.charAt(0) - '0') + 10 * (str2.charAt(1) - '0') + 100 * (str2.charAt(2) - '0');
        int max = 0;

        if(num1 > num2)
            max = num1;
        else
            max = num2;

        System.out.println(max);
    }
}
