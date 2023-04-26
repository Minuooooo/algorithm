package baekjoon.step.string;

import java.util.Scanner;

public class AlphabetFrequencyMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String word = scanner.next();
        word = word.toLowerCase();
        int[] frequency = new int[26];
        int max = 0;
        int maxAlphabet = 0;
        int ch = 0;

        for (int i = 0; i < word.length(); i++)
            frequency[word.charAt(i) - 'a']++;

        for (int i = 0; i < 26; i++) {
            if(frequency[i] > max) {
                max = frequency[i];
                maxAlphabet = i;
                ch = i + 'A';
            }
        }

        for (int i = 0; i < 26; i++) {
            if((i != maxAlphabet) && (frequency[i] == max))
                ch = '?';
        }

        System.out.println((char)ch);
    }
}
