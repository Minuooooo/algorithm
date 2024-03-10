package programmers.level2.무인도여행;

import java.util.*;

public class Solution {
    private int n, m;
    private char[][] map;
    private boolean[][] visited;
    private List<Integer> day = new ArrayList<>();
    private int[] dr = {-1, 1, 0, 0};
    private int[] dc = {0, 0, -1, 1};

    public int[] solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        map = new char[n][m];
        visited = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            String str = maps[i];
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j])
                    continue;
                if (map[i][j] == 'X')
                    continue;
                searchIsland(i, j);
            }
        }
        if (day.isEmpty())
            return new int[] {-1};
        else {
            int[] answer = new int[day.size()];
            for (int i = 0; i < answer.length; i++) {
                answer[i] = day.get(i);
            }
            Arrays.sort(answer);
            return answer;
        }
    }

    private void searchIsland(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {row, col});
        visited[row][col] = true;
        int total = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            total += (map[cur[0]][cur[1]] - '0');
            for (int i = 0; i < 4; i++) {
                int nr = cur[0] + dr[i];
                int nc = cur[1] + dc[i];
                if (nr < 0 || nr >= n || nc < 0 || nc >= m)
                    continue;
                if (visited[nr][nc])
                    continue;
                if (map[nr][nc] == 'X')
                    continue;
                queue.offer(new int[] {nr, nc});
                visited[nr][nc] = true;
            }
        }
        day.add(total);
    }
}