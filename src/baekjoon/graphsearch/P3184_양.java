package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P3184_양 {

    private static int R, C;
    private static char[][] map;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    private static int curWolf, curSheep;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        map = new char[R][C];

        for (int i = 0; i < R; i++) {

            String garden = br.readLine();

            for (int j = 0; j < garden.length(); j++) {
                map[i][j] = garden.charAt(j);
            }
        }

        int survivedWolf = 0;
        int survivedSheep = 0;

        for (int i = 0; i < R; i++) {

            for (int j = 0; j < C; j++) {

                if (map[i][j] != '#' || map[i][j] == 'x') {

                    curWolf = 0;
                    curSheep = 0;

                    dfs(i, j);

                    if (curWolf >= curSheep)
                        survivedWolf += curWolf;

                    else
                        survivedSheep += curSheep;
                }
            }
        }

        System.out.println(survivedSheep + " " + survivedWolf);
    }

    private static void dfs(int x, int y) {

        if (map[x][y] == 'v')
            curWolf++;

        if (map[x][y] == 'o')
            curSheep++;

        map[x][y] = 'x';

        for (int i = 0; i < 4; i++) {

            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C)
                continue;

            if (map[nextX][nextY] == '#' || map[nextX][nextY] == 'x')
                continue;

            dfs(nextX, nextY);
        }
    }
}