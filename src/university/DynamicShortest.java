package university;

import java.util.Scanner;

public class DynamicShortest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the low : ");
        int n = scan.nextInt();

        System.out.print("Enter the column : ");
        int m = scan.nextInt();
        System.out.println();

        int[][] M = new int[n + 1][m + 1];

        System.out.println("Draw the map.");
        for(int i = 0; i < n + 1; i++) {
            System.out.println("Enter the " + (i + 1) + "row : ");
            for(int j = 0; j < m + 1; j++)
                M[i][j] = scan.nextInt();
        }
        System.out.println();

        System.out.println("Your Map.");
        for(int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++)
                System.out.print(M[i][j] + " ");
            System.out.println();
        }
        System.out.println();

        System.out.println("Row : " + n + ", column : " + m);
        System.out.println("Shortest path is " + shortestPath(n, m, M));
    }
    public static int shortestPath(int n, int m, int[][] M) {
        int[][] p = new int[n + 1][m + 1];

        if(M[0][0] == 1)
            p[0][0] = 0;
        else
            p[0][0] = 1;

        for(int i = 1; i < m + 1; i++) {
            if(M[0][i] == 1)
                p[0][i] = 0;
            else
                p[0][i] = 1;
        }
        for(int i = 1; i < n + 1; i++) {
            if(M[i][0] == 1)
                p[i][0] = 0;
            else
                p[i][0] = 1;
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < m + 1; j++) {
                if(M[i][j] == 1)
                    p[i][j] = 0;
                else
                    p[i][j] = p[i][j - 1] + p[i - 1][j];
            }
        }

        return p[n][m];
    }
}
