package baekjoon.practice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P2564_경비원 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] len = br.readLine().split(" ");
        int width = Integer.parseInt(len[0]);
        int height = Integer.parseInt(len[1]);
        int store = Integer.parseInt(br.readLine());
        int[][] position = new int[store][2];
        StringTokenizer st;

        for (int i = 0; i < store; i++) {
            st = new StringTokenizer(br.readLine());
            position[i][0] = Integer.parseInt(st.nextToken());
            position[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] d = new int[1][2];
        String[] dPos = br.readLine().split(" ");
        d[0][0] = Integer.parseInt(dPos[0]);
        d[0][1] = Integer.parseInt(dPos[1]);

        int distance = 0;

        for (int i = 0; i < store; i++) {
            if (d[0][0] == 1) {
                switch (position[i][0]) {
                    case 1:
                        distance += Math.abs(d[0][1] - position[i][1]);
                        break;

                    case 2:
                        distance += Math.min(d[0][1] + position[i][1], (width - d[0][1]) + (width - position[i][1])) + height;
                        break;

                    case 3:
                        distance += (d[0][1] + position[i][1]);
                        break;

                    case 4:
                        distance += ((width - d[0][1]) + position[i][1]);
                }
            }

            if (d[0][0] == 2) {
                switch (position[i][0]) {
                    case 1:
                        distance += Math.min(d[0][1] + position[i][1], (width - d[0][1]) + (width - position[i][1])) + height;
                        break;

                    case 2:
                        distance += Math.abs(d[0][1] - position[i][1]);
                        break;

                    case 3:
                        distance += (d[0][1] + (height - position[i][1]));
                        break;

                    case 4:
                        distance += ((width - d[0][1]) + (height - position[i][1]));
                }
            }

            if (d[0][0] == 3) {
                switch (position[i][0]) {
                    case 1:
                        distance += (d[0][1] + position[i][1]);
                        break;

                    case 2:
                        distance += ((height - d[0][1]) + position[i][1]);
                        break;

                    case 3:
                        distance += Math.abs(d[0][1] - position[i][1]);
                        break;

                    case 4:
                        distance += Math.min(d[0][1] + position[i][1], (height - d[0][1]) + (height - position[i][1])) + width;
                }
            }

            if (d[0][0] == 4) {
                switch (position[i][0]) {
                    case 1:
                        distance += d[0][1] + (width - position[i][1]);
                        break;

                    case 2:
                        distance += ((height - d[0][1]) + (width - position[i][1]));
                        break;

                    case 3:
                        distance += Math.min(d[0][1] + position[i][1], (height - d[0][1]) + (height - position[i][1])) + width;
                        break;

                    case 4:
                        distance += Math.abs(d[0][1] - position[i][1]);
                }
            }
        }

        System.out.println(distance);
    }
}