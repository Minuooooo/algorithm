package backjoon.step05;

import java.util.Scanner;

public class SequenceMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        System.out.println(sequence(N));
    }

    public static int sequence(int N) {
        if(N < 100)
            return N;
        else {
            int count = 99;

            for (int i = 100; i <= N; i++) {
                int hun = (i / 100);
                int ten = ((i / 10) % 10);
                int one = (i % 10);

                if ((hun - ten) == (ten - one))
                    count++;
            }
            return count;
        }
    }
}
