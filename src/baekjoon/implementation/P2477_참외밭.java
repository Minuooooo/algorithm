package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2477_참외밭 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int[] len = new int[6];
        int maxWidth = 0;
        int maxHeight = 0;
        int maxWidthIndex = -1;
        int maxHeightIndex = -1;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int direction = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());

            if (direction == 1 || direction == 2) {
                if (maxWidth < len[i]) {
                    maxWidth = len[i];
                    maxWidthIndex = i;
                }
            }

            if (direction == 3 || direction == 4) {
                if (maxHeight < len[i]) {
                    maxHeight = len[i];
                    maxHeightIndex = i;
                }
            }
        }

        int totalArea = maxWidth * maxHeight;
        int excludedArea = calculateLength(len, maxWidthIndex) * calculateLength(len, maxHeightIndex);

        System.out.println(K * (totalArea - excludedArea));
    }

    static int calculateLength(int[] len, int index) {
        if (index == 0)
            return Math.abs(len[5] - len[index + 1]);

        else if (index == 5)
            return Math.abs(len[index - 1] - len[0]);

        else
            return Math.abs(len[index - 1] - len[index + 1]);
    }
}