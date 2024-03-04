package programmers.level2.쿼드압축후개수세기;

public class Solution {
    private int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        dc(0, 0, arr.length, arr);
        return answer;
    }

    private void dc(int sr, int sc, int size, int[][] arr) {
        if (check(sr, sc, size, arr)) {
            answer[arr[sr][sc]]++;
            return;
        }
        dc(sr, sc, size / 2, arr);
        dc(sr + size / 2, sc, size / 2, arr);
        dc(sr, sc + size / 2, size / 2, arr);
        dc(sr + size / 2, sc + size / 2, size / 2, arr);
    }

    private boolean check(int r, int c, int size, int[][] arr) {
        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {
                if (arr[i][j] != arr[r][c])
                    return false;
            }
        }
        return true;
    }
}