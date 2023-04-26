package baekjoon.step.string;

import java.util.Scanner;

public class OldTelephoneMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        String[] telelphone = new String[] {"ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ"};
        int total = 0;

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < telelphone.length; j++) {
                for (int k = 0; k < telelphone[j].length(); k++) {
                    if(str.charAt(i) == telelphone[j].charAt(k))
                        total += (j + 3);
                }
            }
        }
        System.out.println(total);
    }
}
