package university;

import java.util.Scanner;

public class DivideConquerRelocation {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the array size : ");
        int size = scan.nextInt();
        int[] A = new int[size];

        System.out.print("Enter the array element : ");
        for(int i = 0; i < size; i++)
            A[i] = scan.nextInt();

        divConRelocation(A, 0, size - 1);

        System.out.print("Relocate array : ");
        for(int i = 0; i < size; i++)
            System.out.print(A[i] + " ");
    }
    public static void divConRelocation(int[] A, int low, int high) {
        int i = low;
        int j = high;

        while(i <= j) {
            if(A[i] < 0)
                i++;
            else if(A[j] >= 0)
                j--;
            else {
                swap(A, i, j);
                i++;
                j--;
            }
        }
    }
    public static void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
