package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P4963_섬의_개수 {

    static int h, w;
    static int[][] map;
    static int[] dx = {-1, 1, -1, -1, 1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1, -1, 1, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;

            map = new int[h][w];

            for (int i = 0; i < h; i++) {

                st = new StringTokenizer(br.readLine());

                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;

            for (int i = 0; i < h; i++) {

                for (int j = 0; j < w; j++) {

                    if (map[i][j] == 1) {

                        dfs(i, j);
                        count++;
                    }
                }
            }

            sb.append(count).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int x, int y) {

        map[x][y] = 0;

        for (int i = 0; i < 8; i++) {

            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= w)
                continue;

            if (map[nextX][nextY] == 1)
                dfs(nextX, nextY);
        }
    }
}