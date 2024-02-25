package baekjoon.graphsearch.P16234인구이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int N, L, R;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dr = {-1, 1, 0, 0};
    private static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        L = Integer.parseInt(input[1]);
        R = Integer.parseInt(input[2]);
        map = new int[N][N];
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int result = 0;
        while (true) {
            visited = new boolean[N][N];
            boolean hasUnion = false;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        if (bfs(i, j))
                            hasUnion = true;
                    }
                }
            }
            if (!hasUnion)
                break;
            result++;
        }
        System.out.println(result);
    }

    private static boolean bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> list = new ArrayList<>();
        queue.offer(new int[] {row, col});
        visited[row][col] = true;
        list.add(new int[] {row, col});
        int sum = map[row][col];
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowRow = now[0];
            int nowCol = now[1];
            for (int i = 0; i < 4; i++) {
                int nextRow = nowRow + dr[i];
                int nextCol = nowCol + dc[i];
                if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N)
                    continue;
                if (visited[nextRow][nextCol])
                    continue;
                if (Math.abs(map[nowRow][nowCol] - map[nextRow][nextCol]) < L || Math.abs(map[nowRow][nowCol] - map[nextRow][nextCol]) > R)
                    continue;
                visited[nextRow][nextCol] = true;
                queue.offer(new int[] {nextRow, nextCol});
                sum += map[nextRow][nextCol];
                list.add(new int[] {nextRow, nextCol});
            }
        }
        if (list.size() == 1)
            return false;
        int average = sum / list.size();
        for (int[] now : list) {
            map[now[0]][now[1]] = average;
        }
        return true;
    }
}