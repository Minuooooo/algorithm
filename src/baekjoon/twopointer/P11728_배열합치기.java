package baekjoon.twopointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P11728_배열합치기 {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] A = new int[N];
        int[] B = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        printSortedData(A, B);
        System.out.println(sb);
    }

    private static void printSortedData(int[] arr1, int[] arr2) {

        int arr1Size = arr1.length;
        int arr2Size = arr2.length;

        int index1 = 0;
        int index2 = 0;

        while (index1 < arr1Size && index2 < arr2Size) {

            if (arr1[index1] < arr2[index2])
                sb.append(arr1[index1++]).append(" ");

            else
                sb.append(arr2[index2++]).append(" ");
        }

        if (index1 == arr1Size)
            printRestData(arr2, index2, arr2Size);

        else
            printRestData(arr1, index1, arr1Size);
    }

    private static void printRestData(int[] biggerArr, int start, int end) {

        for (int i = start; i < end; i++) {
            sb.append(biggerArr[i]).append(" ");
        }
    }
}