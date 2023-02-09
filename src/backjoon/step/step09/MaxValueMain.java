package backjoon.step.step09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MaxValueMain {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] array = new int[9][9];
        int max = Integer.MIN_VALUE;
        int row = 0;
        int column = 0;

        for (int i = 0; i < array.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = Integer.parseInt(st.nextToken());
                if(max < array[i][j]) {
                    max = array[i][j];
                    row = (i + 1);
                    column = (j + 1);
                }
            }
        }

        System.out.println(max);
        System.out.println(row + " " + column);
    }
}
