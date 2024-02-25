package baekjoon.graphsearch.P21736헌내기는친구가필요해;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    private static int N, M;
    private static char[][] campus;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        campus = new char[N][M];
        visited = new boolean[N][M];
        int row = 0;
        int col = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                campus[i][j] = str.charAt(j);
                if (campus[i][j] == 'I') {
                    row = i;
                    col = j;
                }
            }
        }
        bfs(row, col);
    }

    private static void bfs(int startRow, int startCol) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {startRow, startCol});
        visited[startRow][startCol] = true;
        int friend = 0;
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextRow = now[0] + dr[i];
                int nextCol = now[1] + dc[i];
                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= M)
                    continue;
                if (visited[nextRow][nextCol])
                    continue;
                if (campus[nextRow][nextCol] == 'X')
                    continue;
                visited[nextRow][nextCol] = true;
                queue.offer(new int[] {nextRow, nextCol});
                if (campus[nextRow][nextCol] == 'P')
                    friend++;
            }
        }
        if (friend == 0) {
            System.out.println("TT");
            return;
        }
        System.out.println(friend);
    }
}