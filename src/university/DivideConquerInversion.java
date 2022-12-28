package university;

import java.util.Scanner;

public class DivideConquerInversion {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the size : ");
        int size = scan.nextInt();
        int[] A = new int[size];

        System.out.print("Enter the array element : ");
        for(int i = 0; i < size; i++)
            A[i] = scan.nextInt();

        System.out.println("Inversion is : " + divConInv(A, 0, size - 1));
    }
    public static int divConInv(int[] A, int low, int high) {

        int totalInv = 0;

        if(low < high) {
            int mid = (low + high) / 2;
            totalInv += divConInv(A, low, mid);
            totalInv += divConInv(A, mid + 1, high);
            totalInv += merge(A, low, mid, high);
        }
        return totalInv;
    }
    public static int merge(int[] A, int low, int mid, int high) {

        int[] B = new int[high + 1];
        int inv = 0;
        int temp = low;
        int i = low;
        int j = mid + 1;

        while(i <= mid && j <= high) {
            if(A[i] > A[j]) {
                B[temp] = A[j];
                j++;
                inv += mid - i + 1;
            } else {
                B[temp] = A[i];
                i++;
            }
            temp++;
        }

        if(i > mid) {
            for(int k = j; k <= high; k++) {
                B[temp] = A[k];
                temp++;
            }
        } else {
            for(int k = i; k <= mid; k++) {
                B[temp] = A[k];
                temp++;
            }
        }

        for(int k = low; k <= high; k++)
            A[k] = B[k];

        return inv;
    }
}
