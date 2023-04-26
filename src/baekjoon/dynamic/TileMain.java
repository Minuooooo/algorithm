package baekjoon.dynamic;

import java.util.Scanner;

public class TileMain {

    static int[] arr = new int[1000001];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();

        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;

        //-1로 초기화 (15746로 나눈 나머지가 0이 될 수 있기 때문)
        for (int i = 3; i < arr.length; i++) {
            arr[i] = -1;
        }

        System.out.println(tile(N));
    }

    public static int tile(int N) {
        if (arr[N] == -1) {
            arr[N] = (tile(N - 2) + tile(N - 1)) % 15746;
        }

        return arr[N];
    }
}
