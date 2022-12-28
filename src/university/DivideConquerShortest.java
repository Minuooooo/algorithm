package university;

import java.util.Scanner;

public class DivideConquerShortest {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the low : ");
        int n = scan.nextInt();

        System.out.print("Enter the column : ");
        int m = scan.nextInt();

        int[][] M = new int[n + 1][m + 1];

        System.out.println();
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
        System.out.println("Shortest path is " + shortestPath(n, m,M));
    }
    public static int shortestPath(int n, int m, int[][] M) {
        if(n == 0 || m == 0) {
            if(M[n][m] == 1)
                return 0;
            else
                return 1;
        } else {
            if(M[n][m] == 1)
                return 0;
            else
                return shortestPath(n, m - 1, M) + shortestPath(n - 1, m, M);
        }
    }
}
