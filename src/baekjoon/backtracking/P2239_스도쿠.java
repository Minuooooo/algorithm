package baekjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2239_스도쿠 {

    static int[][] board = new int[9][9];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 9; i++) {

            String str = br.readLine();

            for (int j = 0; j < 9; j++) {
                board[i][j] = str.charAt(j) - '0';
            }
        }

        play();
    }

    public static void play() {

        int[] index = findZeroIndex();

        if (index[0] == -1) {
            printBoard();
            System.exit(0);
        }

        for (int i = 1; i <= 9; i++) {

            if (validatePosition(index, i)) {

                board[index[0]][index[1]] = i;
                play();

                board[index[0]][index[1]] = 0;
            }
        }
    }

    public static int[] findZeroIndex() {

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                if (board[i][j] == 0)
                    return new int[] {i, j};
            }
        }

        return new int[] {-1, -1};
    }

    public static boolean validatePosition(int[] index, int num) {

        int row = index[0];
        int column = index[1];

        for (int i = 0; i < 9; i++) {

            if (board[row][i] == num || board[i][column] == num)
                return false;
        }

        int sameRowStartIndex = (row / 3) * 3;
        int sameColumnStartIndex = (column / 3) * 3;

        for (int i = sameRowStartIndex; i < sameRowStartIndex + 3; i++) {

            for (int j = sameColumnStartIndex; j < sameColumnStartIndex + 3; j++) {

                if (board[i][j] == num)
                    return false;
            }
        }

        return true;
    }

    public static void printBoard() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                sb.append(board[i][j]);
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}