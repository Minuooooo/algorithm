package basic.combination;

import java.util.Scanner;

public class P11050_이항계수 {

    static int N, K;
    static int[][] D;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextInt();
        K = scanner.nextInt();
        D = new int[N + 1][N + 1];

        // 초기화
        for (int i = 0; i <= N; i++) {
            D[i][i] = 1;
            D[i][0] = 1;
            D[i][1] = i;
        }

        // 점화식으로 배열 완성
        for (int i = 3; i <= N; i++) {
            for (int j = 2; j < i; j++) {
                D[i][j] = D[i - 1][j] + D[i - 1][j - 1];
            }
        }
        System.out.println(D[N][K]);
    }
}
