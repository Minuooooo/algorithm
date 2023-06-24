package basic.datastructure;

import java.util.Scanner;

public class P11720 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        String sNum = scanner.next();
        char[] cNum = sNum.toCharArray();
        int sum = 0;

        for (char c : cNum) {
            sum += c - '0';
        }
        System.out.println(sum);
    }
}
