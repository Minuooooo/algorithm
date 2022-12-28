package backjoon.step01;

import java.util.Scanner;

public class ChessMain {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int[] chess = new int[6];
        for(int i = 0; i < 6; i++) {
            chess[i] = scan.nextInt();

            switch(i) {
                case 0:
                    sb.append(1 - chess[0]).append(" ");
                    break;
                case 1:
                    sb.append(1 - chess[1]).append(" ");
                    break;
                case 2:
                    sb.append(2 - chess[2]).append(" ");
                    break;
                case 3:
                    sb.append(2 - chess[3]).append(" ");
                    break;
                case 4:
                    sb.append(2 - chess[4]).append(" ");
                    break;
                case 5:
                    sb.append(8 - chess[5]).append(" ");
                    break;
            }
        }
        System.out.println(sb);
    }
}
