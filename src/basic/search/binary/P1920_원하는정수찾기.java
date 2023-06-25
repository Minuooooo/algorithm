package basic.search.binary;

import java.util.Arrays;
import java.util.Scanner;

public class P1920_원하는정수찾기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        Arrays.sort(A);
        int M = scanner.nextInt();

        for (int i = 0; i < M; i++) {
            boolean find = false;
            int target = scanner.nextInt();
            int start = 0;
            int end = A.length - 1;

            while (start <= end) {
                int mid_index = (start + end) / 2;
                int mid_value = A[mid_index];

                if (mid_value > target) {
                    end = mid_index - 1;
                } else if (mid_value < target) {
                    start = mid_index + 1;
                } else {
                    find = true;
                    break;
                }
            }

            if(find)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
