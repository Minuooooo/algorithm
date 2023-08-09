package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178_미로탐색 {

    static int N, M;
    static int[][] map;
    static boolean[][] isVisited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        isVisited = new boolean[N][M];

        for(int i = 0; i < N; i++) {

            String str = br.readLine();

            for(int j = 0; j < M; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        isVisited[0][0] = true;
        bfs(0, 0);

        System.out.println(map[N - 1][M - 1]);
    }

    static void bfs(int x, int y) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});

        while(!queue.isEmpty()) {

            int[] temp = queue.poll();

            for(int i = 0; i < 4; i++) {

                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 1) {
                    queue.offer(new int[]{nx, ny});
                    isVisited[nx][ny] = true;
                    map[nx][ny] = map[temp[0]][temp[1]] + 1;
                }
            }
        }
    }
}