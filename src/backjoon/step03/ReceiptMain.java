package backjoon.step03;

import java.util.Scanner;

public class ReceiptMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int X = scan.nextInt();
        int N = scan.nextInt();

        for (int i = 0; i < N; i++) {
            int a = scan.nextInt();
            int b = scan.nextInt();

            X -= a * b;
        }

        if(X == 0)
            System.out.println("Yes");
        else
            System.out.println("No");
    }
}
