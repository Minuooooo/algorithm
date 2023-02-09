package backjoon.step.step10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class WordSortMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        String[] word = new String[N];

        scanner.nextLine();

        for (int i = 0; i < N; i++) {
            word[i] = scanner.nextLine();
        }

        Arrays.sort(word, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length())
                    return s1.compareTo(s2);
                else
                    return s1.length() - s2.length();
            }
        });

        System.out.println(word[0]);

        for (int i = 1; i < N; i++) {
            if(!word[i].equals(word[i - 1]))
                System.out.println(word[i]);
        }
    }
}
