package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2210_숫자판점프 {

    static String[][] map = new String[5][5];
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static Set<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for (int i = 0; i < 5; i++) {

            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < 5; j++) {
                map[i][j] = st.nextToken();
            }
        }

        String str = "";

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, str);
            }
        }

        System.out.println(set.size());
    }

    static void dfs(int nowX, int nowY, int depth, String str) {

        if (depth == 6) {
            set.add(str);
            return;
        }

        for (int i = 0; i < 4; i++) {

            int nextX = nowX + dx[i];
            int nextY = nowY + dy[i];

            if (nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5)
                dfs(nextX, nextY, depth + 1, str + map[nextX][nextY]);
        }
    }
}