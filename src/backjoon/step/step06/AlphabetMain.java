package backjoon.step.step06;

import java.util.Scanner;

public class AlphabetMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String str = scanner.next();
        int[] A = new int[('z' - 'a') + 1];

        for(int i = 0; i < A.length; i++)
            A[i] = -1;

        for (int i = 0; i < str.length(); i++) {
            if(A[str.charAt(i) - 'a'] == -1)
                A[str.charAt(i) - 'a'] = i;
        }

        for(int i = 0; i < A.length; i++)
            System.out.print(A[i] + " ");
    }
}
