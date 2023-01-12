package backjoon.step11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeSortMain {

    private static int[] temp;
    private static int count = 0;
    private static int K = 0;

    public static void mergeSort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int i = low;
        int j = mid + 1;
        int h = 0;

        while (i <= mid && j <= high) {
            if(arr[i] <= arr[j])
                temp[h++] = arr[i++];
            else
                temp[h++] = arr[j++];
        }

        while (i <= mid) {
            temp[h++] = arr[i++];
        }

        while(j <= high) {
            temp[h++] = arr[j++];
        }

        i = low;
        h = 0;

        while (i <= high) {
            count++;
            if(count == K) {
                System.out.println(temp[h]);
                System.exit(0);
            }
            arr[i++] = temp[h++];
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        temp = new int[N];
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        mergeSort(arr, 0, N - 1);

        System.out.println(-1);
    }
}
