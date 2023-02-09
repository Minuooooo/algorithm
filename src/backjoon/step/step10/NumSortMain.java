package backjoon.step.step10;

import java.util.Scanner;

public class NumSortMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        boolean[] arr = new boolean[2001];

        for(int i = 0; i < N; i++)
            arr[scanner.nextInt() + 1000] = true;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i])
                System.out.println(i - 1000);
        }
    }

    public static void countingSort(int[] arr) { //빈도 수를 이용한 카운팅 정렬(배열에 중복되는 수가 있을 때)
        int[] counting = new int[6]; //1 ~ 30 숫자 정렬
        int[] result = new int[arr.length];

        for (int i = 0; i < arr.length; i++)
            counting[arr[i]]++;

        for(int i = 1; i < counting.length; i++)
            counting[i] += counting[i - 1];

        for (int i = arr.length - 1; i >= 0; i--) {
            int value = arr[i];
            counting[value]--;
            result[counting[value]] = value;
        }

        for(int i = 0; i < result.length; i++)
            System.out.println(result[i]);
    }
}
