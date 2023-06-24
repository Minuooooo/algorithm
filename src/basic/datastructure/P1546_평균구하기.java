package basic.datastructure;

import java.util.Scanner;

public class P1546_평균구하기 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        long sum = 0;
        long max = 0;

        for (int i = 0; i < N; i++) {
            int temp = scanner.nextInt();
            if (temp > max)  // 최댓값 구하기
                max = temp;
            sum += temp;  // 총합 구하기
        }

        System.out.println(sum * 100.0 / max / N);  // 100.0 -> double type 변환
    }
}
