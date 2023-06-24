package basic.datastructure;

import java.util.Scanner;

public class P2018_연속된자연수의합 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int count = 1;  // 자기 자신 카운팅 -> 1

        // Two pointer
        int start_index = 1;
        int end_index = 1;

        int sum = 1;

        while (end_index != N) {
            if (sum == N) {
                count++;
                end_index++;
                sum += end_index;
            } else if (sum > N) {
                sum -= start_index;
                start_index++;
            } else {
                end_index++;
                sum += end_index;
            }
        }

        System.out.println(count);
    }
}
