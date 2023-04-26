package baekjoon.step.recursive;

import java.util.Scanner;

public class PalindromeMain {

    private static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            count = 0;
            String str = scanner.next();
            sb.append(isPalindrome(str)).append(" ").append(count).append("\n");
        }

        scanner.close();
        System.out.println(sb);
    }

    public static int recursion(String s, int l, int r) {

        count++;

        if(l >= r)
            return 1;
        else if (s.charAt(l) != s.charAt(r))
            return 0;
        else
            return recursion(s, l + 1, r - 1);
    }

    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }
}
