package baekjoon.graphsearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P7562_나이트의이동 {

    static int I;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, -1, -2, -2, 1, 1, 2, 2};
    static int[] dy = {-2, 2, -1, 1, -2, 2, -1, 1};
    static int startX, startY, destX, destY;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            I = Integer.parseInt(br.readLine());
            map = new int[I][I];
            visited = new boolean[I][I];

            StringTokenizer st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            destX = Integer.parseInt(st.nextToken());
            destY = Integer.parseInt(st.nextToken());

            bfs();

            sb.append(map[destX][destY]).append('\n');
        }

        System.out.println(sb);
    }

    static void bfs() {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {

             int[] now = queue.poll();
             int nowX = now[0];
             int nowY = now[1];

             for (int i = 0; i < 8; i++) {

                 int movedX = nowX + dx[i];
                 int movedY = nowY + dy[i];

                 if (movedX >= 0 && movedX < I && movedY >= 0 && movedY < I && !visited[movedX][movedY]) {

                     queue.offer(new int[] {movedX, movedY});
                     map[movedX][movedY] = map[nowX][nowY] + 1;
                     visited[movedX][movedY] = true;
                 }
             }
        }
    }
}