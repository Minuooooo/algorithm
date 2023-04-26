package baekjoon.step.sort;

import java.util.Scanner;

public class StatisticsMain {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        int[] arr = new int[8001];
        int sum = 0;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            int value = scanner.nextInt();
            sum += value;
            arr[value + 4000]++;

            if(max < value)
                max = value;
            if(min > value)
                min = value;
        }

        int medianCount = 0;
        int median = 10000;
        int maxFrequency = 0;
        int frequencyValue = 10000;
        boolean frequencyCheck = false;

        for (int i = min + 4000; i <= max + 4000; i++) {
            if(arr[i] > 0) {
                if (medianCount < (N + 1) / 2) {
                    medianCount += arr[i];
                    median = i - 4000;
                }

                if (maxFrequency < arr[i]) {
                    maxFrequency = arr[i];
                    frequencyValue = i - 4000;
                    frequencyCheck = true;
                } else if (arr[i] == maxFrequency && frequencyCheck == true) {
                    frequencyValue = i - 4000;
                    frequencyCheck = false;
                }
            }
        }

        System.out.println((int)Math.round((double)sum / N));
        System.out.println(median);
        System.out.println(frequencyValue);
        System.out.println(max - min);
    }
}
