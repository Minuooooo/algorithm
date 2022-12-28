package university;

import java.util.Scanner;

public class DivideConquerMinimum {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the array size : ");
        int size = scan.nextInt();
        int[] A = new int[size];

        System.out.print("Enter the number : ");
        for(int i = 0; i < size; i++)
            A[i] = scan.nextInt();

        System.out.println("minimum is : " + divConMinimum(A, 0, size - 1, A[0]));
    }

    public static int divConMinimum(int[] A, int low, int high, int min) {

        if(low == high) {

            min = A[low];
            return min;

        } else if(low == high - 1) {

            if(A[low] < A[high]) {
                min = A[low];
                return min;
            } else {
                min = A[high];
                return min;
            }

        } else {

            int mid = (low + high) / 2;

            int left = divConMinimum(A, low, mid, min);
            int right = divConMinimum(A, mid + 1, high, min);

            if(left < right)
                return left;
            else
                return right;

        }
    }
}
