package baekjoon.implementation.P14891톱니바퀴;

import java.io.*;
import java.util.*;

public class Main {
    private static int[][] statusArr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        statusArr = new int[5][8];
        for (int i = 1; i <= 4; i++) {
            String statusInput = br.readLine();
            for (int j = 0; j < 8; j++) {
                statusArr[i][j] = statusInput.charAt(j) - '0';
            }
        }
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int target = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            int[] directionArr = new int[5];
            directionArr[target] = direction;
            for (int j = target; j > 1; j--) {
                if (statusArr[j][6] != statusArr[j - 1][2]) {
                    directionArr[j - 1] = directionArr[j] * (-1);
                }
                else
                    break;
            }
            for (int j = target; j < 4; j++) {
                if (statusArr[j][2] != statusArr[j + 1][6]) {
                    directionArr[j + 1] = directionArr[j] * (-1);
                }
                else
                    break;
            }
            for (int j = 1; j <= 4; j++) {
                if (directionArr[j] == -1)
                    moveReverse(j);
                else if (directionArr[j] == 1)
                    move(j);
            }
        }
        int totalScore = 0;
        for (int i = 1; i <= 4; i++) {
            if (statusArr[i][0] == 1) {
                totalScore += (int) Math.pow(2, i - 1);
            }
        }
        System.out.println(totalScore);
    }

    private static void move(int target) {
        int temp = statusArr[target][7];
        for (int i = 7; i >= 1; i--) {
            statusArr[target][i] = statusArr[target][i - 1];
        }
        statusArr[target][0] = temp;
    }

    private static void moveReverse(int target) {
        int temp = statusArr[target][0];
        for (int i = 1; i <= 7; i++) {
            statusArr[target][i - 1] = statusArr[target][i];
        }
        statusArr[target][7] = temp;
    }
}