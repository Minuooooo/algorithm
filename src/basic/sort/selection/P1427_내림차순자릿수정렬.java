package basic.sort.selection;

import java.util.Scanner;

public class P1427_내림차순자릿수정렬 {  // Selection sort -> O(n^2)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int[] A = new int[str.length()];

        for (int i = 0; i < str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i + 1));
        }

        // Selection sort
        for (int i = 0; i < str.length(); i++) {
            int max = i;

            for (int j = i + 1; j < str.length(); j++) {
                if(A[j] > A[max])
                    max = j;
            }

            if (A[i] < A[max]) {  // swap
                int temp = A[i];
                A[i] = A[max];
                A[max] = temp;
            }
        }

        for (int i = 0; i < str.length(); i++) {
            System.out.print(A[i]);
        }
    }
}
