package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P2667_단지번호붙이기 {

    static int[][] map;
    static int N, count;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i = 0; i < N; i++) {

            String exist = br.readLine();

            for(int j = 0; j < N; j++) {
                map[i][j] = exist.charAt(j) - '0';
            }
        }

        List<Integer> countList = new ArrayList<>();
        int type = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {

                count = 0;

                if(map[i][j] == 1) {
                    dfs(i, j);
                    countList.add(count);
                    type++;
                }
            }
        }

        Collections.sort(countList);

        System.out.println(type);
        for(int i : countList) {
            System.out.println(i);
        }
    }
    static void dfs(int x, int y) {

        map[x][y] = 0;
        count++;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < N && map[nx][ny] == 1)
                dfs(nx, ny);
        }
    }
}