package university;

import java.util.Scanner;

public class BruteForceInversion {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the number : ");
        int size = scan.nextInt();
        int[] A = new int[size];

        System.out.print("Enter the arryay element : ");
        for(int i = 0; i < size; i++)
            A[i] = scan.nextInt();

        System.out.println("Inversion is : " + bruteForceInversion(A));
    }

    public static int bruteForceInversion(int[] A) {

        int size = A.length;
        int inversion = 0;

        for(int i = 0; i < size - 1; i++) {
            for(int j = i + 1; j < size; j++) {
                    if (A[i] > A[j])
                        inversion++;
            }
        }
        return inversion;
    }

}
