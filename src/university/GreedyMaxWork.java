package university;

import java.util.Arrays;
import java.util.Scanner;

public class GreedyMaxWork {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter the array size : ");
        int size = scan.nextInt();
        int[] A = new int[size];

        System.out.print("Enter the array element : ");
        for(int i = 0; i < size; i++)
            A[i] = scan.nextInt();

        System.out.print("Enter the limit hour : ");
        int T = scan.nextInt();

        System.out.println();
        System.out.println(T + "hour limit max work : " + maxWork(size, A, T));
    }
    public static int maxWork(int size, int[] A, int T) {
       Arrays.sort(A);
       int work = 0;

       for(int i = 0; i < size; i++) {
           T -= A[i];
           if(T < 0)
               break;
           work++;
       }
       return work;
    }
}
