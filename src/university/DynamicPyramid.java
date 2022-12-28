package university;

import java.util.Scanner;

public class DynamicPyramid {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Pyramid size is n * n");
        System.out.print("Enter the pyramid size n : ");
        int n = scan.nextInt();
        int[][] p = new int[n][n];

        System.out.print("Enter the route count : ");
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++)
                p[i][j] = scan.nextInt();
        }

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++)
                System.out.print(p[i][j] + " ");
            System.out.println();
        }
        System.out.println();
        System.out.println("Pyramid shortest path is " + pyramid(n, p));
    }
    public static int pyramid(int n, int[][] p) {
        int[][] shortest = new int[n][n];
        shortest[0][0] = p[0][0];

        for(int i = 1; i < n; i++) {
            shortest[i][0] = shortest[i - 1][0] + p[i][0];
            shortest[i][i] = shortest[i - 1][i - 1] + p[i][i];
        }

        for(int i = 2; i < n; i++) {
            for(int j = 1; j <= i - 1; j++)
                shortest[i][j] = min(shortest[i - 1][j - 1], shortest[i - 1][j]) + p[i][j];
        }

        int shortestPath = shortest[n - 1][0];
        for(int i = 1; i < n; i++)
            shortestPath = min(shortestPath, shortest[n - 1][i]);

        return shortestPath;
    }
    public static int min(int a, int b) {
        if(a < b)
            return a;
        else
            return b;
    }
}
