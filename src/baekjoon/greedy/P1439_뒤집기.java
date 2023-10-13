package baekjoon.greedy;

import java.util.Scanner;

public class P1439_뒤집기 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String S = scanner.next();

        String[] strArr = S.split("");
        int zero = 0;
        int one = 0;
        String first = strArr[0];

        if (first.equals("0"))
            zero++;

        else
            one++;

        for (int i = 1; i < strArr.length; i++) {

            if (!strArr[i - 1].equals(strArr[i])) {

                if (strArr[i].equals("0"))
                    zero++;

                else
                    one++;
            }
        }

        System.out.println(Math.min(zero, one));
    }
}