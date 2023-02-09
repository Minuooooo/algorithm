package backjoon.step.step07;

import java.util.Scanner;

public class FountainMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int X = scanner.nextInt();
        int a = 1;
        int b = 1;
        int count = 2;
        boolean check = true;

        if (X == 1) {
        } else if (X == 2)
            b = 2;
        else {
            b = 2;
            while (count < X) {
                if (check) {
                    a++;
                    b--;
                    if (b == 0) {
                        b = 1;
                        check = false;
                    }
                } else {
                    a--;
                    b++;
                    if (a == 0) {
                        a = 1;
                        check = true;
                    }
                }
                count++;
            }
        }
        System.out.println(a + "/" + b);
    }
}
