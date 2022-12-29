package backjoon.step04;

import java.util.Scanner;

public class ScoreMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] input = new String[scanner.nextInt()];

        for(int i = 0; i < input.length; i++)
            input[i] = scanner.next();

        for (int i = 0; i < input.length; i++) {
            int score = 0;
            int count = 0;

            for (int j = 0; j < input[i].length(); j++) {
                if (input[i].charAt(j) == 'O')
                    count++;
                else
                    count = 0;
                score += count;
            }
            System.out.println(score);
        }
    }
}
