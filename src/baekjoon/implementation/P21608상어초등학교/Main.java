package baekjoon.implementation.P21608상어초등학교;

import java.io.*;
import java.util.*;

public class Main {
    private static int N;
    private static int[][] classRoom;
    private static List<List<Integer>> favor = new ArrayList<>();
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        classRoom = new int[N][N];
        for (int i = 0; i <= N * N; i++) {
            favor.add(new ArrayList<>());
        }
        for (int i = 0; i < N * N; i++) {
            String[] input = br.readLine().split(" ");
            int student = Integer.parseInt(input[0]);
            for (int j = 1; j <= 4; j++) {
                favor.get(student).add(Integer.parseInt(input[j]));
            }
            int row = Integer.MAX_VALUE;
            int col = Integer.MAX_VALUE;
            int maxFriend = -1;
            int maxEmpty = -1;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    int nearFriend = 0;
                    int empty = 0;
                    if (classRoom[j][k] != 0)
                        continue;
                    for (int h = 0; h < 4; h++) {
                        int nj = j + dr[h];
                        int nk = k + dc[h];
                        if (nj < 0 || nj >= N || nk < 0 || nk >= N)
                            continue;
                        if (favor.get(student).contains(classRoom[nj][nk]))
                            nearFriend++;
                        if (classRoom[nj][nk] == 0)
                            empty++;
                    }
                    if (nearFriend > maxFriend) {
                        maxFriend = nearFriend;
                        maxEmpty = empty;
                        row = j;
                        col = k;
                    }
                    else if (nearFriend == maxFriend) {
                        if (empty > maxEmpty) {
                            maxEmpty = empty;
                            row = j;
                            col = k;
                        }
                        else if (empty == maxEmpty) {
                            if (j < row) {
                                row = j;
                                col = k;
                            }
                            else if (j == row && k < col)
                                col = k;
                        }
                    }
                }
            }
            classRoom[row][col] = student;
        }
        int score = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int nearFriend = 0;
                for (int k = 0; k < 4; k++) {
                    int ni = i + dr[k];
                    int nj = j + dc[k];
                    if (ni < 0 || ni >= N || nj < 0 || nj >= N)
                        continue;
                    if (favor.get(classRoom[i][j]).contains(classRoom[ni][nj]))
                        nearFriend++;
                }
                if (nearFriend == 0)
                    continue;
                score += (int) Math.pow(10, nearFriend - 1);
            }
        }
        System.out.println(score);
    }
}