package baekjoon.implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3085_사탕게임 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        char[][] map = new char[N][N];
        int max = 1;

        for (int i = 0; i < N; i++) {

            String str = br.readLine();

            for (int j = 0; j < N; j++) {

                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N - 1; j++) {

                char temp = map[i][j];
                map[i][j] = map[i][j + 1];
                map[i][j + 1] = temp;

                for (int k = 0; k < N; k++) {

                    int count = 1;

                    for (int h = 0; h < N - 1; h++) {

                        if (map[k][h] == map[k][h + 1]) {
                            count++;
                            max = Math.max(max, count);
                        }

                        else
                            count = 1;
                    }
                }

                for (int k = 0; k < N; k++) {

                    int count = 1;

                    for (int h = 0; h < N - 1; h++) {

                        if (map[h][k] == map[h + 1][k]) {
                            count++;
                            max = Math.max(max, count);
                        }

                        else
                            count = 1;
                    }
                }

                temp = map[i][j];
                map[i][j] = map[i][j + 1];
                map[i][j + 1] = temp;
            }
        }

        for (int i = 0; i < N; i++) {

            for (int j = 0; j < N - 1; j++) {

                char temp = map[j][i];
                map[j][i] = map[j + 1][i];
                map[j + 1][i] = temp;

                for (int k = 0; k < N; k++) {

                    int count = 1;

                    for (int h = 0; h < N - 1; h++) {

                        if (map[k][h] == map[k][h + 1]) {
                            count++;
                            max = Math.max(max, count);
                        }

                        else
                            count = 1;
                    }
                }

                for (int k = 0; k < N; k++) {

                    int count = 1;

                    for (int h = 0; h < N - 1; h++) {

                        if (map[h][k] == map[h + 1][k]) {
                            count++;
                            max = Math.max(max, count);
                        }

                        else
                            count = 1;
                    }
                }

                temp = map[j][i];
                map[j][i] = map[j + 1][i];
                map[j + 1][i] = temp;
            }
        }

        System.out.println(max);
    }
}