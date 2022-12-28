package university;

import java.util.Scanner;

public class BruteForceMinimum {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the size : ");
        int size = scan.nextInt();
        int[] A = new int[size];

        System.out.print("Enter the number : ");
        for(int i = 0; i < size; i++)
            A[i] = scan.nextInt();

        System.out.println("Minimum is : " + bruteForceMinimum(A));
    }
    public static int bruteForceMinimum(int[] A) {

        int minimum = A[0];
        int len = A.length;

        for(int i = 1; i < len; i++) {
            if (A[i] < minimum)
                minimum = A[i];
        }
        return minimum;
    }
}
