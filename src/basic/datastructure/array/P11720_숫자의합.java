package basic.datastructure.array;

import java.util.Scanner;

public class P11720_숫자의합 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String sNum = scanner.next();
        char[] cNum = sNum.toCharArray();  // 문자열 -> character array
        int sum = 0;

        for (char c : cNum) {
            sum += c - '0';  // char -> int
        }
        System.out.println(sum);
    }
}
