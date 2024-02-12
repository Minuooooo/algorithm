package programmers.level2.삼각달팽이;

public class Solution {
    public int[] solution(int n) {

        int[] answer = new int[n * (n + 1) / 2];
        int[][] map = new int[n][n];
        int curRow = -1;
        int curCol = 0;
        int num = 1;

        for (int i = 0; i < n; i++) {

            for (int j = i; j < n; j++) {

                if (i % 3 == 0) {

                    curRow++;
                }

                if (i % 3 == 1) {

                    curCol++;
                }

                if (i % 3 == 2) {

                    curRow--;
                    curCol--;
                }

                map[curRow][curCol] = num++;
            }
        }

        int index = 0;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j <= i; j++) {
                answer[index++] = map[i][j];
            }
        }

        return answer;
    }
}