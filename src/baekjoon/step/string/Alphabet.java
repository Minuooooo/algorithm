package baekjoon.step.string;

import java.util.Arrays;
import java.util.Scanner;

public class Alphabet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String S = scanner.next();
        int[] location = new int[('z' - 'a') + 1];

        Arrays.fill(location, -1);
        for (int i = 0; i < S.length(); i++) {
            if(location[S.charAt(i) - 'a'] == -1)
                location[S.charAt(i) - 'a'] = i;
        }

        for (int i : location) {
            System.out.print(i + " ");
        }
    }
}
