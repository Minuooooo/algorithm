package baekjoon.practice.P1339단어수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] alphabet = new int[26];
        for (int i = 0; i < N; i++) {
            String word = br.readLine();
            for (int j = 0; j < word.length(); j++) {
                alphabet[word.charAt(j) - 'A'] += (int) Math.pow(10, word.length() - 1 - j);
            }
        }
        Arrays.sort(alphabet);
        int index = alphabet.length - 1;
        int num = 9;
        int result = 0;
        while (alphabet[index] != 0) {
            result += (alphabet[index] * num);
            num--;
            index--;
        }
        System.out.println(result);
    }
}