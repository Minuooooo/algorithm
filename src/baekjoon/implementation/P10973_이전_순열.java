package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P10973_이전_순열 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] seq = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        if (prePermutation(seq)) {
            for (int value : seq) {
                System.out.print(value + " ");
            }
        }

        else
            System.out.println(-1);
    }

    static boolean prePermutation(int[] arr) {

        int i = arr.length - 1;

        while (i > 0 && arr[i - 1] < arr[i]) {
            i--;
        }

        if (i == 0)
            return false;

        int j = arr.length - 1;

        while (arr[i - 1] < arr[j]) {
            j--;
        }

        swap(arr, i - 1, j);

        j = arr.length - 1;

        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }

        return true;
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}